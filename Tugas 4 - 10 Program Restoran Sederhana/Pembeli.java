import java.util.Scanner ;
class Pembeli
{
    //attribut kelas pembeli
    protected String nama ;
    
    //protected variabel
    protected double potongan, kembalian, total_bayar, pajak ;
    protected int bangku, uang_masuk ; 
    
    //konstanta dengan kata kunci final
    private static final double PPN = 0.1 ; 
    
    //private variabel 
    private double diskon_awal ; 
    
    //getter dan setter diskon_awal    
    protected double getDiskon_awal()
    {
        return diskon_awal ;
    }
    
    public void setDiskon_awal(double diskon_awal) 
    {
        this.diskon_awal = diskon_awal ;
    }         
    
    //inisiasi Scanner
    Scanner input = new Scanner(System.in) ;

    //penginput nama dan bangku pembeli
    public String isiNama() 
    {
        System.out.print("Silakan Masukkan Nama Pembeli \t\t: ") ;
        return input.nextLine() ;
    }
 
    public int isiBangku()
    {
      System.out.print("Silakan Masukkan Nomor Bangku Pembeli \t: ") ;
        return input.nextInt() ;  
    }        
    
    //setter nama dan bangku pembeli
    protected void setNama(String nama)
    {
      this.nama = nama ;  
    }
    
    
    protected void setBangku(int bangku)
    {
      this.bangku = bangku ;  
    }
    
    //fungsi pemilihan menu pembeli
    public int pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Pembeli \t: ") ;
        return input.nextInt() ;    

    }
   
    //fungsi pengecek pesanan dibawa pulang atau tidak
    public boolean pembungkusan()
    {   
        
        System.out.print("Dibungkus untuk pulang? [Y/T] \t\t: ") ;
        char pulang = input.next().charAt(0) ;
        return (pulang == 'Y' || pulang  == 'y') ;     
                
    }        
    
    //penghitung potongan pembeli
    protected void hitungPotongan(int pembayaran)
    {
        if ((pembayaran) >= 18000)
            potongan = getDiskon_awal() * pembayaran ;
          
    }
    
    //pengisi uang masuk 
    protected void isiUangMasuk()
    {   
        System.out.print("\nUang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ; 
    }        
    
    //prosedur overload, yang ini tanpa parameter bungkus
    public void transaksi(int harga) 
    {   
        this.hitungPotongan(harga) ;
        total_bayar = (harga - potongan) ;
        pajak = (PPN*total_bayar) ;
        total_bayar += pajak ;
        
        System.out.println("\nHarga makanan \t\t\t\t: " +harga) ;
        System.out.printf("Potongan harga \t\t\t\t: %.0f\n",potongan) ;
        System.out.printf("Pajak PPN (10 persen) \t\t\t: %.0f\n",pajak) ; 
        System.out.printf("Total Bayar \t\t\t\t: %.0f\n",total_bayar) ;
        
        
        isiUangMasuk() ;
        
        kembalian   = uang_masuk - total_bayar ;
        System.out.printf("Kembalian \t\t\t\t: %.0f\n",kembalian) ;
    }
    
    //prosedur overload, yang ini dengan parameter bungkus
    public void transaksi(int harga, int bungkus) 
    {   
        
      
        this.hitungPotongan(harga+bungkus) ;
        total_bayar = harga + bungkus - potongan ;
        pajak = (PPN*total_bayar) ;
        total_bayar += pajak ;
        
        System.out.println("\nHarga makanan \t\t\t\t: " +harga) ;
        System.out.println("Harga bungkusnya \t\t\t: " +bungkus) ;
        System.out.printf("Potongan harga \t\t\t\t: %.0f\n",potongan) ;
        System.out.printf("Pajak PPN (10 persen) \t\t\t: %.0f\n",pajak) ; 
        System.out.printf("Total Bayar \t\t\t\t: %.0f\n",total_bayar) ;
        
        isiUangMasuk() ;
        
        kembalian = uang_masuk - total_bayar ;
        System.out.printf("Kembalian \t\t\t\t: %.0f\n",kembalian) ;
        
    }
    
  protected void Banner()
  {
       System.out.println("\nTerimakasih atas kedatangannya pembeli "+nama+" ^_^\n") ; 
  }
   

}

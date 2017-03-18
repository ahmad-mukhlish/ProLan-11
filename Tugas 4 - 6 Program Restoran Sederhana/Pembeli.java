import java.util.Scanner ;
class Pembeli
{
    //variabel global kelas pembeli

    String nama ;
    double potongan, kembalian, total_bayar, pajak ;
    int bangku, uang_masuk, pilihan  ; 
    static final double DISCOUNT = 0.05, PPN = 0.1 ;
        
    
    //inisiasi Scanner
    Scanner input = new Scanner(System.in) ;

    //method - method pembeli
    
    //fungsi - fungsi pengisian data pembeli 
    public String getNama() 
    {
        System.out.print("Silakan Masukkan Nama Pembeli \t\t: ") ;
        return input.nextLine() ;
        

    }
    
    public int getBangku()
    {
      System.out.print("Silakan Masukkan Nomor Bangku Pembeli \t: ") ;
        return input.nextInt() ;  
    }        
    
    //penggunaan keyword this pada method
    
    //prosedur - prosedur penyetel data pembeli
    
    public void setNama(String nama)
    {
      this.nama = nama ;  
    }
    
    
    public void setBangku(int bangku)
    {
      this.bangku = bangku ;  
    }
    
    //prosedur penampil menu yang tersedia
  
    
    //fungsi pemilihan menu dengan nilai balik char
    public void pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Pembeli \t: ") ;
        pilihan = input.nextInt() ;    

    }
   
    public boolean pembungkusan()
    {   
        
        System.out.print("Dibungkus untuk pulang? [Y/T] \t\t: ") ;
        char pulang = input.next().charAt(0) ;
        return (pulang == 'Y' || pulang  == 'y') ;     
                
    }        
    
    
    public void hitungPotongan(int pembayaran)
    {
        if ((pembayaran) >= 18000)
            potongan = DISCOUNT * pembayaran ;
          
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
        
        System.out.print("\nUang masuk pembeli \t\t\t: ") ;
        uang_masuk  = input.nextInt() ; 
        
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
        
        System.out.print("\nUang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ;
        
        kembalian = uang_masuk - total_bayar ;
        System.out.printf("Kembalian \t\t\t\t: %.0f\n",kembalian) ;
        
    }
    
   

}

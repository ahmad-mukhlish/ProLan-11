import java.util.Scanner ;
class Pembeli
{
    //variabel global kelas pembeli

    String nama ;
    int bangku ;
    static int uang_masuk, kembalian, pilihan  ; 
        
    
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
        
        System.out.print("Makan disini? [Y/T] \t\t\t: ") ;
        char pulang = input.next().charAt(0) ;
        return (pulang == 'Y' || pulang  == 'y') ;     
                
    }        
    
    
    //prosedur overload, yang ini tanpa parameter bungkus
    public void transaksi(int harga) 
    { 
        System.out.print("Uang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ;
        kembalian = uang_masuk - harga ;
        System.out.println("\nHarga makanan \t\t\t\t: " + harga + "\nUang kembalian pembeli \t\t\t: " +kembalian+"\n") ;

    }
    
    //prosedur overload, yang ini dengan parameter bungkus
     public void transaksi(int harga, int bungkus) 
    { 
        System.out.print("Uang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ;
        kembalian = uang_masuk - harga - bungkus ;
        System.out.println("\nHarga makanan \t\t\t\t: " +harga+ "\nHarga pembungkusan untuk dibawa \t: " +bungkus+  "\nUang kembalian pembeli \t\t\t: " +kembalian+"\n") ;

    }
    
   

}
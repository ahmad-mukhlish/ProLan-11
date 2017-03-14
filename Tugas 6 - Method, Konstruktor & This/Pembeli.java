import java.util.Scanner ;
class Pembeli
{
    //variabel global kelas pembeli

    String nama ;
    int bangku ;
    int uang_masuk, kembalian ;

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
    public void tampilkan()      
    { 
      Makanan tampil1 = new Makanan('A') ;
      Makanan tampil2 = new Makanan('B') ;
      Makanan tampil3 = new Makanan('C') ;
      Makanan tampil4 = new Makanan('D') ;
      Makanan tampil5 = new Makanan('E') ;
      System.out.println("\nPaket A : "+tampil1.nama_makanan+" "+tampil1.harga) ;   
      System.out.println("Paket B : "+tampil2.nama_makanan+" "+tampil2.harga) ;
      System.out.println("Paket C : "+tampil3.nama_makanan+" "+tampil3.harga) ;  
      System.out.println("Paket D : "+tampil4.nama_makanan+" "+tampil4.harga) ;
      System.out.println("Paket E : "+tampil5.nama_makanan+" "+tampil5.harga) ;  
     
    }
    
    //fungsi pemilihan menu dengan nilai balik char
    public char pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Pembeli \t: ") ;
        return input.next().charAt(0) ;    

    }
   
    public boolean pembungkusan()
    {   
        
        System.out.print("Makan sini atau bawa pulang? [Y/T] \t: ") ;
        char pilihan = input.next().charAt(0) ;
        return (pilihan == 'Y' || pilihan  == 'y') ;     
                
    }        
    
    
    //prosedur overload, yang ini tanpa parameter bungkus
    public void transaksi(int harga) 
    { 
        System.out.print("Uang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ;
        kembalian = uang_masuk - harga ;
        System.out.println("\nHarga makanan : " + harga + "\nUang kembalian pembeli : " +kembalian+"\n") ;

    }
    
    //prosedur overload, yang ini dengan parameter bungkus
     public void transaksi(int harga, int bungkus) 
    { 
        System.out.print("Uang masuk pembeli \t\t\t: ") ;
        uang_masuk = input.nextInt() ;
        kembalian = uang_masuk - harga - bungkus ;
        System.out.println("\nHarga makanan : " +harga+ "\nHarga pembungkusan untuk dibawa : " +bungkus+  "\nUang kembalian pembeli : " +kembalian+"\n") ;

    }
    
   

}

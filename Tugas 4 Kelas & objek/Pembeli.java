import java.util.Scanner ;
import static  Makanan.ayam ;
import static  Makanan.sop_iga ;
import static  Makanan.batagor ;
import static  Makanan.burger ;
import static  Makanan.pasta ;



 
   class Pembeli 
  {
  //variabel global kelas pembeli
  String nama ;   
  Integer nomor_bangku ;
  Makanan pesanan ;
  long uang_masuk, kembalian ;
  
  //inisiasi Scanner
  Scanner input = new Scanner (System.in) ;
  //inisiasi Pembeli objek global 
  static Pembeli customer = new Pembeli() ;
  
 //metoda pengendali kelas pembeli
 public static void main(String args[])
 {  
     
   customer.data() ;
   customer.liat_menu() ; 
   customer.transaksi() ;
   
      
      
 }  
 
   
 
  //method - method pembeli
  private void liat_menu()
  {
   Makanan makan = new Makanan() ;
   makan.inisiasi_menu_makanan() ;
   makan.tampil_menu_makanan() ;
  }
 
  private void data()
          
 {
  System.out.print("Silakan Masukkan Nama Pembeli : ") ; customer.nama = input.nextLine() ;
  System.out.print("Silakan Masukkan Nomor Bangku Pembeli : ") ; customer.nomor_bangku = input.nextInt() ;
  
 }

  public Integer pilih_menu()
 { Integer menu ;  
   System.out.println() ;
   System.out.print("Silakan Masukan Pilihan Pembeli : ") ; menu = input.nextInt() ; 
    return menu ;      
      
     
 
     
 }    
  
  void transaksi( )
  {int pilihan ;
   pilihan = customer.pilih_menu() ;
   long harga ;
       
   
    
   if (pilihan == 1) 
       harga = ayam.harga ;
   else if (pilihan == 2)
       harga = sop_iga.harga ;
   else if (pilihan == 3)
       harga = batagor.harga ;
   else if (pilihan == 4)
       harga = burger.harga ;
   else
      harga = pasta.harga ; 
               
           
   System.out.print("Uang masuk pembeli : ") ; customer.uang_masuk = input.nextLong(); 
   customer.kembalian = customer.uang_masuk - harga ;
   System.out.println( "Harga makanan "+harga+" Uang kembalian pembeli : "+customer.kembalian) ;
      
  } 
  
   
  
  
}
 

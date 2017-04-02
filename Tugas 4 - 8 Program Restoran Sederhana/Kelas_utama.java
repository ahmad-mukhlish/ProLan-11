import java.util.Date ;
import java.text.SimpleDateFormat ;


public class Kelas_utama {
    
    public static void main(String args[]) 
    { //deklarasi objek - objek yang digunakan :
      
        Langganan customer = new Langganan() ;   

      
      //deklarasi date dan sdf-nya
      Date tanggal = new Date() ;
      SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy") ;
      
      //deklarasi variabel lokal 
      int i ;
      
      //header program
      System.out.println("\nProgram Restoran Sangat Sederhana") ;
      System.out.println("---------------------------------\n") ;
      System.out.println("Tanggal \t\t\t\t: "+penanggalan.format(tanggal)); 
      customer.setNama(customer.getNama()) ;
      customer.setBangku(customer.getBangku()) ;
      
      System.out.println() ;
      
      for (i=1 ; i<6 ; i++)
       { //penggunaan method static tampilkan dengan referensi kelas Makanan dan objek anonim pada kelas Makanan
           System.out.println(Makanan.tampilkan(new Makanan(i), i, true)) ;
            
       }
      
       System.out.println() ;
       
       int pilihan_makanan = customer.pilih_menu() ;
       Makanan Pesanan = new Makanan(pilihan_makanan) ;
       System.out.println("Makanan yang Anda pilih adalah          : {"+Makanan.tampilkan(Pesanan, pilihan_makanan, Pesanan.jadi)+"}") ; 
           
       
       System.out.println() ;
       
       for (i=1 ; i<6 ; i++)
       { //penggunaan method static tampilkan dengan referensi kelas Minuman dan objek anonim pada kelas Minuman
           System.out.println(Minuman.tampilkan(new Minuman(i), i, true)) ;
       }
      
       int pilihan_minuman = customer.pilih_menu() ;
       Minuman pesanan = new Minuman(pilihan_minuman) ;
       System.out.println("Minuman yang Anda pilih adalah          : {"+Minuman.tampilkan(pesanan, pilihan_minuman, pesanan.jadi)+"}") ; 
       
      

      
      System.out.println() ;
      
      if ((Pesanan.jadi) || (pesanan.jadi))
       {    
        if (customer.pembungkusan())
          customer.transaksi(Pesanan.harga+pesanan.harga,Pesanan.bungkusnya+pesanan.bungkusnya) ;
        else
          customer.transaksi(Pesanan.harga+pesanan.harga) ; 
       }  
      
       
      System.out.println("\nTerimakasih atas kedatangannya ^_^\n") ; 
      
          
              
      
    }
    
    
    
    
}

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
         Makanan.tampilkan(new Makanan(i), i) ;
       }
      
       System.out.println() ;
       
       int pilihan_makanan = customer.pilih_menu() ;
       
       System.out.println() ;
       
       for (i=1 ; i<6 ; i++)
       { //penggunaan method static tampilkan dengan referensi kelas Minuman dan objek anonim pada kelas Minuman
         Makanan.tampilkan(new Minuman(i), i) ;
       }
      
       int pilihan_minuman = customer.pilih_menu() ;
       
      Makanan Pesanan = new Makanan(pilihan_makanan) ;
      Minuman pesanan = new Minuman(pilihan_minuman) ;
      
      System.out.println() ;
      
      if ((Pesanan.jadi) && (pesanan.jadi))
       {    
        if (customer.pembungkusan())
          customer.transaksi(Pesanan.harga+pesanan.harga,Pesanan.bungkusnya+pesanan.bungkusnya) ;
        else
          customer.transaksi(Pesanan.harga+pesanan.harga) ; 
       }  
      
       
      System.out.println("\nTerimakasih atas kedatangannya ^_^\n") ; 
      
          
              
      
    }
    
    
    
    
}

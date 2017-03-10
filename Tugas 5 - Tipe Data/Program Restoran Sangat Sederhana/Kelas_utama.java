import java.util.Date ;
import java.text.SimpleDateFormat ;


public class Kelas_utama {
    
    public static void main(String args[]) 
    { //deklarasi objek - objek yang digunakan :
      Pembeli customer = new Pembeli() ;
      Makanan Pesanan = new Makanan() ;
      
      //deklarasi date dan sdf-nya
      Date tanggal = new Date() ;
      SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy") ;
      
      
      //header program
      System.out.println("\nProgram Restoran Sangat Sederhana") ;
      System.out.println("---------------------------------\n") ;
      System.out.println("Tanggal : "+penanggalan.format(tanggal)); 
      customer.data() ;
      Pesanan.tampilkan() ;
      customer.pilih_menu() ;
      Pesanan.inisiasi_menu_makanan(customer.paket);
      customer.transaksi(Pesanan.harga) ;
	  System.out.println("\nTerimakasih atas kunjungannya ^-^\n") ;
    }
}
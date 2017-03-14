import java.util.Date ;
import java.text.SimpleDateFormat ;


public class Kelas_utama {
    
    public static void main(String args[]) 
    { //deklarasi objek - objek yang digunakan :
      Pembeli customer = new Pembeli() ;
     
      
      //deklarasi date dan sdf-nya
      Date tanggal = new Date() ;
      SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy") ;
      
      
      //header program
      System.out.println("\nProgram Restoran Sangat Sederhana") ;
      System.out.println("---------------------------------\n") ;
      System.out.println("Tanggal \t\t\t\t: "+penanggalan.format(tanggal)); 
      customer.setNama(customer.getNama()) ;
      customer.setBangku(customer.getBangku()) ;
      customer.tampilkan() ;
      Makanan Pesanan = new Makanan(customer.pilih_menu()) ;
      if (Pesanan.jadi)
       {    
        if (customer.pembungkusan())
         customer.transaksi(Pesanan.harga,Pesanan.bungkusnya) ;
        else
         customer.transaksi(Pesanan.harga) ; 
       }  
       
      System.out.println("\nTerimakasih atas kedatangannya ^_^\n") ; 
      
          
              
      
    }
}

import java.util.Date ;
import java.text.SimpleDateFormat ;


public class Kelas_utama {
    
    public static void main(String args[]) 
    { //deklarasi objek - objek yang digunakan :
      Pembeli customer = new Pembeli() ;
     
      
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
      customer.pilih_menu() ;
      //penggunaan static variabel pilihan dengan referensi kelas Pembeli 
      Makanan Pesanan = new Makanan(Pembeli.pilihan) ;
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

import java.util.Date ;
import java.text.SimpleDateFormat ;


public class Kelas_utama {
    
    public static void main(String args[]) 
    { //deklarasi objek umum yang digunakan :
       Pembeli customer ;

      
      //deklarasi date dan sdf-nya
      Date tanggal = new Date() ;
      SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy") ;
      
      //deklarasi variabel lokal 
      int i ;
      
      
      
      //header program
      System.out.println("\nProgram Restoran Sangat Sederhana") ;
      System.out.println("---------------------------------\n") ;
      System.out.println("Tanggal \t\t\t\t: "+penanggalan.format(tanggal)); 
      
      
      //mementukan apakah customer adalah pembeli biasa atau pelanggan
      if(Langganan.cekLangganan())
       {Langganan langganan = new Langganan() ;
        customer = langganan ;}
      else 
      {Pembeli pembeli =  new Pembeli() ;
       customer = pembeli ;}
      
      //isi Nama dan bangku customer
      customer.setNama(customer.isiNama()) ;
      customer.setBangku(customer.isiBangku()) ;
      
       //set diskon customer
      customer.setDiskon_awal(0.05) ;
      
      
      System.out.println() ;
      
      //tampilkan menu makanan
      for (i=1 ; i<6 ; i++)
       { //penggunaan method static tampilkan dengan referensi kelas Makanan dan objek anonim pada kelas Makanan
           System.out.println(Makanan.tampilkan(new Makanan(i),"makanan",i, true)) ;
            
       }
      
       System.out.println() ;
       
       //pemilihan menu makanan
       int pilihan_makanan = customer.pilih_menu() ;
       //instansi objek makanan
       Makanan makanan = new Makanan(pilihan_makanan) ;
       //output objek makanan yang dipilih
       System.out.println("Makanan yang Anda pilih adalah          : {"+makanan.tampilan+"}") ; 
           
       
       System.out.println() ;
       
       //tampilkan menu minuman
       for (i=1 ; i<6 ; i++)
       { //penggunaan method static tampilkan dengan referensi kelas Minuman dan objek anonim pada kelas Minuman
           System.out.println(Minuman.tampilkan(new Minuman(i),"minuman",i, true)) ;
       }
      
       //pemilihan menu minuman
       int pilihan_minuman = customer.pilih_menu() ;
       //instansi objek minuman
       Minuman minuman = new Minuman(pilihan_minuman) ;
       //output minuman yang dipilih
       System.out.println("Minuman yang Anda pilih adalah          : {"+minuman.tampilan+"}") ; 
       
      

      
      System.out.println() ;
      
      //cek validasi transaksi
      if ((makanan.jadi) || (minuman.jadi))
       {
        //cek apakah transaksi dibungkus atau tidak   
        if (customer.pembungkusan())
          customer.transaksi(makanan.harga+minuman.harga,makanan.bungkusnya+minuman.bungkusnya) ;
        else
          customer.transaksi(makanan.harga+minuman.harga) ; 
       }  
      
       
      System.out.println("\nTerimakasih atas kedatangannya ^_^\n") ; 
      
          
              
      
    }
    
    
    
    
}

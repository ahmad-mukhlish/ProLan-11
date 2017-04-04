public class Minuman extends Makanan {
 
    //attribut khusus kelas minuman
    String keterangan_minuman ;
    
    //override konstruktor
    Minuman(int paket)
    {  
        //panggil super
        super(paket) ;
        //isi keterangan minuman
        keterangan_minuman = "minuman" ;
        //timpa tampilan dengan keterangan minuman
        tampilan = Minuman.tampilkan(this,keterangan_minuman,paket,this.jadi) ;
        
    }       
    
    
    
    @Override
   public void setProduk(int pilihan)
   {
     boolean jadi = true ;   
     switch (pilihan) 
        {case 1 : {nama_produk = "Es kelapa muda" ; 
                                harga = 7000 ;
                                bungkusnya = 1000 ;
                                break ;}
       
         case 2 : {nama_produk = "Es Cingcau" ;
                                 harga = 8000 ;
                                 bungkusnya = 1500 ;
                                 break ;}
         
         case 3 : {nama_produk = "Jeruk Panas" ;
                                 harga = 6000 ;
                                 bungkusnya = 700 ;
                                 break ;}
         
         case 4 : {nama_produk = "Es campur" ;
                                harga = 11000 ;
                                bungkusnya = 1200 ;
                                break ;}
         
         case 5 : {nama_produk = "Air putih" ;
                                harga = 0 ;
                                bungkusnya = 0 ;
                                break ;}
         
         default             :{nama_produk = "Menu yang Anda pilih tidak tersedia..." ;
                               jadi = false ;
                               break ;}
        }
     
      this.jadi = jadi ;
   }       
     
}

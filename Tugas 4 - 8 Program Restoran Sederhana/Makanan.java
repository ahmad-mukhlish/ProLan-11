public class Makanan {

    //variabel instance kelas makanan
    String nama_produk ;
    static int harga, bungkusnya, jenis ;
    boolean jadi ;
    int coba ;
  
    
   

     //konstruktor makanan dan penggunaan this pada konstruktor berupa variabel
    Makanan(int paket) 
    {
        setProduk(paket) ;
    }
    
      public static String tampilkan(Makanan penampil, int kode, boolean valid)      
    { 
      if (valid)  
       return "Paket "+kode+"  : "+penampil.nama_produk+" "+penampil.harga ;   
      else
       return penampil.nama_produk ;   
    }
       
   public void setProduk(int pilihan)
   {
     boolean jadi = true ;
     switch (pilihan) 
        {case 1 : {nama_produk = "Ayam goreng + nasi" ; 
                                harga = 18000 ;
                                bungkusnya = 1000 ;
                                break ;}
       
         case 2 : {nama_produk = "Sop iga + nasi" ;
                                 harga = 23000 ;
                                 bungkusnya = 2000 ;
                                 break ;}
         
         case 3 : {nama_produk = "Batagor spesial" ;
                                 harga = 15000 ;
                                 bungkusnya = 700 ;
                                 break ;}
         
         case 4 : {nama_produk = "Cheese Burger" ;
                                harga = 13000 ;
                                bungkusnya = 400 ;
                                break ;}
         
         case 5 : {nama_produk = "Pasta mozarella" ;
                                harga = 19000 ;
                                bungkusnya = 800 ;
                                break ;}
         
         default             :{nama_produk = "Menu yang Anda pilih tidak tersedia..." ;
                               jadi = false ;
                               break ;}
        
        }  
     
      this.jadi = jadi ;
   }        
    
    
 
    
   
      

        
}
    
    
    
    
 
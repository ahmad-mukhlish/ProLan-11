public class Makanan {

    //variabel instance kelas makanan
    String nama_produk ;
    int harga, bungkusnya, jenis ;
    boolean jadi ;
    int coba ;
  
    
   

     //konstruktor makanan dan penggunaan this pada konstruktor berupa variabel
    Makanan(int paket) 
    {
        boolean jadi ;
        jadi = true ;
        
        setProduk(paket) ;
        
        
        this.jadi = jadi ;
    }
    
      public static void tampilkan(Makanan penampil, int kode)      
    { 
      System.out.println("Paket "+kode+"  : "+penampil.nama_produk+" "+penampil.harga) ;   
    }
       
   public void setProduk(int pilihan)
   {
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
         
         default             :{System.out.println("Menu yang Anda pilih tidak tersedia...") ;
                               jadi = false ;
                               break ;}
        }  
   }        
    
    
 
    
   
      

        
}
    
    
    
    
 
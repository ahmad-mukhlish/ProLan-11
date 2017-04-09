public class Makanan {

    //attribut kelas makanan
    protected String nama_produk, tampilan ;
    protected int harga, bungkusnya, jenis ;
    protected boolean jadi ;
    
    //konstanta string khusus kelas makanan
    private final String keterangan_makanan = "makanan"  ;
    
   

     //konstruktor makanan
    Makanan(int paket) 
    {
        setProduk(paket) ;
        //isi string tampilan
        tampilan = Makanan.tampilkan(this,keterangan_makanan,paket,this.jadi) ;
        
        
    }
    
      public static String tampilkan(Makanan penampil, String keterangan, int kode, boolean valid)      
    { 
      if (valid)  
       return "Paket "+keterangan+" "+kode+"  : "+penampil.nama_produk+" "+penampil.harga ;   
      else
       return penampil.nama_produk ;   
    }
       
   protected void setProduk(int pilihan)
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
    
    
    
    
 

    
    
    
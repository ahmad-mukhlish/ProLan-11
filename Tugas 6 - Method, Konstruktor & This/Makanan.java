public class Makanan {

    //variabel instance kelas makanan
    String nama_makanan ;
    int harga, bungkusnya ;
    boolean jadi ;
    
    
  

     //konstruktor makanan dan penggunaan this pada konstruktor berupa variabel
    Makanan(char paket) 
    {
        boolean jadi ;
        jadi = true ;
        
        switch (paket) 
        {case 'a' : case 'A' : {nama_makanan = "Ayam goreng + nasi" ; 
                                harga = 18000 ;
                                bungkusnya = 1000 ;
                                break ;}
       
         case 'b' : case 'B' :  {nama_makanan = "Sop iga + nasi" ;
                                 harga = 23000 ;
                                 bungkusnya = 2000 ;
                                 break ;}
         
         case 'c' : case 'C' :  {nama_makanan = "Batagor spesial" ;
                                 harga = 15000 ;
                                 bungkusnya = 700 ;
                                 break ;}
         
         case 'd' : case 'D' : {nama_makanan = "Cheese Burger" ;
                                harga = 13000 ;
                                bungkusnya = 400 ;
                                break ;}
         
         case 'e' : case 'E' : {nama_makanan = "Pasta mozarella" ;
                                harga = 19000 ;
                                bungkusnya = 800 ;
                                break ;}
         
         default             :{System.out.println("Menu yang Anda pilih tidak tersedia...") ;
                               jadi = false ;
                               break ;}
        }
        
        this.jadi = jadi ;
    }
       
   
    
    
 
    
   
      
    
    
    
    
}
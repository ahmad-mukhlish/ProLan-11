public class Makanan  
{
    //variabel global kelas makanan
     String nama_makanan ;
     long harga ;
     
     public static Makanan ayam = new Makanan() ; 
     public static Makanan sop_iga = new Makanan() ; 
     public static Makanan batagor = new Makanan() ; 
     public static Makanan burger = new Makanan() ; 
     public static Makanan pasta = new Makanan() ; 
     
     
     
     
     //method - method makanan
     public void inisiasi_menu_makanan()
     {  
        ayam.nama_makanan = "Ayam goreng + nasi" ;
        ayam.harga = 18000 ;
        
        
        sop_iga.nama_makanan = "Sop iga + nasi" ;
        sop_iga.harga = 23000 ;
        
        
        batagor.nama_makanan = "Batagor spesial" ;
        batagor.harga = 17000 ;
        
        
        burger.nama_makanan = "Cheese Burger" ;
        burger.harga = 13000 ;
        
        
        pasta.nama_makanan = "Pasta mozarella" ;
        pasta.harga = 24000 ;
        
       
        
                   
     }  
     
      public void tampil_menu_makanan()
     {  
        System.out.println() ;
        System.out.println("1. "+ayam.nama_makanan+" Harganya "+ayam.harga);
        System.out.println("2. "+sop_iga.nama_makanan+" Harganya "+sop_iga.harga);
        System.out.println("3. "+batagor.nama_makanan+" Harganya "+batagor.harga);
        System.out.println("4. "+burger.nama_makanan+" Harganya "+burger.harga);
        System.out.println("5. "+pasta.nama_makanan+" Harganya "+pasta.harga);
        
        
                   
     } 
}
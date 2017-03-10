public class Makanan {

    //variabel global kelas makanan
    String nama_makanan;
    int harga;

       
    //method - method makanan
    
    
    public void tampilkan()      
    {Makanan pesanan = new Makanan() ;
     pesanan.inisiasi_menu_makanan('A');
     System.out.println("\nPaket A : "+pesanan.nama_makanan+" "+pesanan.harga) ;   
     pesanan.inisiasi_menu_makanan('B');
     System.out.println("Paket B : "+pesanan.nama_makanan+" "+pesanan.harga) ;
     pesanan.inisiasi_menu_makanan('C');
     System.out.println("Paket C : "+pesanan.nama_makanan+" "+pesanan.harga) ;  
     pesanan.inisiasi_menu_makanan('D');
     System.out.println("Paket D : "+pesanan.nama_makanan+" "+pesanan.harga) ;
     pesanan.inisiasi_menu_makanan('E');
     System.out.println("Paket E : "+pesanan.nama_makanan+" "+pesanan.harga) ;  
     
    }
    
    
    public void inisiasi_menu_makanan(char paket) 
    {
 
        
        switch (paket) 
        {case 'a' : case 'A' : {nama_makanan = "Ayam goreng + nasi" ; 
                                harga = 18000 ;
                                break ;}
       
         case 'b' : case 'B' :  {nama_makanan = "Sop iga + nasi" ;
                                 harga = 23000 ;
                                 break ;}
         
         case 'c' : case 'C' :  {nama_makanan = "Batagor spesial" ;
                                 harga = 15000 ;
                                 break ;}
         
         case 'd' : case 'D' : {nama_makanan = "Cheese Burger" ;
                                harga = 13000 ;
                                break ;}
         
         case 'e' : case 'E' : {nama_makanan = "Pasta mozarella" ;
                                harga = 19000 ;
                                break ;}
         
         default             :{System.out.println("Menu yang Anda pilih tidak tersedia...") ;
                               break ;}
        }
      

        

    }
    
    
    
    
}
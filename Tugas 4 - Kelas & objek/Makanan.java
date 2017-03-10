 
public class Makanan {

    //variabel global kelas makanan
    String nama_makanan;
    int harga;

       
    //method - method makanan
    
    
    public void tampilkan()      
    {Makanan pesanan = new Makanan() ;
     pesanan.inisiasi_menu_makanan(1);
     System.out.println("\n1. "+pesanan.nama_makanan+" "+pesanan.harga) ;   
     pesanan.inisiasi_menu_makanan(2);
     System.out.println("2. "+pesanan.nama_makanan+" "+pesanan.harga) ;
     pesanan.inisiasi_menu_makanan(3);
     System.out.println("3. "+pesanan.nama_makanan+" "+pesanan.harga) ;  
     pesanan.inisiasi_menu_makanan(4);
     System.out.println("4. "+pesanan.nama_makanan+" "+pesanan.harga) ;
     pesanan.inisiasi_menu_makanan(5);
     System.out.println("5. "+pesanan.nama_makanan+" "+pesanan.harga) ;  
     
    }
    
    
    public void inisiasi_menu_makanan(int menu) 
    {
 
        
        switch (menu) 
        {case 1 : {this.nama_makanan = "Ayam goreng + nasi" ; 
                   this.harga = 18000 ;
                   break ;}
       
         case 2 : {this.nama_makanan = "Sop iga + nasi" ;
                   this.harga = 23000 ;
                   break ;}
         
         case 3 : {this.nama_makanan = "Batagor spesial" ;
                   this.harga = 15000 ;
                   break ;}
         
         case 4 : {this.nama_makanan = "Cheese Burger" ;
                   this.harga = 13000 ;
                   break ;}
         
         case 5 : {this.nama_makanan = "Pasta mozarella" ;
                   this.harga = 19000 ;
                   break ;}
         
         default :{System.out.println("Menu yang Anda pilih tidak tersedia...") ;
                   break ;}
        }
      

        

    }
    
    
    
    
}
import java.util.Scanner ; 

//kelas Langganan, subclass dari Pembeli
public class Langganan extends Pembeli {
    
       //attribut tambahan kelas langganan
       double diskon_langganan ;

       //prosedur static pengecek langganan
      static boolean cekLangganan()
    {
        Scanner inputan = new Scanner(System.in) ; 
        System.out.print("Anda memiliki kartu langganan? [Y/T] \t: ") ;
        char cek = inputan.next().charAt(0) ;
        return (cek == 'Y' || cek  == 'y') ; 
        
        
    } 
      
    //override method hitung potongan, bila member potongannya ditambah 20%
    @Override
   public void hitungPotongan(int pembayaran)
    {  
         if ((pembayaran) >= 18000)
         {  //pemanggilan super
             diskon_langganan = super.getDiskon_awal() + 0.15 ;
             potongan         = diskon_langganan * pembayaran ;   
         }                 
    } 
   
     //override method-method pembeli, hanya merubah label "pembeli" menjadi "langganan"
   
       @Override
    public String isiNama() 
    {
        System.out.print("Silakan Masukkan Nama Langganan \t: ") ;
        return input.nextLine() ;
        

    }
    
       @Override
    public int isiBangku()
    {
      System.out.print("Silakan Masukkan Nomor Bangku Langganan : ") ;
        return input.nextInt() ;  
    }      
    
     //fungsi pemilihan menu dengan nilai balik char
       @Override
    public int pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Langganan \t: ") ;
        return input.nextInt() ;    

    }
    
       @Override
     public void isiUangMasuk()
    {   
        System.out.print("\nUang masuk langganan \t\t\t: ") ;
        uang_masuk = input.nextInt() ; 
    }        
    
    
      
}

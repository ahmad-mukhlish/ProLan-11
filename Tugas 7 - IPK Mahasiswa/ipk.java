import java.util.Scanner ;



public class ipk {
    //deklarasi atribut kelas
    int   jumlah, lulus ;
    float nilai, rerata, total ;
    
    //inisialisasi Scanner input
    Scanner input = new Scanner(System.in) ;
        
    
    //method utama
    public static void main(String args[])
    {
        System.out.println("\n\nSilakan masukkan nilai mahasiswa, masukkan nilai -999 untuk berhenti...\n");
        ipk IPK = new ipk() ;
        while ((IPK.nilai = IPK.inputNilai(IPK.jumlah)) != -999)
         {if ((IPK.isWithinRange(IPK.nilai, 0, 4) == 1) && (IPK.nilai >= 2.75)) 
            {
             IPK.jumlah++ ;
             IPK.lulus++ ;
            }
           else if ((IPK.isWithinRange(IPK.nilai, 0, 4) == 1))
           {
             IPK.jumlah++ ;  
           }
         
             
          IPK.total += IPK.nilai ; 
      
         }
        
        if (IPK.jumlah > 0)
         IPK.rerata = IPK.total / IPK.jumlah ;
        else
         IPK.rerata = 0 ;
        
        System.out.println("\n\nJumlah Mahasiswa \t\t: "+IPK.jumlah) ;
        System.out.println("Jumlah Mahasiswa yang lulus \t: "+IPK.lulus) ;
        System.out.println("Rerata IPK Mahasiswa \t\t: "+IPK.rerata+"\n\n") ;
        
        
    }
    
    //fungsi penentu apakah dalam rentang atau tidak
    int isWithinRange(float X, float min, float max)
    {
     //variabel lokal yang langsung diisi oleh operator "?"
     int cek = (((X >= min) && (X <= max)) ? 1 : 0) ;
     return cek ;
    }        
    
    //fungsi penginput nilai
    float inputNilai(int i)
    { i++ ;
      System.out.print("Silakan masukkan nilai mahasiswa ke-"+i+" : ");  
      return input.nextFloat() ;
    }        
}

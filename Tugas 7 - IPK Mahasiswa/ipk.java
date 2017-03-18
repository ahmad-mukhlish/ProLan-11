
import java.util.Scanner ;



public class ipk {
    //deklarasi variabel static kelas
    static int   jumlah, lulus ;
    static float  rerata, total ;
    
    //deklarasi konstatnta
    static final int MINIMUM = 0, MAXIMUM = 4 ;
    
    //deklarasi dan instansi array sebagai atribut objek
    float nilai[] = new float[1000] ;
    
    //inisialisasi Scanner input
    Scanner input = new Scanner(System.in) ;
        
    
    //konstruktor inisialisasi nilai array dengan -1
    ipk()
    {
        int i ;
        for(i=0;i<nilai.length;i++)
        {
            nilai[i] = -1 ;
        }   
    }
    
    
    
    //method utama
    public static void main(String args[])
    {
        ipk IPK = new ipk()  ;
        int i = 0 ;
        float temp ;
        System.out.println("\n\nSilakan masukkan nilai mahasiswa, masukkan nilai -999 untuk berhenti...\n") ;
        
        while ((temp = IPK.inputNilai(i)) != -999)
         {if ((IPK.isWithinRange(temp, MINIMUM, MAXIMUM) == 1) && (temp>= 2.75)) 
            {
             jumlah++ ;
             lulus++ ;
             IPK.nilai[i] = temp ;
             total += IPK.nilai[i] ; 
             i++ ;
            }
           else if ((IPK.isWithinRange(temp, MINIMUM, MAXIMUM) == 1))
           {
             jumlah++ ;  
             IPK.nilai[i] = temp ;
             total += IPK.nilai[i] ; 
             i++ ;
           }    
         }
        
        if (jumlah > 0)
         rerata = total / jumlah ;
        else
         rerata = 0 ;
        
        
        System.out.println("\n\nJumlah Mahasiswa \t\t: "+jumlah) ;
        System.out.println("Jumlah Mahasiswa yang lulus \t: "+lulus) ;
        System.out.println("Rerata IPK Mahasiswa \t\t: "+rerata+"\n\n") ;
        System.out.println("Nilai terendah \t\t\t: "+IPK.nilaiTerendah(IPK.nilai)) ;
        System.out.println("Nilai tertinggi \t\t: "+IPK.nilaiTertinggi(IPK.nilai)+"\n\n") ;
        
        
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
    
    float nilaiTerendah(float larik[])
    {   
        int i ;
        float min = larik[0] ;
       
        for(i=0;i<larik.length;i++)
         {  
            if ((min > larik[i]) && (larik[i] >= 0))
              min = larik[i] ;   
         }  
        return min ; 
                
    }
    
     float nilaiTertinggi(float larik[])
    {   
        int i ;
        float max = larik[0] ;
       
        for(i=0;i<larik.length;i++)
         {  
            if ((max < larik[i]) && (larik[i] >= 0))
              max = larik[i] ;   
         }  
        return max ; 
                
    }
   
}

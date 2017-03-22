/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author labkom7
 */
import java.util.Scanner ;
public class LatihanArray {
    //deklarasi atribut
    int N, max, min, kemunculan ;
    char pil ;
    
    //deklarasi array
    int[] larik = new int[100] ; 
    
    //deklarasi scanner
    Scanner inputan = new Scanner(System.in) ;
    
    public static void main(String args[])
    {
        
        LatihanArray berlatih = new LatihanArray() ;
        berlatih.lakukan() ; 
        
         
        
        
    }        
    
    
    public void lakukan()
    {
      System.out.println("\nProgram Pencari Minimum & Maksimum\n") ;
      System.out.print("Silakan Masukkan Nilai N : ") ;   
      N = inputan.nextInt() ;
      
      System.out.println() ;   
      
      System.out.print("Silakan Masukkan pilihan Anda [A/B] : ") ; 
      pil = inputan.next().charAt(0) ;
      
      System.out.println() ;  
      
      setLarik() ;
      
      System.out.println() ; 
      
      if ((pil == 'A') || (pil == 'a'))
      {pilihanA() ;
       System.out.println("Nilai Minimum : "+min) ;} 
      else if ((pil == 'B') || (pil == 'b'))
      {pilihanB() ; 
       System.out.println("Nilai Maksimum : "+max) ;
      }  
      
      System.out.println() ;  
      
      System.out.println("Jumlah kemunculan : "+kemunculan) ;
      
      
      
    }
    
    void setLarik()
    {
      int i ;
        for (i=0;i<N;i++) 
        { int label = i+1 ;
          System.out.printf("Silakan Masukkan Data ke "+label+": ") ;    
          larik[i] = inputan.nextInt() ;
        }   
    }        
    
    void pilihanA()
    {
      int i ;  
      min = larik[0] ;
      for (i=0;i<N;i++) 
        {  
           if (min > larik[i])
             min = larik[i] ;
        }
      
      //hitung kemunculannya
      
       for (i=0;i<N;i++) 
        {  
           if (min == larik[i] )
             kemunculan++ ;
        }
      
      
    }      
    
    void pilihanB()
    {
      int i ;  
      max = larik[0] ;
      for (i=0;i<N;i++) 
        {  
           if (max < larik[i])
             max = larik[i] ;
        }
      
      //hitung kemunculannya
      
       for (i=0;i<N;i++) 
        {  
           if (max == larik[i] )
             kemunculan++ ;
        }
      
    }        
   
       
    
       
   
    
}


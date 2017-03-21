import java.util.Scanner ; 
public class Langganan extends Pembeli {
    
     //method static pengecek langganan atau bukan
      boolean cekLangganan()
    {
        Scanner inputan = new Scanner(System.in) ; 
        System.out.print("Anda memiliki kartu langganan? [Y/T] \t: ") ;
        char cek = inputan.next().charAt(0) ;
        return (cek == 'Y' || cek  == 'y') ; 
        
        
    } 
      
    //override method hitung potongan, bila member potongannya jadi 20%
    @Override
   public void hitungPotongan(int pembayaran)
    {   if (cekLangganan())
        {
         if ((pembayaran) >= 18000)
         {
             discount = super.discount + 0.15 ;
             potongan = discount * pembayaran ;   
         }
        } 
        else
          super.hitungPotongan(pembayaran) ;
                   
    } 
      
}

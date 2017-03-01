//import Scanner 
import java.util.Scanner ;

public class inputan_nama {
  public static void main(String args[]) 
  {
    //deklarasi Scanner
	Scanner input = new Scanner (System.in) ;
    
	//deklarasi variabel
	String nama, teman ;

  	//inputan
    System.out.print("Silakan Masukkan Nama Anda \t\t: ") ; nama = input.nextLine() ;
    System.out.print("Silakan Masukkan Nama teman Anda \t: ") ; teman = input.nextLine() ;

	//output
    System.out.printf("\nNama Anda adalah %s sedangkan nama teman Anda adalah %s \n",nama,teman) ;
  }
}

import java.util.Scanner ;
public class mini_biodata {
  public static void main(String args[])
  { Scanner masukkan = new Scanner (System.in) ;

    String  nama ;
    int tinggi ;
    char jk ;
    boolean status ;

    System.out.print("Silakan Masukkan Nama Anda \t\t\t\t: ") ; nama = masukkan.nextLine() ;
    System.out.print("Silakan Masukkan Tinggi Anda \t\t\t\t: ") ; tinggi = masukkan.nextInt() ;
    System.out.print("Silakan Masukkan Jenis Kelamin Anda \t\t\t: ") ; jk = masukkan.next().charAt(0) ;
    System.out.print("Silakan Masukkan Status Menikah Anda (True/False) \t: ") ; status = masukkan.nextBoolean() ;

    System.out.printf("\nNama Anda adalah %s sedangkan tinggi Anda adalah %d \n",nama,tinggi) ;
    System.out.printf("Jenis kelamin Anda adalah %c, dan status menikah Anda adalah %b\n",jk,status) ;

  }
}

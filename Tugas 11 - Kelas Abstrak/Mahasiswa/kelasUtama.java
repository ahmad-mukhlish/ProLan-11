
import java.util.Scanner;

public class KelasUtama {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("\nSilakan Masukkan Nama Anda : ");
        String nama_user = input.nextLine();

        Mahasiswa mhs = new Mukhlis();

        System.out.println("");
        
        mhs.kuliah(nama_user);
        mhs.lulus();
        mhs.organisasi();

    }

}


/**
 *
 * @author GOODWARE1
 */

//keterangan package
package customer  ;

//import-import
import miscellaneous.GenMethods ;
import java.util.Scanner;

//kelas Langganan, subclass dari Pembeli
public class Langganan extends Pembeli {

    //attribut private kelas pembeli untuk proses encapsulation
    private String nama;
    private int bangku;

    //attribut tambahan kelas langganan
    private double diskon_langganan;

    //prosedur static pengecek langganan
    public static boolean cekLangganan() {
        Scanner inputan = new Scanner(System.in);
        System.out.print("Anda memiliki kartu langganan? [Y/T] \t: ");
        char cek = inputan.next().charAt(0);
        return (cek == 'Y' || cek == 'y');

    }

    //override method hitung potongan, bila member potongannya ditambah 20%
    @Override
    public void hitungPotongan(int pembayaran) {
        if ((pembayaran) >= 18000) {  //pemanggilan super
            diskon_langganan = super.getDiskon_awal() + 0.15;
            potongan = diskon_langganan * pembayaran;
        }
    }

    //override method-method pembeli, hanya merubah label "pembeli" menjadi "langganan"
    @Override
    public String isiNama() {
        System.out.print("Silakan Masukkan Nama Langganan \t: ");
        return input.nextLine();

    }

    @Override
    public int isiBangkuValid() {
        System.out.print("Silakan Masukkan Nomor Bangku Langganan : ");
        return GenMethods.checker_int(GenMethods.ambil_int(input.next(), 0, 550), "Nomor Bangku Langganan", 0, 550);
    }

    @Override
    public int pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Langganan \t: ");
        return super.ambil_menu(input.next());

    }

    @Override
    protected void isiUangMasuk() {
        System.out.print("\nUang masuk langganan \t\t\t: ");
        uang_masuk = GenMethods.checker_long(GenMethods.ambil_long(input.next(), 0, 10000000), "Uang Masuk", 0, 10000000);
    }

    @Override
    public void Banner() {
        System.out.println("\nTerimakasih atas kedatangannya langganan " + this.nama + " ^_^\n");
    }

    //setter yang di-override dari kelas pembeli
    @Override
    public void setBangku(int bangku) {
        this.bangku = bangku;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

}

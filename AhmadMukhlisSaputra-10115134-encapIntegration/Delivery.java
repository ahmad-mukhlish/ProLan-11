
/**
 *
 * @author GOODWARE1
 */
import java.util.Scanner;

public class Delivery implements DataPekerja {

    private int ongkir, jarak;
    private String tujuan, penugasan;

    private static boolean jasa_delivery;

    private final String namaKasir = "Vivi";
    private final String namaKoki = "Husni";
    private final String namaDriver = "Deni";

    Scanner input = new Scanner(System.in);

    //method getter ongkir (read only)
    public int getOngkir() {
        return ongkir;
    }

    //method getter boolean jasa delivery (read only)
    public static boolean isJasa_delivery() {
        return jasa_delivery;
    }

    //method getter keterangan penugasan (read only)
    public String getPenugasan() {
        return penugasan;
    }

    //method penghitung ongkir berdasarkan jarak
    public int hitungOngkir() {
        if (jarak <= 10) {
            return 12000;
        } else if ((jarak > 10) && (jarak < 20)) {
            return 20000;
        } else {
            return 32000;
        }
    }

    public void detail(boolean cek) {
        if (cek) {
            System.out.print("Alamat yang dituju        \t\t: ");
            tujuan = input.nextLine();
            System.out.print("Jaraknya (dalam km)       \t\t: ");
            jarak = input.nextInt();
            ongkir = hitungOngkir();
            penugasan = "Driver yang bertugas \t\t\t: ";
        } else {
            penugasan = "Waitress yang bertugas \t\t\t: ";
        }
    }

    public static boolean cekDelivery() {
        Scanner inputan = new Scanner(System.in);
        System.out.print("Layanan delivery? [Y/T] \t\t: ");
        char cek = inputan.next().charAt(0);
        jasa_delivery = false;
        if (cek == 'Y' || cek == 'y') {
            jasa_delivery = true;
        }
        return jasa_delivery;

    }

    //implementasi interface DataPekerja
    @Override
    public String getNamaKasir() {
        return this.namaKasir;
    }

    @Override
    public String getNamaKoki() {
        return this.namaKoki;
    }

    @Override
    public String getNamaPetugas() {
        return this.namaDriver;
    }

}

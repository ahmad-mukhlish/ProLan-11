/**
 *
 * @author GOODWARE1
 */

import java.util.Scanner;

public class Delivery implements DataPekerja{

    private int ongkir, jarak;
    private String tujuan;
    private static boolean jasa_delivery;
    private final String namaKasir  = "Vivi" ;
    private final String namaKoki   = "Husni" ;
    private final String namaDriver = "Deni" ;
    
    //method setter jarak dan tujuan delivery (write 0nly)
    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    //method getter ongkir (read only)
    public int getOngkir() {
        return ongkir;
    }
    
    //method getter boolean jasa delivery (read only)
    public static boolean isJasa_delivery() {
        return jasa_delivery;
    }

    //method penghitung ongkir berdasarkan jarak
    public void hitungOngkir() {
        if (jarak <= 10) {
            ongkir = 12000;
        } else if ((jarak > 10) && (jarak < 20)) {
            ongkir = 20000;
        } else {
            ongkir = 32000;
        }
    }

    public static boolean cekDelivery() {
        Scanner inputan = new Scanner(System.in);
        System.out.print("Layanan delivery? [Y/T] \t\t: ");
        char cek = inputan.next().charAt(0);
        jasa_delivery = false ;
        if (cek == 'Y' || cek == 'y')
            jasa_delivery = true ;
        return jasa_delivery ;
        

    }

    @Override
    public String getNamaKasir() {
        return this.namaKasir ;
    }

    @Override
    public String getNamaKoki() {
        return this.namaKoki ;
    }

    @Override
    public String getNamaPetugas() {
        return this.namaDriver ;
    }

}

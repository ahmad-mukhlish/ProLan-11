/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOODWARE1
 */

//keterangan package
package  miscellaneous ;

//import-import
import java.util.Scanner;
import produk.Produk ;
import produk.Makanan ;
import produk.Minuman ;
        
        
public class GenMethods<T> {

    //method generic dengan parameter objek bertipe T    
    public static <T> void DaftarMenuProduk(T[] larikInputan) {

        int i = 0;
        String keterangan = "";

        if (larikInputan[0] instanceof Makanan) {
            keterangan = Makanan.keterangan_makanan;
        } else if (larikInputan[0] instanceof Minuman) {
            keterangan = Minuman.keterangan_minuman;
        }

        for (Object elemennya : larikInputan) {

            //casting elemennya yang bertipe T dengan kelas referensi object ke kelas Produk
            Produk elemen = (Produk) elemennya;
            i++;
            System.out.println("Paket " + keterangan + " " + i + "  : " + elemen.getNama_produk() + " " + elemen.getHarga());
        }

    }

    //method generik sebagai validasi masukan beserta penerapan konsep penjebakan eksepsi untuk tipe int
    public static <type> int ambil_int(type masukan, int min, int max) {
        Integer temp = 0;
        try {
            temp = Integer.parseInt(masukan.toString());
        } catch (NumberFormatException e) {
            temp = 0;
        }
        if ((temp < min) || (temp > max)) {
            return 0;
        } else {
            return temp;
        }
    }

    //method non-generic untuk tipe int
    public static int checker_int(int masukanInt, String notif, int min, int max) {

        Scanner input = new Scanner(System.in);

        while (masukanInt == 0) {
            System.out.println("\n" + notif + " tidak valid, nilai minimum " + min + " nilai maksimum " + max);

            if (notif.equals("Pilihan Menu") || notif.equals("Jarak delivery")) {
                System.out.print("Silakan Masukkan " + notif + "\t\t: ");
            } else {
                System.out.print("Silakan Masukkan " + notif + "\t: ");
            }

            masukanInt = GenMethods.ambil_int(input.next(), min, max);
            System.out.println();
        }

        return masukanInt;
    }

    //method generik sebagai validasi masukan beserta penerapan konsep penjebakan eksepsi untuk tipe long
    public static <type> long ambil_long(type masukan, long min, long max) {
        Long temp = 0L;
        try {
            temp = Long.parseLong(masukan.toString());
        } catch (NumberFormatException e) {
            temp = 0L;
        }
        if ((temp < min) || (temp > max)) {
            return 0;
        } else {
            return temp;
        }
    }

    //method non-generic untuk tipe long
    public static long checker_long(long masukanLong, String notif, int min, int max) {

        Scanner input = new Scanner(System.in);

        while (masukanLong == 0) {
            System.out.println("\n" + notif + " tidak valid, nilai minimum " + min + " nilai maksimum " + max);

            if (notif.equals("Uang Masuk") || notif.equals("Nilai kode")) {
                System.out.print("Silakan Masukkan " + notif + "\t\t: ");
            } else {
                System.out.print("Silakan Masukkan " + notif + "\t: ");
            }

            masukanLong = GenMethods.ambil_long(input.next(), min, max);
            System.out.println();
        }

        return masukanLong;
    }

}

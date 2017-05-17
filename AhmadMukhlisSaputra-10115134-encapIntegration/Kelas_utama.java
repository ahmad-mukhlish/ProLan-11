
/**
 *
 * @author GOODWARE1
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Kelas_utama {

    public static void main(String args[]) {
        //deklarasi objek umum yang digunakan :
        Pembeli customer;
        //hubungan has - a dengan kelas pembeli
        //penggunaan polymorphism dengan objek referensi customer dari kelas pembeli

        //deklarasi date dan sdf-nya
        Date tanggal = new Date();
        SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy");

        //deklarasi variabel lokal 
        int i;

        //header program
        System.out.println("\nProgram Restoran Sangat Sederhana");
        System.out.println("---------------------------------\n");
        System.out.println("Tanggal \t\t\t\t: " + penanggalan.format(tanggal));

        //mementukan apakah customer adalah pembeli biasa atau pelanggan dengan konsep polymorphism
        if (Langganan.cekLangganan()) {
            customer = new Langganan();
        } else {
            customer = new Pembeli();
        }

        //isi Nama dan bangku customer dengan konsep setter
        customer.setNama(customer.isiNama());
        customer.setBangku(customer.isiBangku());

        //set diskon customer dengan konsep setter
        customer.setDiskon_awal(0.05);

        System.out.println();

        //tampilkan menu makanan
        for (i = 1; i < 6; i++) { //penggunaan method static tampilkan dengan referensi kelas Makanan dan objek anonim pada kelas Makanan
            System.out.println(Makanan.tampilkan(new Makanan(i), "makanan", i, true));

        }

        //pemilihan menu makanan
        int pilihan_makanan = customer.pilih_menu();
        //instansi objek makanan dengan konsep polymorphism pada kelas abstract
        Produk makanan = new Makanan(pilihan_makanan);
        //output objek makanan yang dipilih
        System.out.println("Makanan yang Anda pilih adalah          : {" + makanan.getTampilan() + "}");

        System.out.println();

        //tampilkan menu minuman
        for (i = 1; i < 6; i++) { //penggunaan method static tampilkan dengan referensi kelas Minuman dan objek anonim pada kelas Minuman
            System.out.println(Minuman.tampilkan(new Minuman(i), "minuman", i, true));
        }

        //pemilihan menu minuman
        int pilihan_minuman = customer.pilih_menu();
        //instansi objek minuman dengan konsep polymorphism pada kelas abstract
        Produk minuman = new Minuman(pilihan_minuman);
        //output minuman yang dipilih
        System.out.println("Minuman yang Anda pilih adalah          : {" + minuman.getTampilan() + "}");

        System.out.println();

        //cek validasi transaksi dengan konsep getter boolean (isBoolean)
        if ((makanan.isJadi()) || (minuman.isJadi())) {
            //cek apakah transaksi dibungkus atau tidak 
            if (customer.pembungkusan()) {
                //hitung transaksi dengan konsep getter
                customer.transaksi(makanan.getHarga() + minuman.getHarga(), makanan.getBungkusnya() + minuman.getBungkusnya());
            } else {
                customer.transaksi(makanan.getHarga() + minuman.getHarga());
            }
        }

        customer.Banner();

    }

}

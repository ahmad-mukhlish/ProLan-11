
/**
 *
 * @author GOODWARE1
 */

//keterangan package
package main ;

//import-import
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import customer.* ;
import produk.* ;
import delivery.Delivery ;
import miscellaneous.GenMethods ;
import miscellaneous.GenerikQu ;



public class Kelas_utama {

    public static void main(String args[]) {
        //deklarasi objek umum yang digunakan :
        Pembeli customer;
        //hubungan has - a dengan kelas pembeli
        //penggunaan polimorfisme dengan objek referensi customer dari kelas pembeli

        //inisiasi larik makanan dan minuman
        Makanan.inisiasi_array();
        Minuman.inisiasi_array();

        //deklarasi date dan sdf-nya
        Date sekarang = new Date();
        SimpleDateFormat penanggalan = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        SimpleDateFormat JamSekarang = new SimpleDateFormat("HH:mm:ss");

        //deklarasi variabel lokal 
        int i;

        //deklarasi scanner input
        Scanner input = new Scanner(System.in);

        //header program
        System.out.println("\nProgram Restoran Sangat Sederhana");
        System.out.println("---------------------------------\n");
        System.out.println("Tanggal \t\t\t\t: " + penanggalan.format(sekarang));

        Delivery delivery = new Delivery();
        delivery.detail(Delivery.cekDelivery());

        System.out.println("");

        //mementukan apakah customer adalah pembeli biasa atau pelanggan dengan konsep polimorfisme
        if (Langganan.cekLangganan()) {
            customer = new Langganan();
        } else {
            customer = new Pembeli();
        }

        //isi Nama dan bangku customer dengan konsep setter
        customer.setNama(customer.isiNama());
        if (!Delivery.isJasa_delivery()) {
            customer.setBangku(customer.isiBangkuValid());
        }

        System.out.print("\nApakah kode Struk bertipe data Integer? : ");
        char pil = input.next().charAt(0);
        if (pil == 'Y' || pil == 'y') {
            GenerikQu<Long, String> a = new GenerikQu<>();
            System.out.print("Kode Struk (Integer) \t\t\t: ");
            a.setKodeStrukDanWaktuStruk(GenMethods.checker_long(GenMethods.ambil_long(input.next(), 0, 10000000), "Nilai kode", 0, 10000000), JamSekarang.format(sekarang));
            a.printKodeStrukdanWaktuStruk();
        } else {
            GenerikQu<String, String> b = new GenerikQu<>();
            System.out.print("Kode Struk (String) \t\t\t: ");
            b.setKodeStrukDanWaktuStruk(input.next(), JamSekarang.format(sekarang));
            b.printKodeStrukdanWaktuStruk();
        }

        //set diskon customer dengan konsep setter
        customer.setDiskon_awal(0.05);

        System.out.println();

        //tampilkan menu makanan
        GenMethods.<Makanan>DaftarMenuProduk(Makanan.larikMakanan);

        //pemilihan menu makanan
        int pilihan_makanan = customer.pilih_menu();
        //instansi objek makanan dengan konsep polymorphism pada kelas abstract
        Produk makanan = new Makanan(pilihan_makanan);
        //output objek makanan yang dipilih
        System.out.println("Makanan yang Anda pilih adalah          : {" + makanan.getTampilan() + "}");
        if (Delivery.isJasa_delivery()) {
            System.out.println("Koki yang bertugas \t\t\t: " + delivery.getNamaKoki());
        } else {
            System.out.println("Koki yang bertugas \t\t\t: " + makanan.getNamaKoki());
        }
        System.out.print("Jumlah paket makanan yang dibeli        : ");
        makanan.setJumlah(GenMethods.checker_int(GenMethods.ambil_int(input.next(), 0, 999), "Jumlah paket Makanan", 0, 999));

        System.out.println();

        //tampilkan menu minuman
        GenMethods.<Minuman>DaftarMenuProduk(Minuman.larikMinuman);

        //pemilihan menu minuman
        int pilihan_minuman = customer.pilih_menu();
        //instansi objek minuman dengan konsep polymorphism pada kelas abstract
        Produk minuman = new Minuman(pilihan_minuman);
        //output minuman yang dipilih
        System.out.println("Minuman yang Anda pilih adalah          : {" + minuman.getTampilan() + "}");
        if (Delivery.isJasa_delivery()) {
            System.out.println("Koki yang bertugas \t\t\t: " + delivery.getNamaKoki());
        } else {
            System.out.println("Koki yang bertugas \t\t\t: " + minuman.getNamaKoki());
        }
        System.out.print("Jumlah paket minuman yang dibeli        : ");
        minuman.setJumlah(GenMethods.checker_int(GenMethods.ambil_int(input.next(), 0, 999), "Jumlah paket Minuman", 0, 999));

        System.out.println();

        //cek validasi transaksi dengan konsep getter boolean (isBoolean)
        if ((makanan.isJadi()) || (minuman.isJadi())) {
            //bila pembeli delivery, pasti dibungkus
            if (Delivery.isJasa_delivery()) {
                customer.transaksi(makanan.getHarga() * makanan.getJumlah() + minuman.getHarga() * minuman.getJumlah(), makanan.getBungkusnya() * makanan.getJumlah() + minuman.getBungkusnya() * minuman.getJumlah());
            } else {    //cek apakah transaksi dibungkus atau tidak bila customer makan di tempat
                if (customer.pembungkusan()) {
                    //hitung transaksi dengan konsep getter beserta bungkusnya
                    customer.transaksi(makanan.getHarga() * makanan.getJumlah() + minuman.getHarga() * minuman.getJumlah(), makanan.getBungkusnya() * makanan.getJumlah() + minuman.getBungkusnya() * minuman.getJumlah());
                } else {
                    customer.transaksi(makanan.getHarga() * makanan.getJumlah() + minuman.getHarga() * minuman.getJumlah());
                }
            }
        }

        if (Delivery.isJasa_delivery()) {
            System.out.println("Jasa ongkir \t\t\t\t: " + delivery.getOngkir());
            System.out.println("\nNama Kasir yang bertugas \t\t: " + delivery.getNamaKasir());
            System.out.println(delivery.getPenugasan() + delivery.getNamaPetugas());
        } else {
            System.out.println("");
            System.out.println("Nama Kasir yang bertugas \t\t: " + makanan.getNamaKasir());
            System.out.println(delivery.getPenugasan() + makanan.getNamaPetugas());
        }

        customer.Banner();

    }

}

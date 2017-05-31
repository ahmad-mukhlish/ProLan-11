
/**
 *
 * @author GOODWARE1
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Kelas_utama {

    public static void main(String args[]) {
        //deklarasi objek umum yang digunakan :
        Pembeli customer;
        //hubungan has - a dengan kelas pembeli
        //penggunaan polimorfisme dengan objek referensi customer dari kelas pembeli

        //deklarasi date dan sdf-nya
        Date tanggal = new Date();
        SimpleDateFormat penanggalan = new SimpleDateFormat("dd-MMM-yyyy");

        //deklarasi variabel lokal 
        int i;

        //deklarasi scanner input
        Scanner input = new Scanner(System.in);

        //header program
        System.out.println("\nProgram Restoran Sangat Sederhana");
        System.out.println("---------------------------------\n");
        System.out.println("Tanggal \t\t\t\t: " + penanggalan.format(tanggal));

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
            customer.setBangku(customer.isiBangku());
        }

        System.out.print("\nApakah kode Struk bertipe data Integer? : ");
        char pil = input.next().charAt(0);
        if (pil == 'Y' || pil == 'y') {
            GenerikQu<Integer> a = new GenerikQu<>();
            System.out.print("Kode Struk (Integer) \t\t\t: ");
            a.setKodeStruk(input.nextInt());
        } else {
            GenerikQu<String> b = new GenerikQu<>();
            System.out.print("Kode Struk (String) \t\t\t: ");
            b.setKodeStruk(input.next());
        }

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
        if (Delivery.isJasa_delivery()) {
            System.out.println("Koki yang bertugas \t\t\t: " + delivery.getNamaKoki());
        } else {
            System.out.println("Koki yang bertugas \t\t\t: " + makanan.getNamaKoki());
        }
        System.out.print("Jumlah paket makanan yang dibeli        : ");
        makanan.setJumlah(input.nextInt());

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
        if (Delivery.isJasa_delivery()) {
            System.out.println("Koki yang bertugas \t\t\t: " + delivery.getNamaKoki());
        } else {
            System.out.println("Koki yang bertugas \t\t\t: " + minuman.getNamaKoki());
        }
        System.out.print("Jumlah paket minuman yang dibeli        : ");
        minuman.setJumlah(input.nextInt());

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

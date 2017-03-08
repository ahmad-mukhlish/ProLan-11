 

import java.util.Scanner;

/**
 *
 * @author GOODWARE1
 */
class Pembeli {
    //variabel global kelas pembeli

    String nama;
    int nomor_bangku;
    Makanan pesanan;
    long uang_masuk, kembalian;

    //inisiasi Scanner
    Scanner input = new Scanner(System.in);
    //inisiasi Pembeli objek global 
    static Pembeli customer = new Pembeli();

    public static Makanan ayam = new Makanan();
    public static Makanan sop_iga = new Makanan();
    public static Makanan batagor = new Makanan();
    public static Makanan burger = new Makanan();
    public static Makanan pasta = new Makanan();

    //metoda pengendali kelas pembeli
    public static void main(String args[]) {
 

        customer.data();

        customer.liat_menu();

        customer.transaksi();

    }
    
    public void inisiasi_menu_makanan() {
        ayam.nama_makanan = "Ayam goreng + nasi";
        ayam.harga = 18000;

        sop_iga.nama_makanan = "Sop iga + nasi";
        sop_iga.harga = 23000;

        batagor.nama_makanan = "Batagor spesial";
        batagor.harga = 17000;

        burger.nama_makanan = "Cheese Burger";
        burger.harga = 13000;

        pasta.nama_makanan = "Pasta mozarella";
        pasta.harga = 24000;

    }

    public void tampil_menu_makanan() {
        System.out.println();
        System.out.println("1. " + ayam.nama_makanan + " Harganya " + ayam.harga);
        System.out.println("2. " + sop_iga.nama_makanan + " Harganya " + sop_iga.harga);
        System.out.println("3. " + batagor.nama_makanan + " Harganya " + batagor.harga);
        System.out.println("4. " + burger.nama_makanan + " Harganya " + burger.harga);
        System.out.println("5. " + pasta.nama_makanan + " Harganya " + pasta.harga);

    }

//method - method pembeli
    private void liat_menu() {
        Pembeli makan = new Pembeli();
        makan.inisiasi_menu_makanan();
        makan.tampil_menu_makanan();
    }

    private void data() {
        System.out.print("Silakan Masukkan Nama Pembeli : ");
        customer.nama = input.nextLine();
        System.out.print("Silakan Masukkan Nomor Bangku Pembeli : ");
        customer.nomor_bangku = input.nextInt();

    }

    public int pilih_menu() {
        int menu;
        System.out.print("\nSilakan Masukan Pilihan Pembeli : ");
        menu = input.nextInt();
        return menu;

    }

    public void transaksi() {
        int pilihan;
        pilihan = customer.pilih_menu();
        long harga;

        if (pilihan == 1) {
            harga = ayam.harga;
        } else if (pilihan == 2) {
            harga = sop_iga.harga;
        } else if (pilihan == 3) {
            harga = batagor.harga;
        } else if (pilihan == 4) {
            harga = burger.harga;
        } else {
            harga = pasta.harga;
        }

        System.out.print("Uang masuk pembeli : ");
        customer.uang_masuk = input.nextLong();
        customer.kembalian = customer.uang_masuk - harga;
        System.out.println("Harga makanan " + harga + " Uang kembalian pembeli : " + customer.kembalian);

    }

}

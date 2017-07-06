
/**
 *
 * @author GOODWARE1
 */

//keterangan package
package produk ;

//import-import
import miscellaneous.DataPekerja ;

public class Minuman extends Produk implements DataPekerja {

    //konstanta string khusus kelas minuman
    public static final String keterangan_minuman = "minuman";

    //private attribut untuk Enkapsulasi
    private String nama_produk, tampilan;

    private int harga, bungkusnya, jumlah;
    private boolean jadi;
    private final String namaKoki = "Nurhanifah";

    private static final int max = 5;

    public static Minuman[] larikMinuman = new Minuman[max];

    //override constructor kelas abstract
    public Minuman(int paket) {
        //panggil super
        super(paket);
        //timpa tampilan dengan keterangan minuman
        tampilan = Minuman.tampilkan(this, keterangan_minuman, paket, this.jadi);

    }

    //static method Makanan
    public static String tampilkan(Minuman penampil, String keterangan, int kode, boolean valid) {

        if (valid) {
            return "Paket " + keterangan + " " + kode + "  : " + penampil.nama_produk + " " + penampil.harga;
        } else {
            return penampil.nama_produk;
        }

    }

    public static void inisiasi_array() {
        int i;
        for (i = 0; i < max; i++) {
            larikMinuman[i] = new Minuman(i + 1);
        }
    }

    //method yang di-override dari kelas abstract 
    @Override
    public void setProduk(int pilihan) {
        boolean jadi = true;
        switch (pilihan) {
            case 1: {
                this.nama_produk = "Es kelapa muda";
                this.harga = 7000;
                this.bungkusnya = 1000;
                break;
            }

            case 2: {
                nama_produk = "Es Cingcau";
                harga = 8000;
                bungkusnya = 1500;
                break;
            }

            case 3: {
                nama_produk = "Jeruk Panas";
                harga = 6000;
                bungkusnya = 700;
                break;
            }

            case 4: {
                nama_produk = "Es campur";
                harga = 11000;
                bungkusnya = 1200;
                break;
            }

            case 5: {
                nama_produk = "Air putih";
                harga = 0;
                bungkusnya = 0;
                break;
            }

            default: {
                nama_produk = "Menu yang Anda pilih tidak tersedia...";
                jadi = false;
                break;
            }
        }

        this.jadi = jadi;
    }

    //method - method getter dari hasil override
    @Override
    public String getTampilan() {
        return this.tampilan;
    }

    @Override
    public int getBungkusnya() {
        return this.bungkusnya;
    }

    @Override
    public int getHarga() {
        return this.harga;
    }

    @Override
    public boolean isJadi() {
        return this.jadi;
    }

    //getter dan setter atribut jumlah pada kelas Minuman
    @Override
    public int getJumlah() {
        return jumlah;
    }

    @Override
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    //implementasi interface DataPekerja
    @Override
    public String getNamaPetugas() {
        return super.getNamaPetugas();
    }

    @Override
    public String getNamaKasir() {
        return super.getNamaKasir();
    }

    @Override
    public String getNamaKoki() {
        return this.namaKoki;
    }

    @Override
    public String getNama_produk() {
        return nama_produk;
    }

}

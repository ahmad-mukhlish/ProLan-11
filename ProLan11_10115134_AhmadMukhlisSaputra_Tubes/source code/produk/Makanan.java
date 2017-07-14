
/**
 *
 * @author GOODWARE1
 */

//keterangan package
package produk ;

//import-import
import miscellaneous.DataPekerja ;

public class Makanan extends Produk implements DataPekerja {

    //konstanta string khusus kelas makanan
    public static final String keterangan_makanan = "makanan";

    //private attribut untuk Enkapsulasi
    private String nama_produk, tampilan;

    private int harga, bungkusnya, jumlah;
    private boolean jadi;
    private final String namaKoki = "Wikeu";
    public static final int max = 5;

    public static Makanan[] larikMakanan = new Makanan[max];

    //override constructor kelas abstract
    public Makanan(int paket) {
        super(paket);
        tampilan = Makanan.tampilkan(this, keterangan_makanan, paket, this.jadi);

    }

    //static method Makanan
    public static String tampilkan(Makanan penampil, String keterangan, int kode, boolean valid) {

        if (valid) {
            return "Paket " + keterangan + " " + kode + "  : " + penampil.nama_produk + " " + penampil.harga;
        } else {
            return penampil.nama_produk;
        }

    }

    public static void inisiasi_array() {
        int i;
        for (i = 0; i < max; i++) {
            larikMakanan[i] = new Makanan(i + 1);
        }
    }

    //method yang di-override dari kelas abstract
    @Override
    public void setProduk(int pilihan) {
        boolean jadi = true;
        switch (pilihan) {
            case 1: {
                nama_produk = "Ayam goreng + nasi";
                harga = 18000;
                bungkusnya = 1000;
                break;
            }

            case 2: {
                nama_produk = "Sop iga + nasi";
                harga = 23000;
                bungkusnya = 2000;
                break;
            }

            case 3: {
                nama_produk = "Batagor spesial";
                harga = 15000;
                bungkusnya = 700;
                break;
            }

            case 4: {
                nama_produk = "Cheese Burger";
                harga = 13000;
                bungkusnya = 400;
                break;
            }

            case 5: {
                nama_produk = "Pasta mozarella";
                harga = 19000;
                bungkusnya = 800;
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

    //method - method getter 
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

    //getter dan setter atribut jumlah pada kelas Makanan
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
    public String getNamaKasir() {
        return super.getNamaKasir();
    }

    @Override
    public String getNamaPetugas() {
        return super.getNamaPetugas();
    }

    @Override
    public String getNamaKoki() {
        return this.namaKoki;
    }

    @Override
    public String getNama_produk() {
        return nama_produk;
    }

    @Override
    public long harga_jenis() {
      return harga * jumlah ;
    }

    @Override
    public long bungkus_jenis() {
      return bungkusnya * jumlah ;
    }
}

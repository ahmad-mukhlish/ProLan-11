
//kelas abstract Produk
public abstract class Produk {
    
    protected String nama_produk, tampilan;
    protected int harga, bungkusnya, jenis;
    protected boolean jadi;
    
    Produk(int paket) {
        setProduk(paket);
        //isi string tampilan
        tampilan = tampilkan(this, "produk", paket, this.jadi);

    }
    
     public static String tampilkan(Produk penampil, String keterangan, int kode, boolean valid) {

        if (valid) {
            return "Paket " + keterangan + " " + kode + "  : " + penampil.nama_produk + " " + penampil.harga;
        } else {
            return penampil.nama_produk;
        }

    }
     
     
    public abstract void setProduk(int paket) ;
     
     

    
}

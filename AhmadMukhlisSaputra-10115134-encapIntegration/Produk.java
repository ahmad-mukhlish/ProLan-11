/**
 *
 * @author GOODWARE1
 */

//kelas abstract
public abstract class Produk {

    //constructor kelas abstract
    Produk(int paket) {
        setProduk(paket);
    }
    
    //method abstract
    public abstract void setProduk(int paket);

    //getter berupa method-method abstract
    public abstract String getTampilan();
    public abstract boolean isJadi();
    public abstract int getHarga();
    public abstract int getBungkusnya();

}

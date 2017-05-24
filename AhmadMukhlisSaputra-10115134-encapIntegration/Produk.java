/**
 *
 * @author GOODWARE1
 */

//kelas abstract
public abstract class Produk implements DataPekerja {

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
    public abstract int getJumlah() ;
    public abstract void setJumlah(int jumlah) ;

    @Override
    public String getNamaKasir() {
        return "Annisa" ;
    }
    
    @Override
    public String getNamaPetugas() {
        return "Rosmi" ;
    }
    
}

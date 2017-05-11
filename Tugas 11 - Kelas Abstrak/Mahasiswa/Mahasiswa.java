
public abstract class Mahasiswa {

    protected String nama;
    protected String nim;

    //getter setter nama dan nim   
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public abstract void kuliah(String nama);
    public abstract void lulus();
    public abstract void tidakLulus();
    
    public void organisasi() {
        System.out.println("Mahasiswa ini ikut organisasi");
    }
}

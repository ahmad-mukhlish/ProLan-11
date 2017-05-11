
public class Mukhlis extends Mahasiswa {

    @Override
    public void kuliah(String nama) {
        this.nama = nama;
        System.out.println("Hi saya " + nama + " ingin kuliah dan terus belajar lebih baik ^_^");
    }

    @Override
    public void lulus() {
        System.out.println("Saya " + nama + " ingin lulus cum laude dan tepat waktu juga");

    }

    @Override
    public void tidakLulus() {
        System.out.println("Saya " + nama + " tidak ingin tidak lulus");

    }

}

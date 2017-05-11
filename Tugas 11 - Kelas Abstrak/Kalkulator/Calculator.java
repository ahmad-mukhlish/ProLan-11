
public abstract class Calculator {
    
    protected abstract double hasilTambah(double x, double y) ;
    protected abstract double hasilKurang(double x, double y) ;
    protected abstract double hasilKali(double x, double y) ;
    protected abstract double hasilBagi(double x, double y) ;
    
    protected boolean hasilLebihKecilDari(double x, double y) {return true ;} 
    protected boolean hasilLebihBesarDari(double x, double y) {return true ;} 
    protected boolean hasilLebihKecilSamaDenganDari(double x, double y) {return true ;} 
    protected boolean hasilLebihBesarSamaDenganDari(double x, double y) {return true ;} 
    
}

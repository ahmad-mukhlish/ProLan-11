
public class KalkulatorQu extends Calculator {

    @Override
    protected double hasilTambah(double x, double y) {
        return x + y;
    }

    @Override
    protected double hasilKurang(double x, double y) {
        return x - y;
    }

    @Override
    protected double hasilKali(double x, double y) {
        return x * y;

    }

    @Override
    protected double hasilBagi(double x, double y) {
        return x / y;

    }

    @Override
    protected boolean hasilLebihBesarSamaDenganDari(double x, double y) {
        return x >= y;   
            
    }

    @Override
    protected boolean hasilLebihKecilSamaDenganDari(double x, double y) {
        return x <= y;   
        
    }

    @Override
    protected boolean hasilLebihBesarDari(double x, double y) {
        return x > y;   
        
    }

    @Override
    protected boolean hasilLebihKecilDari(double x, double y) {
        return x < y;   
        
    }
    
    

}

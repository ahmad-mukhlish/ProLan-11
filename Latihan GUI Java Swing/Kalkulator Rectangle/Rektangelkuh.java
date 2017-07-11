
/**
 *
 * @author GOODWARE1
 */
public class Rektangelkuh {

    private int p;
    private int l ;
   

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
    
    public int Luas() {
        return l * p ;
    }
    
    public int Keliling() {
        return 2 * (p + l) ;
    }


    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author GOODWARE1
 * @param <T>
 */
public class GenerikQu<T> {
    
    private T kodeStruk ;

    public T getKodeStruk() {
        return kodeStruk;
    }

    public void setKodeStruk(T kodeStruk) {
        this.kodeStruk = kodeStruk;
    }
    
    public void printKodeStruk() {
        System.out.println(kodeStruk);
    }
    
    
    
}

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
public class GenerikQu<T1, T2> {

    private T1 kodeStruk;
    private T2 waktuStruk;

    public void setWaktuStruk(T2 tanggalStruk) {
        this.waktuStruk = tanggalStruk;
    }

    public T2 getTanggalStruk() {
        return waktuStruk;
    }

    public T1 getKodeStruk() {
        return kodeStruk;
    }

    public void setKodeStrukDanWaktuStruk(T1 kodeStruk, T2 tanggalStruk) {
        this.kodeStruk = kodeStruk;
        this.waktuStruk = tanggalStruk;
    }

    //method generic dengan 2 parameter generic
    public <T1, T2> void printKodeStrukdanWaktuStruk() {
        System.out.println("\nKode Struk Anda \t\t\t: " + kodeStruk);
        System.out.print("Waktu pembuatan Struk \t\t\t: " + waktuStruk + "\n");

    }

}

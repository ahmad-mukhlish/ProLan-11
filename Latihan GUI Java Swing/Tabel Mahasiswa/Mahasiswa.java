/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author GOODWARE1
 */

public class Mahasiswa {
    
    private int NIM;
    private int Nilai;
    private String Nama;

    public Mahasiswa(int NIM, int Nilai, String Nama) {
        this.NIM = NIM;
        this.Nilai = Nilai;
        this.Nama = Nama;
    }

    
    public int getNIM() {
        return NIM;
    }

    public void setNIM(int NIM) {
        this.NIM = NIM;
    }

    public int getNilai() {
        return Nilai;
    }

    public void setNilai(int Nilai) {
        this.Nilai = Nilai;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }


    public String Keterangan(int nilai) {
        
        if ((nilai > 0) && (nilai <=35))
           return "Coba lagi" ;
        else if ((nilai > 35) && (nilai <=50))
           return "Lumayan lah, tapi masih kurang maksimal" ;
        else if ((nilai > 50) && (nilai <=65))
           return "Oke lah segitu mah" ;
        else if ((nilai > 65) && (nilai <=80))
           return "Good enough is not good" ;
        else
            return "Well done" ;
    }

    
    
    
    
    
}

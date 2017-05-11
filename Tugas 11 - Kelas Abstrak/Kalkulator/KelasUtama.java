

import java.util.Scanner;

public class KelasUtama {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calculator cal = new KalkulatorQu();
        double op1, op2;

        System.out.print("\nSilakan masukkan angka pertama 	: ");
        op1 = input.nextInt();

        System.out.print("Silakan masukkan angka kedua   	: ");
        op2 = input.nextInt();

        System.out.println("\nHasil penjumlahannya   : " + cal.hasilTambah(op1, op2));
        System.out.println("Hasil pengurangannya   : " + cal.hasilKurang(op1, op2));
        System.out.println("Hasil perkaliannya     : " + cal.hasilKali(op1, op2));
        System.out.println("Hasil pembagiannya     : " + cal.hasilBagi(op1, op2));
        
        System.out.println("");

        if (cal.hasilLebihBesarDari(op1, op2)) 
            System.out.println(op1 + " lebih besar dari " + op2);
        

        if (cal.hasilLebihKecilDari(op1, op2)) 
            System.out.println(op1 + " lebih kecil dari " + op2);
        

        if (cal.hasilLebihBesarSamaDenganDari(op1, op2)) 
            System.out.println(op1 + " lebih besar sama dengan " + op2);
        

        if (cal.hasilLebihKecilSamaDenganDari(op1, op2)) 
            System.out.println(op1 + " lebih kecil sama dengan " + op2);
        
        System.out.println("");
        

    }

}

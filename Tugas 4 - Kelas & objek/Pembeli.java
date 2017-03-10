 
import java.util.Scanner ;

class Pembeli
{
    //variabel global kelas pembeli

    String nama ;
    int nomor_bangku ;
    long uang_masuk, kembalian ;

    //inisiasi Scanner
    Scanner input = new Scanner(System.in) ;
 

    //method - method pembeli
   

    public void data() 
    {
        System.out.print("\n\nSilakan Masukkan Nama Pembeli : ") ;
        this.nama = input.nextLine() ;
        System.out.print("Silakan Masukkan Nomor Bangku Pembeli : ") ;
        this.nomor_bangku = input.nextInt() ;

    }

    public int pilih_menu() {
        int menu ;
        System.out.print("\nSilakan Masukan Pilihan Pembeli : ") ;
        menu = input.nextInt() ;
        return menu ;

    }
   

    public void transaksi(int harga) 
    { 
        System.out.print("Uang masuk pembeli : ") ;
        this.uang_masuk = input.nextLong() ;
        this.kembalian = this.uang_masuk - harga ;
        System.out.println("Harga makanan " + harga + " Uang kembalian pembeli : " + this.kembalian+"\n") ;

    }

}

import java.util.Scanner ;
class Pembeli
{
    //variabel global kelas pembeli

    String nama ;
    int nomor_bangku ;
    int uang_masuk, kembalian ;
    char paket ;

    //inisiasi Scanner
    Scanner input = new Scanner(System.in) ;
 

    //method - method pembeli
   

    public void data() 
    {
        System.out.print("Silakan Masukkan Nama Pembeli : ") ;
        nama = input.nextLine() ;
        System.out.print("Silakan Masukkan Nomor Bangku Pembeli : ") ;
        nomor_bangku = input.nextInt() ;

    }

    public void pilih_menu() {
        System.out.print("\nSilakan Masukan Pilihan Pembeli : ") ;
        paket = input.next().charAt(0) ;    

    }
   

    public void transaksi(int harga) 
    { 
        System.out.print("Uang masuk pembeli : ") ;
        uang_masuk = input.nextInt() ;
        kembalian = uang_masuk - harga ;
        System.out.println("Harga makanan " + harga + " Uang kembalian pembeli : " +kembalian+"\n") ;

    }

}

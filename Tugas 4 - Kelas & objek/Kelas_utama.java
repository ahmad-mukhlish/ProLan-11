public class Kelas_utama {
    
    public static void main(String args[]) 
    { Pembeli customer = new Pembeli() ;
      Makanan Pesanan = new Makanan() ;
      customer.data() ;
      Pesanan.tampilkan() ;
      Pesanan.inisiasi_menu_makanan(customer.pilih_menu());
      customer.transaksi(Pesanan.harga) ;
    }
}

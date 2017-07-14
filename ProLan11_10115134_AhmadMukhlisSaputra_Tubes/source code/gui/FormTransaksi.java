/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import customer.*;
import miscellaneous.*;
import delivery.*;
import produk.*;
import java.text.ParseException;

/**
 *
 * @author GOODWARE1
 */
public class FormTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form FormTransaksi
     */
    public FormTransaksi() {

        initComponents();
        awal() ;
        delivery(isDelivery);
        pembungkusan(dibungkus);
        pbl.setDiskon_awal(0.05);
        lgn.setDiskon_awal(0.05);
        bg.add(radio_integer);
        bg.add(radio_string);

    }

    //deklarasi
    Pembeli pbl = new Pembeli();
    Langganan lgn = new Langganan();
    GenerikQu a;
    Delivery deliver = new Delivery();
    Produk makanan = new Makanan(1);
    Produk minuman = new Minuman(1);
    String[] jaraknya = new String[25 + 1];
    String[] bangku = new String[172 + 1];
    String[] menu_makanan = new String[5 + 1];
    String[] menu_minuman = new String[5 + 1];
    String[] pilihan = {"Ya", "Tidak"};
    Boolean dibungkus, isLangganan, isDelivery ;
    Long total, bungkusan, diskon, PPN = 0l, grand, uang_masuk, kembalian;

    //inisiasi combo box jarak
    private javax.swing.ComboBoxModel getComboBoxModelJarak() {
        for (int i = 1; i < 25 + 1; i++) {

            jaraknya[i] = i + " km";

        }
        return new javax.swing.DefaultComboBoxModel(jaraknya);
    }

    //inisiasi combo box nomor bangku
    private javax.swing.ComboBoxModel getComboBoxModelNomorBangku() {
        for (int i = 1; i < 172 + 1; i++) {

            bangku[i] = "" + i;

        }
        return new javax.swing.DefaultComboBoxModel(bangku);
    }

    //inisiasi combo box makanan
    private javax.swing.ComboBoxModel getComboBoxModelMakanan() {
        for (int i = 1; i < 5 + 1; i++) {

            menu_makanan[i] = "Paket makanan " + i + " " + new Makanan(i).getNama_produk() + " " + new Makanan(i).getHarga();

        }
        return new javax.swing.DefaultComboBoxModel(menu_makanan);
    }

    //inisiasi combo box minuman
    private javax.swing.ComboBoxModel getComboBoxModelMinuman() {
        for (int i = 1; i < 5 + 1; i++) {

            menu_minuman[i] = "Paket minuman " + i + " " + new Minuman(i).getNama_produk() + " " + new Minuman(i).getHarga();

        }
        return new javax.swing.DefaultComboBoxModel(menu_minuman);
    }

    //fungsi-fungsi
    private void delivery(Boolean status) {
        lbl_alamat.setEnabled(status);
        input_alamat.setEnabled(status);

        lbl_jarak.setEnabled(status);
        combo_jarak.setEnabled(status);

        lbl_driver.setEnabled(status);
        output_driver.setEnabled(status);

        lbl_ongkir.setEnabled(status);
        output_jasa_ongkir.setEnabled(status);

        lbl_bangku.setEnabled(!status);
        combo_bangku.setEnabled(!status);

        check_dibungkus.setSelected(status);
        pembungkusan(status);

        lbl_waitress.setEnabled(!status);
        output_waitress.setEnabled(!status);

        if (status == true) {
            output_driver.setText(deliver.getNamaPetugas());
            output_kasir.setText(deliver.getNamaKasir());
            output_koki_makanan.setText(deliver.getNamaKoki());
            output_koki_minuman.setText(deliver.getNamaKoki());
            output_waitress.setText("");
            output_jasa_ongkir.setText("" + deliver.hitungOngkir(deliver.getJarak()));
        } else {
            output_driver.setText("");
            output_kasir.setText(makanan.getNamaKasir());
            output_koki_makanan.setText(makanan.getNamaKoki());
            output_koki_minuman.setText(minuman.getNamaKoki());
            output_waitress.setText(makanan.getNamaPetugas());
            output_jasa_ongkir.setText("");
        }
    }

    private void labeling(String customer) {

        lbl_nama.setText("Nama " + customer);
        lbl_bangku.setText("Nomor Bangku " + customer);
        lbl_makanan.setText("Paket Makanan " + customer);
        lbl_j_makanan.setText("Jumlah Makanan " + customer);
        lbl_minuman.setText("Paket Minuman " + customer);
        lbl_j_minuman.setText("Jumlah Minuman " + customer);
        lbl_uang_masuk.setText("Uang Masuk " + customer);
        lbl_kembalian.setText("Kembalian " + customer);
    }

    private void pembungkusan(Boolean status) {
        bungkusan = makanan.bungkus_jenis() + minuman.bungkus_jenis();

        lbl_bungkus.setEnabled(status);
        output_hrg_bungkusnya.setEnabled(status);
        if (status == true) {
            output_hrg_bungkusnya.setText("" + bungkusan);
        } else {
            output_hrg_bungkusnya.setText("");
        }

        perhitungan();

    }

    private void perhitungan() {
        long temp = 0l;

        if (isLangganan == true) {
            if (dibungkus == true) {
                lgn.hitungPotongan(total + bungkusan);
                lgn.transaksi(total, bungkusan, true);
            } else {
                lgn.hitungPotongan(total);
                lgn.transaksi(total, true);
            }
            diskon = (long) lgn.getPotongan();
            PPN = (long) lgn.getPajak();
            temp = (long) lgn.getTotal_bayar();

        } else {
            if (dibungkus == true) {
                pbl.hitungPotongan(total + bungkusan);
                pbl.transaksi(total, bungkusan, true);
            } else {
                pbl.hitungPotongan(total);
                pbl.transaksi(total, true);
            }

            diskon = (long) pbl.getPotongan();
            PPN = (long) pbl.getPajak();
            temp = (long) pbl.getTotal_bayar();

        }

        if (isDelivery == true) {
            grand = (long) temp + deliver.hitungOngkir(deliver.getJarak());
        } else {
            grand = (long) temp;
        }

        output_potongan_harga.setText("" + diskon);
        output_ppn.setText("" + PPN);
        output_grand_total.setText("" + grand);

        kembalian = uang_masuk - grand;
        output_kembalian.setText("" + kembalian);

    }

    private void hitung_bayar() {
        total = makanan.harga_jenis() + minuman.harga_jenis();
        output_hrg_makanan_minuman.setText("" + total);
        pembungkusan(dibungkus);
        perhitungan();

    }

    private void awal() {
        dibungkus = false;
        isLangganan = false;
        isDelivery = false;
        total = 0l;
        bungkusan = 0l;
        diskon = 0l;
        PPN = 0l;
        grand = 0l;
        uang_masuk = 0l;
        kembalian = 0l;
    }

    private void batal() {
        isLangganan = false;
        check_langganan.setSelected(isLangganan);
        labeling("Pembeli");
        isDelivery = false;
        check_delivery.setSelected(isDelivery);
        delivery(isDelivery);
        dibungkus = false;
        pembungkusan(dibungkus);
        check_dibungkus.setSelected(dibungkus);
        bg.clearSelection();
        input_alamat.setText("Alamat");
        combo_jarak.setSelectedIndex(1);
        input_struk.setText("Kode Struk");
        input_nama.setText("Nama");
        combo_bangku.setSelectedIndex(1);
        combo_makanan.setSelectedIndex(1);
        input_jml_makanan.setText("");
        combo_minuman.setSelectedIndex(1);
        input_jml_minuman.setText("");
        output_hrg_makanan_minuman.setText("Harga Makanan dan Minuman");
        output_hrg_bungkusnya.setText("");
        output_potongan_harga.setText("0");
        output_ppn.setText("0");
        output_jasa_ongkir.setText("");
        output_grand_total.setText("0");
        input_uang_masuk.setText("Uang masuk");
        output_kembalian.setText("Kembalian");
        awal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        check_langganan = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        check_delivery = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        check_dibungkus = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        radio_integer = new javax.swing.JRadioButton();
        radio_string = new javax.swing.JRadioButton();
        lbl_alamat = new javax.swing.JLabel();
        input_alamat = new javax.swing.JTextField();
        lbl_jarak = new javax.swing.JLabel();
        combo_jarak = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_struk = new javax.swing.JLabel();
        input_struk = new javax.swing.JTextField();
        lbl_nama = new javax.swing.JLabel();
        input_nama = new javax.swing.JTextField();
        lbl_bangku = new javax.swing.JLabel();
        combo_bangku = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_driver = new javax.swing.JLabel();
        output_driver = new javax.swing.JTextField();
        lbl_kasir = new javax.swing.JLabel();
        output_kasir = new javax.swing.JTextField();
        lbl_makanan = new javax.swing.JLabel();
        combo_makanan = new javax.swing.JComboBox<>();
        lbl_j_makanan = new javax.swing.JLabel();
        input_jml_makanan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        output_koki_makanan = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lbl_minuman = new javax.swing.JLabel();
        combo_minuman = new javax.swing.JComboBox<>();
        lbl_j_minuman = new javax.swing.JLabel();
        input_jml_minuman = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        output_koki_minuman = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        output_hrg_makanan_minuman = new javax.swing.JTextField();
        lbl_bungkus = new javax.swing.JLabel();
        output_hrg_bungkusnya = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        output_potongan_harga = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        output_ppn = new javax.swing.JTextField();
        lbl_ongkir = new javax.swing.JLabel();
        output_jasa_ongkir = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        output_grand_total = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lbl_uang_masuk = new javax.swing.JLabel();
        input_uang_masuk = new javax.swing.JTextField();
        lbl_kembalian = new javax.swing.JLabel();
        output_kembalian = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        output_waitress = new javax.swing.JTextField();
        lbl_waitress = new javax.swing.JLabel();

        setTitle("Form Transaksi");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Form Transaksi Program Restoran Sederhana");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(149, 149, 149))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Memliki Kartu Langganan?");

        check_langganan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_langgananItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Layanan Delivery?");

        check_delivery.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_deliveryItemStateChanged(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Dibungkus?");

        check_dibungkus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_dibungkusItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipe Data Struk?");

        radio_integer.setText("Integer");
        radio_integer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radio_integerStateChanged(evt);
            }
        });

        radio_string.setText("String");

        lbl_alamat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_alamat.setText("Alamat yang dituju ");

        input_alamat.setText("Alamat");
        input_alamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_alamatFocusGained(evt);
            }
        });

        lbl_jarak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_jarak.setText("Jarak menuju alamat");

        combo_jarak.setModel(getComboBoxModelJarak());
        combo_jarak.setSelectedIndex(1);
        combo_jarak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_jarakItemStateChanged(evt);
            }
        });

        lbl_struk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_struk.setText("Kode Struk Pembeli");

        input_struk.setText("Kode Struk");
        input_struk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_strukFocusGained(evt);
            }
        });

        lbl_nama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nama.setText("Nama Langganan Pembeli");

        input_nama.setText("Nama ");
        input_nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_namaFocusGained(evt);
            }
        });

        lbl_bangku.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_bangku.setText("Nomor Bangku Pembeli");

        combo_bangku.setModel(getComboBoxModelNomorBangku());
        combo_bangku.setSelectedIndex(1);

        lbl_driver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_driver.setText("Driver yang bertugas");

        output_driver.setEditable(false);
        output_driver.setText("Nama Driver");

        lbl_kasir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_kasir.setText("Kasir yang bertugas");

        output_kasir.setEditable(false);
        output_kasir.setText("Nama Kasir");

        lbl_makanan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_makanan.setText("Paket Makanan Pembeli");

        combo_makanan.setModel(getComboBoxModelMakanan());
        combo_makanan.setSelectedIndex(1);
        combo_makanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_makananItemStateChanged(evt);
            }
        });

        lbl_j_makanan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_j_makanan.setText("Jumlah Makanan Pembeli");

        input_jml_makanan.setText("Jumlah ");
        input_jml_makanan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_jml_makananFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_jml_makananFocusLost(evt);
            }
        });
        input_jml_makanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_jml_makananActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Koki yang bertugas");

        output_koki_makanan.setEditable(false);
        output_koki_makanan.setText("Nama Koki");

        lbl_minuman.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_minuman.setText("Paket Minuman Pembeli");

        combo_minuman.setModel(getComboBoxModelMinuman());
        combo_minuman.setSelectedIndex(1);
        combo_minuman.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_minumanItemStateChanged(evt);
            }
        });

        lbl_j_minuman.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_j_minuman.setText("Jumlah Minuman Pembeli");

        input_jml_minuman.setText("Jumlah");
        input_jml_minuman.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_jml_minumanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_jml_minumanFocusLost(evt);
            }
        });
        input_jml_minuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_jml_minumanActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Koki yang bertugas");

        output_koki_minuman.setEditable(false);
        output_koki_minuman.setText("Nama Koki");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Harga Makanan dan Minuman");

        output_hrg_makanan_minuman.setEditable(false);
        output_hrg_makanan_minuman.setText("Harga Makanan dan Minuman");

        lbl_bungkus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_bungkus.setText("Harga Bungkusnya");

        output_hrg_bungkusnya.setEditable(false);
        output_hrg_bungkusnya.setText("Harga Bungkusnya");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Potongan Harga");

        output_potongan_harga.setEditable(false);
        output_potongan_harga.setText("Potongan Harga");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("PPN");

        output_ppn.setEditable(false);
        output_ppn.setText("PPN");

        lbl_ongkir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_ongkir.setText("Jasa Ongkir");

        output_jasa_ongkir.setEditable(false);
        output_jasa_ongkir.setText("Jasa Ongkir");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Grand Total");

        output_grand_total.setEditable(false);
        output_grand_total.setText("Grand Total");

        lbl_uang_masuk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_uang_masuk.setText("Uang Masuk Pembeli");

        input_uang_masuk.setText("Uang Masuk");
        input_uang_masuk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_uang_masukFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_uang_masukFocusLost(evt);
            }
        });
        input_uang_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_uang_masukActionPerformed(evt);
            }
        });

        lbl_kembalian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_kembalian.setText("Kembalian Pembeli");

        output_kembalian.setEditable(false);
        output_kembalian.setText("Kembalian");

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        output_waitress.setEditable(false);
        output_waitress.setText("Kembalian");

        lbl_waitress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_waitress.setText("Waitress yang bertugas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 564, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_kasir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_makanan)
                            .addComponent(lbl_j_makanan)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(output_koki_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_jml_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_minuman)
                            .addComponent(lbl_j_minuman)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(output_koki_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_jml_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nama)
                                    .addComponent(lbl_bangku))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_bangku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(output_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_struk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(input_struk, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_uang_masuk)
                            .addComponent(lbl_kembalian)
                            .addComponent(lbl_waitress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_uang_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(output_kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(output_waitress, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(lbl_bungkus)
                            .addComponent(jLabel21)
                            .addComponent(lbl_ongkir)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(output_hrg_makanan_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(output_hrg_bungkusnya, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(output_potongan_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(output_ppn, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(output_jasa_ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(output_grand_total, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_driver)
                                    .addComponent(lbl_jarak)
                                    .addComponent(lbl_alamat)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_jarak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(output_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(input_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(114, 114, 114))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(203, 203, 203)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radio_integer)
                                            .addComponent(check_langganan)
                                            .addComponent(check_delivery)
                                            .addComponent(check_dibungkus))
                                        .addGap(18, 18, 18)
                                        .addComponent(radio_string)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(check_langganan, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_delivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(check_dibungkus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radio_integer)
                        .addComponent(radio_string)))
                .addGap(24, 24, 24)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_jarak, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combo_jarak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(output_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_struk)
                    .addComponent(input_struk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nama)
                    .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bangku)
                    .addComponent(combo_bangku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(output_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_makanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_j_makanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(input_jml_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(output_koki_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_minuman)
                    .addComponent(combo_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_j_minuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(input_jml_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(output_koki_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(output_hrg_makanan_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bungkus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(output_hrg_bungkusnya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(output_potongan_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(output_ppn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ongkir)
                    .addComponent(output_jasa_ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(output_grand_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_uang_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(input_uang_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(output_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(output_waitress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_waitress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_batal))
                .addGap(49, 49, 49))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(771, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void check_deliveryItemStateChanged(java.awt.event.ItemEvent evt) {                                                

        isDelivery = !(evt.getStateChange() == ItemEvent.DESELECTED);
        delivery(isDelivery);
        perhitungan();

    }                                               

    private void check_langgananItemStateChanged(java.awt.event.ItemEvent evt) {                                                 
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            isLangganan = true;
            labeling("Langganan");

        } else {
            isLangganan = false;
            labeling("Pembeli");
        }
        perhitungan();
    }                                                

    private void check_dibungkusItemStateChanged(java.awt.event.ItemEvent evt) {                                                 
        dibungkus = !(evt.getStateChange() == ItemEvent.DESELECTED);
        pembungkusan(dibungkus);
        perhitungan();
    }                                                

    private void radio_integerStateChanged(javax.swing.event.ChangeEvent evt) {                                           

        a = new GenerikQu<String, String>();
        lbl_struk.setText("Kode struk " + "(String)");

    }                                          

    private void input_jml_makananFocusGained(java.awt.event.FocusEvent evt) {                                              
        input_jml_makanan.setText("");
    }                                             

    private void input_jml_makananFocusLost(java.awt.event.FocusEvent evt) {                                            

        int jumlah = Integer.valueOf("" + input_jml_makanan.getText());
        makanan.setJumlah(jumlah);
        hitung_bayar();

    }                                           

    private void combo_jarakItemStateChanged(java.awt.event.ItemEvent evt) {                                             
        deliver.setJarak(combo_jarak.getSelectedIndex());
        output_jasa_ongkir.setText("" + deliver.hitungOngkir(deliver.getJarak()));
        perhitungan();

    }                                            

    private void input_alamatFocusGained(java.awt.event.FocusEvent evt) {                                         
        input_alamat.setText("");
    }                                        

    private void input_strukFocusGained(java.awt.event.FocusEvent evt) {                                        
        input_struk.setText("");
    }                                       

    private void input_namaFocusGained(java.awt.event.FocusEvent evt) {                                       
        input_nama.setText("");
    }                                      

    private void input_jml_minumanFocusGained(java.awt.event.FocusEvent evt) {                                              
        input_jml_minuman.setText("");
    }                                             

    private void input_uang_masukFocusGained(java.awt.event.FocusEvent evt) {                                             
        input_uang_masuk.setText("");
    }                                            

    private void combo_minumanItemStateChanged(java.awt.event.ItemEvent evt) {                                               
        minuman.setProduk(combo_minuman.getSelectedIndex());
        hitung_bayar();
    }                                              

    private void combo_makananItemStateChanged(java.awt.event.ItemEvent evt) {                                               
        makanan.setProduk(combo_makanan.getSelectedIndex());
        hitung_bayar();
    }                                              

    private void input_jml_minumanFocusLost(java.awt.event.FocusEvent evt) {                                            
        int jumlah = Integer.valueOf("" + input_jml_minuman.getText());
        minuman.setJumlah(jumlah);
        hitung_bayar();
    }                                           

    private void input_jml_makananActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        output_waitress.requestFocus();
    }                                                 

    private void input_jml_minumanActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        output_waitress.requestFocus();
    }                                                 

    private void input_uang_masukFocusLost(java.awt.event.FocusEvent evt) {                                           
        uang_masuk = Long.valueOf(input_uang_masuk.getText());
        kembalian = uang_masuk - grand;
        output_kembalian.setText("" + kembalian);
    }                                          

    private void input_uang_masukActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        output_kembalian.requestFocusInWindow();
    }                                                

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int batalkan = JOptionPane.showOptionDialog(null, "Yakin ingin membatalkan transaksi?", "Pembatalan transaksi",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
                pilihan, pilihan[0]);
        if (batalkan == JOptionPane.YES_OPTION) {
            batal();
        }

    }                                         

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int simpankan = JOptionPane.showOptionDialog(null, "Sudah yakin untuk menyimpan?", "Konfirmasi menyimpan",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                pilihan, pilihan[0]);
        if (simpankan == JOptionPane.YES_OPTION) {
        }
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JCheckBox check_delivery;
    private javax.swing.JCheckBox check_dibungkus;
    private javax.swing.JCheckBox check_langganan;
    private javax.swing.JComboBox<String> combo_bangku;
    private javax.swing.JComboBox<String> combo_jarak;
    private javax.swing.JComboBox<String> combo_makanan;
    private javax.swing.JComboBox<String> combo_minuman;
    private javax.swing.JTextField input_alamat;
    private javax.swing.JTextField input_jml_makanan;
    private javax.swing.JTextField input_jml_minuman;
    private javax.swing.JTextField input_nama;
    private javax.swing.JTextField input_struk;
    private javax.swing.JTextField input_uang_masuk;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_bangku;
    private javax.swing.JLabel lbl_bungkus;
    private javax.swing.JLabel lbl_driver;
    private javax.swing.JLabel lbl_j_makanan;
    private javax.swing.JLabel lbl_j_minuman;
    private javax.swing.JLabel lbl_jarak;
    private javax.swing.JLabel lbl_kasir;
    private javax.swing.JLabel lbl_kembalian;
    private javax.swing.JLabel lbl_makanan;
    private javax.swing.JLabel lbl_minuman;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_ongkir;
    private javax.swing.JLabel lbl_struk;
    private javax.swing.JLabel lbl_uang_masuk;
    private javax.swing.JLabel lbl_waitress;
    private javax.swing.JTextField output_driver;
    private javax.swing.JTextField output_grand_total;
    private javax.swing.JTextField output_hrg_bungkusnya;
    private javax.swing.JTextField output_hrg_makanan_minuman;
    private javax.swing.JTextField output_jasa_ongkir;
    private javax.swing.JTextField output_kasir;
    private javax.swing.JTextField output_kembalian;
    private javax.swing.JTextField output_koki_makanan;
    private javax.swing.JTextField output_koki_minuman;
    private javax.swing.JTextField output_potongan_harga;
    private javax.swing.JTextField output_ppn;
    private javax.swing.JTextField output_waitress;
    private javax.swing.JRadioButton radio_integer;
    private javax.swing.JRadioButton radio_string;
    // End of variables declaration                   
}

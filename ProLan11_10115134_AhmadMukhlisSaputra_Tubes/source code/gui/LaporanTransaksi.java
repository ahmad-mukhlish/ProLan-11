/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import miscellaneous.Koneksi;
import produk.*;

/**
 *
 * @author GOODWARE1
 */
public class LaporanTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form LaporanTransaksi
     */
    public LaporanTransaksi() {
        initComponents();

        dbSetting = new Koneksi();
        driver = "com.mysql.jdbc.Driver" ;
        database = "jdbc:mysql://52.76.27.242:3306/sql12186431";
        user = "sql12186431";
        pass = "weSNbDyJM5" ; 

        tabelnyah.setModel(tableModel);
        setTableLoad();
    }

    //deklarasi sql
    Koneksi dbSetting;
    public static String driver, database, user, pass;
    Object tabel;

    //method-method default sql
    public static javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private static javax.swing.table.DefaultTableModel getDefaultTableModel() {

        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Struk", "Nama", "Alamat", "Nomor Bangku", "Makanan", "Jumlah Makanan",
                    "Minuman", "Jumlah Minuman", "Grand Total", "Jarak Ongkir", "Biaya Ongkir", "PPN"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false,
                false, false, false, false, false, false

            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

    }

    static String data[] = new String[12];

    private static void setTableLoad() {
        String stat = "";
        try {

            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            Statement stt = kon.createStatement();
            String SQL = "select * from transaksi";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = new Makanan(res.getInt(5)).getNama_produk();
                data[5] = res.getString(6);
                data[6] = new Minuman(res.getInt(7)).getNama_produk();
                data[7] = res.getString(8);
                data[8] = res.getString(9);
                data[9] = res.getString(10);
                data[10] = res.getString(11);
                data[11] = res.getString(12);
                tableModel.addRow(data);

            }
            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public static void simpankan() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass
            );
            
            Statement stt = kon.createStatement();
            
            //lakukan query
            
            String SQL = "INSERT INTO transaksi ("
                    + "Struk, "
                    + "Nama, "
                    + "Alamat, "
                    + "Bangku, "
                    + "Makanan, "
                    + "Jml_makanan, "
                    + "Minuman, "
                    + "Jml_minuman, "
                    + "Grand_total, "
                    + "Jarak_ongkir, "
                    + "Biaya_ongkir, "
                    + "PPN"
                    + ") VALUES "
                    + "( '" + FormTransaksi.input_struk.getText() + "', " + " '"
                    + FormTransaksi.input_nama.getText() + "', " + " '"
                    + FormTransaksi.input_alamat.getText() + "', " + " "
                    + FormTransaksi.combo_bangku.getSelectedIndex() + ", " + " "
                    + FormTransaksi.combo_makanan.getSelectedIndex() + ", " + " "
                    + FormTransaksi.input_jml_makanan.getText() + ", " + " " 
                    + FormTransaksi.combo_minuman.getSelectedIndex() + ", " + " " 
                    + FormTransaksi.input_jml_minuman.getText() + ", " + " " 
                    + FormTransaksi.output_grand_total.getText() + ", " + " " 
                    + FormTransaksi.combo_jarak.getSelectedIndex() + ", " + " "
                    + FormTransaksi.output_jasa_ongkir.getText() + ", " + " "
                    + " " + FormTransaksi.output_ppn.getText() 
                    + ")";

            String SQL1 = "INSERT INTO transaksi (Struk, Nama, Alamat, Bangku, Makanan, Jml_makanan, Minuman, Jml_minuman, Grand_total, PPN, Jarak_ongkir, Biaya_ongkir) VALUES ('31237', 'Mukhlis', 'Saputra', 123, 2, 4, 4, 123123, 332, 23, 12, 7)";

            stt.execute(SQL);
          
            //output data pada tabel
            setTableLoad() ;
            
          
            stt.close();
            kon.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelnyah = new javax.swing.JTable();

        setTitle("Laporan Transaksi");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Laporan Transaksi");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(164, 164, 164))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelnyah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelnyah);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(23, 23, 23))
        );

        setBounds(0, 0, 640, 477);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelnyah;
    // End of variables declaration//GEN-END:variables
}

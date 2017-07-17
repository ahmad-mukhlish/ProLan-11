package miscellaneous;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOODWARE1
 */
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Koneksi {

    public Properties mypanel, mylanguange;
    private String strNamaPanel;

    public Koneksi() {

    }

    public String SettingPanel(String nmpanel) {
        try {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/database.ini"));

            strNamaPanel = mypanel.getProperty(nmpanel);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);

        }

        return strNamaPanel;
    }

}

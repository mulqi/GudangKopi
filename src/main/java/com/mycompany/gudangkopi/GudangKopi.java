/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gudangkopi;
import com.mycompany.gudangkopi.config.Koneksi;
import java.sql.Connection;

/**
 *
 * @author mulqi
 */

public class GudangKopi {

    public static void main(String[] args) {
        try {
            System.setProperty("flatlaf.uiScale", "1x");
            com.formdev.flatlaf.FlatIntelliJLaf.setup();
        } catch(Exception ex) {
            System.err.println("Gagal mengaktifkan FlatLaf");
        }
        
        Connection c = Koneksi.getKoneksi();
        
        if (c != null) {
            System.out.println("Status: MANTAP!");
        } else {
            System.out.println("Status: YANG BENER BANG!");
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new com.mycompany.gudangkopi.view.MainFrame().setVisible(true);
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.controller;

import com.mycompany.gudangkopi.config.Koneksi;
import com.mycompany.gudangkopi.model.InventarisKopi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deubin
 */

public class InventarisKopiController {
    // method mengambil semua data dari database
    public List<InventarisKopi> getAllInventaris() {
    List<InventarisKopi> listKopi = new ArrayList<>();
    
    // nama kolom
    String query = "SELECT id, grade_name, stock, price_per_kg FROM coffee_grades ORDER BY id ASC"; 
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        conn = com.mycompany.gudangkopi.config.Koneksi.getKoneksi(); 
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            InventarisKopi kopi = new InventarisKopi(
                rs.getString("id"),
                rs.getString("grade_name"),
                rs.getDouble("stock"),
                rs.getDouble("price_per_kg") 
            );
            listKopi.add(kopi);
        }
    } catch (SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(null, "Gagal mengambil data:\n" + e.getMessage());
    e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (ps != null) ps.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
    return listKopi;
    }
    
    public boolean updateInventaris(InventarisKopi kopi) {
        String query = "UPDATE coffee_grades SET grade_name = ?, stock = ?, price_per_kg = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = com.mycompany.gudangkopi.config.Koneksi.getKoneksi();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, kopi.getGradeKopi());
            ps.setDouble(2, kopi.getHargaPerKg());
            ps.setDouble(3, kopi.getStok());
            ps.setString(4, kopi.getIdBarang());
            
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal update data:\n" + e.getMessage());
            return false;
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.controller;

import com.mycompany.gudangkopi.config.Koneksi;
import com.mycompany.gudangkopi.model.ModelBarangMasuk;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BarangMasukController {
    
    public List<String> getDaftarGradeKopi() {
    List<String> listGrade = new ArrayList<>();
    String sql = "SELECT grade_name FROM coffee_grades ORDER BY grade_name ASC";

    try (Connection conn = Koneksi.getKoneksi();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            listGrade.add(rs.getString("grade_name"));
        }
    } catch (SQLException e) {
    }
    return listGrade;
}
    
    public void tampilkanData(DefaultTableModel tableModel) {
    tableModel.setRowCount(0);

    String sql = "SELECT ct.id AS id_transaksi, ct.transaction_date AS tanggal, "
            + "cg.grade_name AS grade_kopi, ct.quantity AS jumlah, "
            + "ct.party_name AS nama_supplier, ct.status AS status "
            + "FROM coffee_transactions ct "
            + "JOIN coffee_grades cg ON ct.coffee_grade_id = cg.id "
            + "WHERE ct.transaction_type = 'MASUK' "
            + "ORDER BY ct.id";

    try (Connection conn = Koneksi.getKoneksi();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

            Object[] row = {
                rs.getInt("id_transaksi"),
                rs.getDate("tanggal"),
                rs.getString("grade_kopi"),
                rs.getString("jumlah"),  
                rs.getString("nama_supplier"),
                rs.getString("status")
            };

            tableModel.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public boolean tambahBarangMasuk(ModelBarangMasuk barang) {
        
        String cariGradeSql = "SELECT id FROM coffee_grades WHERE grade_name = ?";
        String insertGradeSql = "INSERT INTO coffee_grades (grade_name, stock, price_per_kg) VALUES (?, 0, 0)";
        String insertTransaksiSql = "INSERT INTO coffee_transactions "
                + "(transaction_date, coffee_grade_id, quantity, transaction_type, party_name, status) "
                + "VALUES (?, ?, ?, 'MASUK', ?, ?)";

        Connection conn = null;
        try {
            conn = Koneksi.getKoneksi();
            conn.setAutoCommit(false); 

            int gradeId;
            int jumlahInput = Integer.parseInt(barang.getjumlah());

            try (PreparedStatement psCari = conn.prepareStatement(cariGradeSql)) {
                psCari.setString(1, barang.getgradekopi());
                try (ResultSet rs = psCari.executeQuery()) {
                    if (rs.next()) {
                        gradeId = rs.getInt("id");
                    } else {
                        try (PreparedStatement psInsertGrade = conn.prepareStatement(
                                insertGradeSql, Statement.RETURN_GENERATED_KEYS)) {
                            psInsertGrade.setString(1, barang.getgradekopi());
                            psInsertGrade.executeUpdate();
                            try (ResultSet keys = psInsertGrade.getGeneratedKeys()) {
                                keys.next();
                                gradeId = keys.getInt(1);
                            }
                        }
                    }
                }
            }

            try (PreparedStatement ps = conn.prepareStatement(insertTransaksiSql)) {
                ps.setDate(1, new java.sql.Date(barang.gettanggal().getTime()));
                ps.setInt(2, gradeId);
                ps.setInt(3, jumlahInput);
                ps.setString(4, barang.getnamasupplier());
                ps.setString(5, barang.getstatus());
                ps.executeUpdate();
            }

            conn.commit(); 
            return true;

        } catch (SQLException | NumberFormatException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean ubahStatusBarangMasuk(int idTransaksi, String statusBaru, String JumlahBaruStr) {

        String sqlGetLama = "SELECT coffee_grade_id, quantity, status FROM coffee_transactions WHERE id = ? AND transaction_type = 'MASUK'";
        String sqlUpdateTrans = "UPDATE coffee_transactions SET status = ?, quantity = ? WHERE id = ? AND transaction_type = 'MASUK'";
        String sqlUpdateStok = "UPDATE coffee_grades SET stock = stock + ? WHERE id = ?";

        Connection conn = null;
        try {
            // PARSING STRING KE INT DI SINI
            int JumlahBaru = Integer.parseInt(JumlahBaruStr.trim());

            conn = Koneksi.getKoneksi();
            conn.setAutoCommit(false); 

            int gradeId = 0;
            int jumlahLama = 0;
            String statusLama = "";

            try (PreparedStatement psGet = conn.prepareStatement(sqlGetLama)) {
                psGet.setInt(1, idTransaksi);
                try (ResultSet rs = psGet.executeQuery()) {
                    if (rs.next()) {
                        gradeId = rs.getInt("coffee_grade_id");
                        jumlahLama = rs.getInt("quantity");
                        statusLama = rs.getString("status");
                    } else {
                        conn.rollback();
                        return false; 
                    }
                }
            }

            int kalkulasiEfekStok = 0;

            if (!statusLama.equalsIgnoreCase("Selesai") && statusBaru.equalsIgnoreCase("Selesai")) {
                kalkulasiEfekStok = JumlahBaru; 
            }
            
            else if (statusLama.equalsIgnoreCase("Selesai") && !statusBaru.equalsIgnoreCase("Selesai")) {
                kalkulasiEfekStok = -jumlahLama; 
            }
            
            else if (statusLama.equalsIgnoreCase("Selesai") && statusBaru.equalsIgnoreCase("Selesai")) {
                kalkulasiEfekStok = JumlahBaru - jumlahLama;
            }

       
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdateTrans)) {
                psUpdate.setString(1, statusBaru);
                psUpdate.setInt(2, JumlahBaru); 
                psUpdate.setInt(3, idTransaksi);
                psUpdate.executeUpdate();
            }

          
            if (kalkulasiEfekStok != 0) {
                try (PreparedStatement psStok = conn.prepareStatement(sqlUpdateStok)) {
                    psStok.setInt(1, kalkulasiEfekStok);
                    psStok.setInt(2, gradeId);
                    psStok.executeUpdate();
                }
            }

            conn.commit();
            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format jumlah baru harus berupa angka!");
            return false;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean hapusBarangMasuk(int idTransaksi) {

    String sqlDelete = "DELETE FROM coffee_transactions WHERE id = ? AND transaction_type = 'MASUK'";
    
        Connection conn = null;
        try {
            conn = Koneksi.getKoneksi();
            try (PreparedStatement ps = conn.prepareStatement(sqlDelete)) {
                ps.setInt(1, idTransaksi);
                int rowsDeleted = ps.executeUpdate();
                return rowsDeleted > 0; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}


public void cariBarangMasuk(DefaultTableModel model, String keyword) {

    model.setRowCount(0);

    String sql = """
        SELECT ct.id AS id_transaksi, ct.transaction_date AS tanggal,
               cg.grade_name AS grade_kopi, ct.quantity AS jumlah,
               ct.party_name AS nama_supplier, ct.status AS status
        FROM coffee_transactions ct
        JOIN coffee_grades cg ON ct.coffee_grade_id = cg.id
        WHERE ct.transaction_type = 'MASUK'
        AND (cg.grade_name LIKE ? OR ct.party_name LIKE ?)
        ORDER BY ct.id
    """;

    try (Connection conn = Koneksi.getKoneksi();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("id_transaksi"),
                rs.getDate("tanggal"),
                rs.getString("grade_kopi"),
                rs.getString("jumlah"),
                rs.getString("nama_supplier"),
                rs.getString("status")
            });

        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}


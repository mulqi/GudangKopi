/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.controller;

import com.mycompany.gudangkopi.config.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mulqi
 */

public class LaporanController {
    
    public List<String> getDaftarGrade() {
        List<String> listGrade = new ArrayList<>();
        String sql = "SELECT grade_name FROM coffee_grades ORDER BY grade_name ASC";
        try (Connection conn = Koneksi.getKoneksi();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                listGrade.add(rs.getString("grade_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listGrade;
    }

    public void tampilkanLaporanDinamis(DefaultTableModel tableModel, String jenisLaporan, String gradeFilter, java.util.Date tglMulai, java.util.Date tglSelesai) {
    tableModel.setRowCount(0);
    Connection conn = Koneksi.getKoneksi();
    if (conn == null) return;

    StringBuilder sb = new StringBuilder(
        "SELECT ct.id, ct.transaction_date, cg.grade_name, ct.quantity, ct.party_name, ct.transaction_type " +
        "FROM coffee_transactions ct " +
        "JOIN coffee_grades cg ON ct.coffee_grade_id = cg.id WHERE 1=1 "
    );

    boolean pakaiFilterJenis = jenisLaporan != null && !jenisLaporan.isEmpty()
        && !jenisLaporan.equalsIgnoreCase("Semua Transaksi")
        && !jenisLaporan.equalsIgnoreCase("Tampil Semua Jenis");
    boolean pakaiFilterGrade = gradeFilter != null && !gradeFilter.isEmpty()
        && !gradeFilter.equalsIgnoreCase("Semua Grade")
        && !gradeFilter.equalsIgnoreCase("Tampil Semua Grade");

    if (pakaiFilterJenis) {
        sb.append("AND ct.transaction_type = ? ");
    }

    if (pakaiFilterGrade) {
        sb.append("AND cg.grade_name = ? ");
    }

    if (tglMulai != null) {
        sb.append("AND ct.transaction_date >= ? ");
    }
    if (tglSelesai != null) {
        sb.append("AND ct.transaction_date <= ? ");
    }

    sb.append("ORDER BY ct.transaction_date DESC, ct.id DESC");

    try (PreparedStatement ps = conn.prepareStatement(sb.toString())) {
        int paramIndex = 1;

        if (pakaiFilterJenis) {
            ps.setString(paramIndex++, jenisLaporan.toUpperCase());
        }
        if (pakaiFilterGrade) {
             ps.setString(paramIndex++, gradeFilter);
        }
        if (tglMulai != null) {
            ps.setDate(paramIndex++, new java.sql.Date(tglMulai.getTime()));
        }
        if (tglSelesai != null) {
            ps.setDate(paramIndex++, new java.sql.Date(tglSelesai.getTime()));
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getDate("transaction_date"),
                    rs.getString("grade_name"),
                    rs.getInt("quantity") + " Kg",
                    rs.getString("party_name"),
                    rs.getString("transaction_type")
                };
                tableModel.addRow(row);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat laporan: " + e.getMessage());
        e.printStackTrace();
    }
    }
}

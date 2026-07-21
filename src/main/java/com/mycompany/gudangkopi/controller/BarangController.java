/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.controller;

import com.mycompany.gudangkopi.config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Deubin
 */

public class BarangController {
    // ngambil total akumulasi stok dari database bray
    public double hitungTotalStok() {
        double total = 0;
        String query = "SELECT SUM(stock) AS total FROM coffee_grades";
        
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error di BarangController (hitungTotalStok): " + e.getMessage());
        }
        return total;
    }
    
    public double hitungTotalBarangMasuk() {
        double total = 0;
        // ini ngambil data di database coffe_transactions buat tipe Masuk menjadi total stok
        String query = "SELECT SUM(quantity) AS total FROM coffee_transactions WHERE transaction_type = 'Masuk'"; 

        try (Connection conn = com.mycompany.gudangkopi.config.Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error hitungTotalMasuk: " + e.getMessage());
        }
        return total;
    }
    
    public double hitungTotalBarangKeluar() {
        double total = 0;
        // ini ngambil data di database coffe_transactions buat tipe Keluar menjadi total stok
        String query = "SELECT SUM(quantity) AS total FROM coffee_transactions WHERE transaction_type = 'Keluar'"; 

        try (Connection conn = com.mycompany.gudangkopi.config.Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error hitungTotalBarangKeluar: " + e.getMessage());
        }
        return total;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.config;

/**
 *
 * @author mulqi
 */
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection konek;
    
    public static Connection getKoneksi() {
        if(konek ==null){
            try {
                Dotenv dotenv = Dotenv.load();
                String url = dotenv.get("DB_URL");
                String user = dotenv.get("DB_USER");
                String password = dotenv.get("DB_PASSWORD");

                Class.forName("org.postgresql.Driver");
                konek = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Database Berhasil!");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver PostgreSQL Tidak Ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Koneksi Database Gagal: " + e.getMessage());
            }
        }
        return konek;
    }
}

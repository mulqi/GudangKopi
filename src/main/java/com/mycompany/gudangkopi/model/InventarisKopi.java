/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.model;

/**
 *
 * @author Deubin
 */

public class InventarisKopi {
    private String idBarang;
    private String gradeKopi;
    private double stok;
    private double hargaPerKg;
    private String status;

    public InventarisKopi(String idBarang, String gradeKopi, double stok, double hargaPerKg) {
        this.idBarang = idBarang;
        this.gradeKopi = gradeKopi;
        this.stok = stok;
        this.hargaPerKg = hargaPerKg;
        this.status = hitungStatusOtomatis(stok);
    }

    private String hitungStatusOtomatis(double stok) {
        if (stok == 0) {
            return "Stok Kosong";
        } else if (stok > 250) {
            return "Stok Normal";
        } else {
            return "Stok Rendah";
        }
    }

    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }

    public String getGradeKopi() { return gradeKopi; }
    public void setGradeKopi(String gradeKopi) { this.gradeKopi = gradeKopi; }

    public double getStok() { return stok; }
    public void setStok(double stok) { 
        this.stok = stok; 
        this.status = hitungStatusOtomatis(stok); 
    }

    public double getHargaPerKg() { return hargaPerKg; }
    public void setHargaPerKg(double hargaPerKg) { this.hargaPerKg = hargaPerKg; }

    public String getStatus() { return status; }
}
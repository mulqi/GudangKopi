/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.model;
import java.util.Date;

/**
 *
 * @author mulqi
 */
public class ModelLaporan { 
    private int idTransaksi;
    private Date tanggal;
    private String gradeKopi;
    private int jumlah;
    private String pihak; 
    private String tipeTransaksi; 

    public ModelLaporan(int idTransaksi, Date tanggal, String gradeKopi, int jumlah, String pihak, String tipeTransaksi) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.gradeKopi = gradeKopi;
        this.jumlah = jumlah;
        this.pihak = pihak;
        this.tipeTransaksi = tipeTransaksi;
    }

    // Getter & Setter
    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public Date getTanggal() { return tanggal; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }

    public String getGradeKopi() { return gradeKopi; }
    public void setGradeKopi(String gradeKopi) { this.gradeKopi = gradeKopi; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public String getPihak() { return pihak; }
    public void setPihak(String pihak) { this.pihak = pihak; }

    public String getTipeTransaksi() { return tipeTransaksi; }
    public void setTipeTransaksi(String tipeTransaksi) { this.tipeTransaksi = tipeTransaksi; }
    
}

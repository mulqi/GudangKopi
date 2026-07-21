/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.model;
import java.util.Date;

public class ModelBarangMasuk {
    private int id_transaksi;
    private Date tanggal;
    private String grade_kopi;
    private String jumlah;
    private String nama_supplier;
    private String status;
    
    //contrukctor Lengkap 
    public ModelBarangMasuk(int id_transaksi, Date tanggal, String grade_kopi, String jumlah, String nama_supplier, String status){
        this.id_transaksi = id_transaksi;
        this.tanggal = tanggal;
        this.grade_kopi = grade_kopi;
        this.jumlah = jumlah;
        this.nama_supplier = nama_supplier;
        this.status = status;      
    }
    public int getidtransaksi(){
        return id_transaksi;
    }
    public void setidtransaksi(int id_transaksi){
        this.id_transaksi = id_transaksi;
    }
    public Date gettanggal(){
        return tanggal;
    }
    public void settanggal(Date tanggal){
        this.tanggal = tanggal;
    }
    public String getgradekopi(){
        return grade_kopi;
    }
    public void setgradekopi(String grade_kopi){
        this.grade_kopi = grade_kopi;
    }
    public String getjumlah(){
        return jumlah;
    }
    public void setjumlah(String jumlah){
        this.jumlah = jumlah;
    }
    public String getnamasupplier(){
        return nama_supplier;
    }
    public void setnamasupplier(String nama_supplier){
        this.nama_supplier = nama_supplier;
    }
    public String getstatus(){
        return status;
    }
    public void setstatus(String status){
        this.status = status;
    }   
}

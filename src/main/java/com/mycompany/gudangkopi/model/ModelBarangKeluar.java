/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudangkopi.model;
import java.util.Date;

public class ModelBarangKeluar {
    private int id_transaksi;
    private Date tanggal;
    private String grade_kopi;
    private String jumlah;
    private String tujuan_pembeli;
    private String status;
   
    public ModelBarangKeluar(){}
    
    public ModelBarangKeluar(int id_transaksi,Date tanggal, String grade_kopi, String jumlah, String tujuan_pembeli, String status){
        this.id_transaksi = id_transaksi;
            this.tanggal = tanggal;
            this.grade_kopi = grade_kopi;
            this.jumlah = jumlah;
            this.tujuan_pembeli = tujuan_pembeli;
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
    public String getgradekopi (){
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
    public String gettujuanpembeli(){
        return tujuan_pembeli;
    }
    public void settujuanpembeli(String tujuan_pembeli){
        this.tujuan_pembeli = tujuan_pembeli;
    }
    public String getstatus(){
        return status;
    }
    public void setstatus(String status){
        this.status = status;
    } 
            
}

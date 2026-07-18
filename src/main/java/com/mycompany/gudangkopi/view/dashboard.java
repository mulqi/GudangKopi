/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.mycompany.gudangkopi.view;

import com.mycompany.gudangkopi.model.InventarisKopi;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.FlatClientProperties;

/**
 *
 * @author mulqi
 */

public final class dashboard extends javax.swing.JPanel {

    private final com.mycompany.gudangkopi.controller.BarangController controller = new com.mycompany.gudangkopi.controller.BarangController();
    private final com.mycompany.gudangkopi.controller.InventarisKopiController kopiController = new com.mycompany.gudangkopi.controller.InventarisKopiController();

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        
        initResponsifLayout();
        applyFlatLafStyles();
        
        if (!java.beans.Beans.isDesignTime()) {
            tampilkanTotalStokBarang();
            tampilkanTotalBarangMasuk();
            tampilkanTotalBarangKeluar();
            loadDataTabel();
        }
    }
    
    private void applyFlatLafStyles() {
        Color bgLight = new Color(248, 250, 252); // Slate 50
        this.setBackground(bgLight);
        
        if (txtDashboard != null) {
            txtDashboard.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
            txtDashboard.setForeground(new Color(15, 23, 42)); // Slate 900
            txtDashboard.setText("Dashboard - Manajemen Stok");
        }
        
        if (jButton1 != null) {
            jButton1.putClientProperty(FlatClientProperties.STYLE, 
                "arc: 8; " +
                "background: #3b82f6; " + 
                "foreground: #ffffff; " +
                "borderWidth: 0; " +
                "font: bold 13 Segoe UI; " +
                "focusWidth: 0; " +
                "hoverBackground: #2563eb;");
        }
    }
    
    private void initResponsifLayout() {
        this.removeAll();
        this.setLayout(new BorderLayout(0, 24));
        this.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
      
        JPanel northWrapper = new JPanel();
        northWrapper.setOpaque(false);
        northWrapper.setLayout(new BoxLayout(northWrapper, BoxLayout.Y_AXIS));
        
        txtDashboard.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        northWrapper.add(txtDashboard);
        this.add(northWrapper, BorderLayout.NORTH);
        
        JPanel mainContainer = new JPanel(new BorderLayout(0, 24));
        mainContainer.setOpaque(false);
        
        JPanel rowKartuPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        rowKartuPanel.setOpaque(false);
        
        rowKartuPanel.add(Card("Total Stok Keseluruhan", txtTotalStok, jPanel2));           
        rowKartuPanel.add(Card("Total Barang Masuk", lblTotalBarangMasuk, jPanel6));      
        rowKartuPanel.add(Card("Total Barang Keluar", lblTotalBarangKeluar, jPanel5));     
        
        mainContainer.add(rowKartuPanel, BorderLayout.NORTH);
        
        JPanel tableContainer = new JPanel(new BorderLayout(0, 16));
        tableContainer.setBackground(Color.WHITE);
        tableContainer.setOpaque(true);
        tableContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tableContainer.putClientProperty(FlatClientProperties.STYLE, "arc: 16; background: #ffffff;");
        
        JPanel tableHeaderPanel = new JPanel(new BorderLayout());
        tableHeaderPanel.setOpaque(false);
        
        jLabel10.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 16));
        jLabel10.setForeground(new Color(15, 23, 42));
        jLabel10.setText("Data Struktur Inventaris Saat Ini");
        tableHeaderPanel.add(jLabel10, BorderLayout.WEST);
        
        jButton1.setPreferredSize(new Dimension(100, 36));
        tableHeaderPanel.add(jButton1, BorderLayout.EAST);
        
        tableContainer.add(tableHeaderPanel, BorderLayout.NORTH);
       
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        tableContainer.add(jScrollPane1, BorderLayout.CENTER);
        mainContainer.add(tableContainer, BorderLayout.CENTER);
        
        this.add(mainContainer, BorderLayout.CENTER);
        
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        jLabel4.setVisible(false);
        jLabel11.setVisible(false);
        
        this.revalidate();
        this.repaint();
    }
    
    private JPanel Card(String deskripsiJudul, JLabel labelNilai, JPanel iconPanel) {
        JPanel kartu = new JPanel(new BorderLayout(15, 0));
        kartu.setBackground(Color.WHITE);
        kartu.setOpaque(true);
        kartu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        kartu.putClientProperty(FlatClientProperties.STYLE, "arc: 16; background: #ffffff;");
        
        JLabel lblDeskripsi = new JLabel(deskripsiJudul);
        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        lblDeskripsi.setForeground(new Color(100, 116, 139)); // Slate 500
        
        labelNilai.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 26));
        labelNilai.setForeground(new Color(15, 23, 42)); // Slate 900
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        textPanel.setOpaque(false);
        textPanel.add(lblDeskripsi);
        textPanel.add(labelNilai);
        
        iconPanel.setOpaque(false);
        
        kartu.add(textPanel, BorderLayout.CENTER);
        kartu.add(iconPanel, BorderLayout.EAST);
        
        return kartu;
    }

    public void tampilkanTotalStokBarang() {
        double totalStok = controller.hitungTotalStok();
        txtTotalStok.setText(String.format("%,.0f Kg", totalStok));
    } 
    
    public void tampilkanTotalBarangMasuk() {
        double totalMasuk = controller.hitungTotalBarangMasuk();
        lblTotalBarangMasuk.setText(String.format("%,.0f Kg", totalMasuk));
    }
    
    public void tampilkanTotalBarangKeluar() {
        double totalKeluar = controller.hitungTotalBarangKeluar();
        lblTotalBarangKeluar.setText(String.format("%,.0f Kg", totalKeluar));
    }  
    
    public void loadDataTabel() {
        String[] namaKolom = {"ID Barang", "Grade Kopi", "Stok", "Harga / Kg (Rp)", "Status"};
        DefaultTableModel model = new DefaultTableModel(namaKolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<InventarisKopi> listKopi = kopiController.getAllInventaris();
        for (InventarisKopi k : listKopi) {
            String stokFormat = String.format("%.0f Kg", k.getStok());
            String hargaFormat = String.format("%,.0f", k.getHargaPerKg());

            Object[] baris = {
                k.getIdBarang(),
                k.getGradeKopi(),
                stokFormat,
                hargaFormat,
                k.getStatus()
            };
            model.addRow(baris);
        }
        tblBarang.setModel(model);  

        tblBarang.setRowHeight(44); 
        tblBarang.setShowHorizontalLines(true);
        tblBarang.setShowVerticalLines(false); 
        tblBarang.setGridColor(new Color(241, 245, 249)); 
        tblBarang.setFont(new java.awt.Font("Segoe UI", 0, 13));
        tblBarang.setSelectionBackground(new Color(239, 246, 255)); 
        tblBarang.setSelectionForeground(new Color(29, 78, 216));

        javax.swing.table.JTableHeader header = tblBarang.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        header.setBackground(new Color(248, 250, 252)); 
        header.setForeground(new Color(71, 85, 105)); 
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)));

        tblBarang.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (column == 1) {
                    setHorizontalAlignment(SwingConstants.LEFT); 
                } else {
                    setHorizontalAlignment(SwingConstants.CENTER); 
                }
                
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(250, 251, 253));
                    c.setForeground(new Color(51, 65, 85));
                }
                setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
                return c;
            }
        });

        tblBarang.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.TableCellRenderer() {
            private final JLabel labelText = new JLabel("", SwingConstants.CENTER);
            private final JPanel panelBadge = new JPanel(new BorderLayout());

            {
                labelText.setOpaque(true);
                labelText.setHorizontalAlignment(SwingConstants.CENTER);
                labelText.putClientProperty("FlatLaf.style", "arc: 12; font: bold 11 Segoe UI;"); 
                panelBadge.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
                panelBadge.add(labelText, BorderLayout.CENTER);
            }

            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (!isSelected) {
                    panelBadge.setBackground(row % 2 == 0 ? Color.WHITE : new Color(250, 251, 253));
                } else {
                    panelBadge.setBackground(table.getSelectionBackground());
                }

                if (value != null) {
                    String statusText = value.toString().trim().toLowerCase();
                    labelText.setText(statusText.toUpperCase());

                    if (statusText.contains("normal")) {
                        labelText.setBackground(new Color(220, 252, 231)); 
                        labelText.setForeground(new Color(21, 128, 61));  
                    } else if (statusText.contains("rendah")) {
                        labelText.setBackground(new Color(254, 243, 199)); 
                        labelText.setForeground(new Color(180, 83, 9));    
                    } else {
                        labelText.setBackground(new Color(254, 226, 226)); 
                        labelText.setForeground(new Color(185, 28, 28));   
                    }
                } else {
                    labelText.setText("");
                }
                return panelBadge;
            }
        });

        ((DefaultTableModel)tblBarang.getModel()).fireTableDataChanged();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDashboard = new javax.swing.JLabel();
        txtTotalStok = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblTotalBarangMasuk = new javax.swing.JLabel();
        lblTotalBarangKeluar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1550, 900));

        txtDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDashboard.setText("Dashboard - Manajemen Stok Gudang Kopi");

        txtTotalStok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTotalStok.setText("Total Stok");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Total Barang Keluar");

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(211, 211, 211));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dashboard/totalproduk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel5.setBackground(new java.awt.Color(211, 211, 211));

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dashboard/brgkeluar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Total Stok");

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel6.setBackground(new java.awt.Color(211, 211, 211));

        jLabel9.setBackground(new java.awt.Color(204, 204, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dashboard/brgmasuk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Total Barang Masuk");

        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tabel Grade, Stok & Harga");

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        jButton1.setText("Edit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        lblTotalBarangMasuk.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalBarangMasuk.setText("Total Barang Masuk");

        lblTotalBarangKeluar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalBarangKeluar.setText("Total Barang Keluar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDashboard)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(txtTotalStok))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel3))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(lblTotalBarangMasuk)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(lblTotalBarangKeluar))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel1))))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1310, 1310, 1310)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtDashboard)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtTotalStok))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTotalBarangMasuk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTotalBarangKeluar))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1)
                        .addGap(233, 233, 233))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        FormEditBarang dialogEdit = new FormEditBarang(parentFrame, true);
        dialogEdit.gradeKopi();
        dialogEdit.setVisible(true);
        loadDataTabel();
        tampilkanTotalStokBarang();
        tampilkanTotalBarangMasuk();
        tampilkanTotalBarangKeluar();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void refreshDashboardData() {
        tampilkanTotalStokBarang();
        tampilkanTotalBarangMasuk();
        tampilkanTotalBarangKeluar();
        loadDataTabel();
        
        this.revalidate();
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalBarangKeluar;
    private javax.swing.JLabel lblTotalBarangMasuk;
    private javax.swing.JTable tblBarang;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtTotalStok;
    // End of variables declaration//GEN-END:variables
}
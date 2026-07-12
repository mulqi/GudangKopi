/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.mycompany.gudangkopi.view;

import com.mycompany.gudangkopi.model.InventarisKopi;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author mulqi
 */

public class dashboard extends javax.swing.JPanel {

    private final com.mycompany.gudangkopi.controller.BarangController controller = new com.mycompany.gudangkopi.controller.BarangController();
    private final com.mycompany.gudangkopi.controller.InventarisKopiController kopiController = new com.mycompany.gudangkopi.controller.InventarisKopiController();

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        
        this.setLayout(new java.awt.BorderLayout(20, 20));
        this.setBackground(new java.awt.Color(245, 247, 251)); 
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 30, 25, 30)); 
        
        txtDashboard.setFont(new java.awt.Font("Segoe UI", 1, 22));
        txtDashboard.setForeground(new java.awt.Color(33, 44, 62));
        this.add(txtDashboard, java.awt.BorderLayout.NORTH);
        
        javax.swing.JPanel mainContainer = new javax.swing.JPanel(new java.awt.BorderLayout(0, 25));
        mainContainer.setOpaque(false);
     
        javax.swing.JPanel rowKartuPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 3, 20, 0));
        rowKartuPanel.setOpaque(false);
        
        rowKartuPanel.add(buatUlangKartu(jLabel6, jLabel5, txtTotalStok, jPanel2));           
        rowKartuPanel.add(buatUlangKartu(jLabel8, jLabel3, lblTotalBarangMasuk, jPanel6));      
        rowKartuPanel.add(buatUlangKartu(jLabel4, jLabel1, lblTotalBarangKeluar, jPanel5));     
        
        mainContainer.add(rowKartuPanel, java.awt.BorderLayout.NORTH);
        
        javax.swing.JPanel tableContainer = new javax.swing.JPanel(new java.awt.BorderLayout(15, 15));
        tableContainer.setBackground(java.awt.Color.WHITE);
        tableContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tableContainer.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 16;"); 
        
        javax.swing.JPanel tableHeaderPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        tableHeaderPanel.setOpaque(false);
        
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel10.setForeground(new java.awt.Color(33, 44, 62));
        tableHeaderPanel.add(jLabel10, java.awt.BorderLayout.WEST);
        
        jButton1.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
            "arc: 8; background: #2064E1; foreground: #ffffff; borderWidth: 0; focusWidth: 0; font: bold 14 SansSerif;");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 35));
        tableHeaderPanel.add(jButton1, java.awt.BorderLayout.EAST);
        
        tableContainer.add(tableHeaderPanel, java.awt.BorderLayout.NORTH);
       
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 1));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        tblBarang.setRowHeight(35);
        tblBarang.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 13));
        tblBarang.setFont(new java.awt.Font("Segoe UI", 0, 13));
        
        tableContainer.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        mainContainer.add(tableContainer, java.awt.BorderLayout.CENTER);
        this.add(mainContainer, java.awt.BorderLayout.CENTER);
        
        jLabel11.setVisible(false);
        
        if (!java.beans.Beans.isDesignTime()) {
            tampilkanTotalStokBarang();
            tampilkanTotalBarangMasuk();
            tampilkanTotalBarangKeluar();
            loadDataTabel();
        }
        
        this.revalidate();
        this.repaint();
    }

    private javax.swing.JPanel buatUlangKartu(javax.swing.JLabel borderLabel, javax.swing.JLabel titleLabel, javax.swing.JLabel valueLabel, javax.swing.JPanel iconPanel) {
        javax.swing.JPanel kartu = new javax.swing.JPanel(new java.awt.BorderLayout(15, 0));
        kartu.setBackground(java.awt.Color.WHITE);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 20, 18, 20));
        kartu.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 12;"); // Sudut membulat modern
        
        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        titleLabel.setForeground(new java.awt.Color(120, 130, 140));
        
        valueLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        valueLabel.setForeground(new java.awt.Color(33, 44, 62));
        
        javax.swing.JPanel textPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 0, 5));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(valueLabel);
        
        iconPanel.setOpaque(false);
        
        borderLabel.setVisible(false);
        
        kartu.add(textPanel, java.awt.BorderLayout.CENTER);
        kartu.add(iconPanel, java.awt.BorderLayout.EAST);
        
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

    tblBarang.setShowHorizontalLines(true);
    tblBarang.setShowVerticalLines(true);
    tblBarang.setGridColor(new java.awt.Color(225, 230, 238)); 
    tblBarang.setIntercellSpacing(new java.awt.Dimension(1, 1));
    tblBarang.setRowHeight(40); 

    tblBarang.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected, 
                boolean hasFocus, int row, int column) {
            
            java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            c.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
            
            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(java.awt.Color.WHITE); 
                } else {
                    c.setBackground(new java.awt.Color(244, 246, 249)); 
                }
                c.setForeground(new java.awt.Color(51, 51, 51));
            }
            return c;
        }
    });

    tblBarang.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.TableCellRenderer() {
        private final javax.swing.JLabel labelText = new javax.swing.JLabel("", javax.swing.SwingConstants.CENTER);
        private final javax.swing.JPanel panelBadge = new javax.swing.JPanel(new java.awt.GridBagLayout()) {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                
                String statusText = labelText.getText();
                if (statusText.equalsIgnoreCase("stok normal")) {
                    g2.setColor(new java.awt.Color(16, 171, 119)); 
                } else if (statusText.equalsIgnoreCase("stok rendah")) {
                    g2.setColor(new java.awt.Color(217, 131, 12)); 
                } else {
                    g2.setColor(new java.awt.Color(219, 68, 85));  
                }
                
                int badgeHeight = getHeight() - 14;
                int badgeWidth = getWidth() - 30;
                int x = (getWidth() - badgeWidth) / 2;
                int y = (getHeight() - badgeHeight) / 2;
                g2.fillRoundRect(x, y, badgeWidth, badgeHeight, badgeHeight, badgeHeight);
                g2.dispose();
            }
        };

        {
            labelText.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
            labelText.setForeground(java.awt.Color.WHITE);
            panelBadge.add(labelText);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected, 
                boolean hasFocus, int row, int column) {
            
            String status = (value != null) ? value.toString() : "";
            labelText.setText(status.toLowerCase()); 
       
            if (!isSelected) {
                if (row % 2 == 0) {
                    panelBadge.setBackground(java.awt.Color.WHITE);
                } else {
                    panelBadge.setBackground(new java.awt.Color(244, 246, 249));
                }
            } else {
                panelBadge.setBackground(table.getSelectionBackground());
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/gudangkopi/assets/dashboard/totalproduk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
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
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/gudangkopi/assets/dashboard/brgkeluar.png"))); // NOI18N

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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/gudangkopi/assets/dashboard/brgmasuk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(24, 24, 24))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gudangkopi.view;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mycompany.gudangkopi.controller.BarangKeluarController;
import com.mycompany.gudangkopi.model.ModelBarangKeluar;

/**
 *
 * @author mulqi
 */
public class barangKeluar extends javax.swing.JPanel {

    com.mycompany.gudangkopi.controller.BarangKeluarController cb = new com.mycompany.gudangkopi.controller.BarangKeluarController();
    DefaultTableModel modelTabel;
    private dashboard dash;
    private javax.swing.Timer searchTimerKeluar;

    /**
     * Creates new form barangKeluar
     */
    public barangKeluar() {
        initComponents();
        applyFlatLafStyles();
        
        modelTabel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"ID Transaksi", "Tanggal", "Grade Kopi", "Jumlah", "Tujuan Pembeli", "Status"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            if (tblKeluar != null) {
                tblKeluar.setModel(modelTabel);
                setupTableStyle();
            }
            
            if (cb != null && modelTabel != null) {
                    try {
                        cb.tampilkanData(modelTabel);
                    } catch (Exception e) {
                        System.err.println("Gagal memuat data awal di design mode: " + e.getMessage());
                    }
                }
                    
            setupSearchListener();
    }
    
    private void applyFlatLafStyles() {
        Color bgLight = new Color(245, 247, 250);
        this.setBackground(bgLight);
        
        if (jLabel2 != null) {
            jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22));
            jLabel2.setForeground(new Color(33, 44, 62));
        }
        
        if (jLabel3 != null) {
            jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
            jLabel3.setForeground(new Color(120, 130, 140));
        }
        
        if (Cari != null) {
            if (Cari.getText().equals("SEARCH")) {
                Cari.setText(""); 
            }
            Cari.putClientProperty(com.formdev.flatlaf.FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
            
            JPanel iconWrapper = new JPanel(new BorderLayout());
            iconWrapper.setOpaque(false);
            JLabel lblIcon = new JLabel(new com.formdev.flatlaf.icons.FlatSearchIcon());
            lblIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 5)); 
            iconWrapper.add(lblIcon, BorderLayout.CENTER);
          
            Cari.putClientProperty("JTextField.leadingComponent", iconWrapper);
            Cari.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
                "arc: 20; " +                  
                "borderColor: #e2e8f0; " +
                "focusedBorderColor: #cbd5e1; " +
                "background: #ffffff; " +
                "margin: 6,4,6,12; " +   
                "focusWidth: 1;");
        }
        
        if (btnCari != null) {
            btnCari.setVisible(false);
        }
        
        if (btnInputBarangKeluar != null) {
            btnInputBarangKeluar.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
                "arc: 6; background: #1e293b; foreground: #ffffff; borderWidth: 0; font: bold 12 SansSerif; focusWidth: 0;");
        }
        
        String actionBtnStyle = "arc: 6; background: #ffffff; foreground: #334155; borderWidth: 1; borderColor: #e2e8f0; font: 12 SansSerif; focusWidth: 0;";
        if (btnUbah != null) btnUbah.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, actionBtnStyle);
        if (btnDetail != null) btnDetail.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, actionBtnStyle);
        if (btnHapus != null) btnHapus.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 6; background: #fff5f5; foreground: #ef4444; borderWidth: 1; borderColor: #fecaca; font: 12 SansSerif; focusWidth: 0;");
        
        if (tblKeluar != null) {
            tblKeluar.setBorder(BorderFactory.createEmptyBorder());
        }
       
        if (jSeparator1 != null) {
            jSeparator1.setForeground(new Color(226, 232, 240));
        }
        
    }
    
    private void setupTableStyle() {
        if (tblKeluar == null) return;
        
        tblKeluar.setRowHeight(44); 
        tblKeluar.setShowHorizontalLines(true);
        tblKeluar.setShowVerticalLines(false); 
        
        Color gridColor = new Color(241, 245, 249); 
        tblKeluar.setGridColor(gridColor);
        tblKeluar.setFont(new java.awt.Font("Segoe UI", 0, 13));
        tblKeluar.setSelectionBackground(new Color(239, 246, 255)); 
        tblKeluar.setSelectionForeground(new Color(29, 78, 216)); 
        
        javax.swing.table.JTableHeader header = tblKeluar.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        header.setBackground(new Color(248, 250, 252));
        header.setForeground(new Color(71, 85, 105)); 
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)));
        
        if (tblkeluar != null) { 
            tblkeluar.setOpaque(false);
            tblkeluar.getViewport().setOpaque(false);
            tblkeluar.setBorder(BorderFactory.createEmptyBorder());
        }
        
        if (jPanel1 != null) {
            jPanel1.setBackground(Color.WHITE);
            jPanel1.setOpaque(true);
            jPanel1.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 16;");
            jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        }

        tblKeluar.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (column == 2 || column == 4) { 
                    setHorizontalAlignment(SwingConstants.LEFT);
                } else {
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
                
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(250, 251, 253));
                    c.setForeground(new Color(51, 65, 85));
                }
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return c;
            }
        });

        tblKeluar.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.TableCellRenderer() {
            private final JLabel labelText = new JLabel("", SwingConstants.CENTER);
            private final JPanel panelBadge = new JPanel(new java.awt.BorderLayout());

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
                    String status = value.toString().trim().toUpperCase();
                    labelText.setText(status);

                    switch (status) {
                        case "SELESAI", "MASUK" -> {
                            labelText.setBackground(new Color(220, 252, 231));
                            labelText.setForeground(new Color(21, 128, 61));
                        }
                        case "DITOLAK", "KELUAR" -> {
                            labelText.setBackground(new Color(254, 226, 226));
                            labelText.setForeground(new Color(185, 28, 28));
                        }
                        default -> {
                            labelText.setBackground(new Color(254, 243, 199));
                            labelText.setForeground(new Color(180, 83, 9));
                        }
                    }
                } else {
                    labelText.setText("");
                }
                return panelBadge;
            }
        });
    }
    
    private void setupSearchListener() {
    if (Cari != null) {
        Cari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void pemicuPencarian() {
                if (searchTimerKeluar != null && searchTimerKeluar.isRunning()) {
                    searchTimerKeluar.stop();
                }

                searchTimerKeluar = new javax.swing.Timer(200, (java.awt.event.ActionEvent e) -> {
                    String keyword = Cari.getText().trim();
                    if (keyword.isEmpty() || keyword.equalsIgnoreCase("SEARCH") || keyword.equals("Search...")) {
                        cb.tampilkanData(modelTabel);
                    } else {
                        cb.cariBarangKeluar(modelTabel, keyword);
                    }
                });
                searchTimerKeluar.setRepeats(false);
                searchTimerKeluar.start();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { pemicuPencarian(); }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { pemicuPencarian(); }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { pemicuPencarian(); }
        });
    }
}
    
    public void setDashboard(dashboard dash) {
    this.dash = dash;
    }
    
    private void triggerDashboardRefresh() {
      if (dash == null) {
            java.awt.Container parent = this.getParent();
            while (parent != null) {
                if (parent instanceof javax.swing.JComponent) {
                    for (java.awt.Component comp : ((javax.swing.JComponent) parent).getComponents()) {
                        if (comp instanceof com.mycompany.gudangkopi.view.dashboard) {
                            dash = (com.mycompany.gudangkopi.view.dashboard) comp;
                            break;
                        }
                    }
                }
                if (dash != null) break;
                parent = parent.getParent();
            }
        }
        
        if (dash != null) {
            dash.refreshDashboardData(); 
        }
    }
    
    private void refreshAllViews() {
    triggerDashboardRefresh();
    java.awt.Container parent = this.getParent();
    while (parent != null) {
        if (parent instanceof javax.swing.JComponent jComponent) {
            for (java.awt.Component comp : jComponent.getComponents()) {
                if (comp instanceof com.mycompany.gudangkopi.view.laporan) {
                    ((com.mycompany.gudangkopi.view.laporan) comp).refreshLaporanData();
                    break;
                }
            }
        }
        parent = parent.getParent();
    }
}
    
    private void tampilkanDetail() {
        int baris = tblKeluar.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih data yang ingin dilihat detailnya!",
                    "Informasi",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idTransaksi = String.valueOf(modelTabel.getValueAt(baris, 0));
        String tanggal = String.valueOf(modelTabel.getValueAt(baris, 1));
        String gradeKopi = String.valueOf(modelTabel.getValueAt(baris, 2));
        String jumlah = String.valueOf(modelTabel.getValueAt(baris, 3));
        String pembeli = String.valueOf(modelTabel.getValueAt(baris, 4));
        String status = String.valueOf(modelTabel.getValueAt(baris, 5));

        Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        JDialog detailDialog = new JDialog(parentWindow, "Detail Transaksi", Dialog.ModalityType.APPLICATION_MODAL);
        detailDialog.setResizable(false);

        JPanel panelUtama = new JPanel(new BorderLayout(0, 20));
        panelUtama.setBackground(Color.WHITE);
        panelUtama.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panelHeader = new JPanel(new GridLayout(2, 1, 0, 4));
        panelHeader.setOpaque(false);
        JLabel lblSub = new JLabel("INFORMASI BARANG KELUAR");
        lblSub.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblSub.setForeground(new Color(148, 163, 184));
        
        JLabel lblTitle = new JLabel("Transaksi #" + idTransaksi);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(33, 44, 62)); 
        panelHeader.add(lblSub);
        panelHeader.add(lblTitle);
        panelUtama.add(panelHeader, BorderLayout.NORTH);

        JPanel panelGrid = new JPanel(new GridBagLayout());
        panelGrid.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 10); 

        String[][] dataInfo = {
            {"Tanggal Keluar", tanggal},
            {"Grade Kopi", gradeKopi},
            {"Jumlah Keluar", jumlah + " Kg"},
            {"Pembeli", pembeli}
        };

        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 13);
        Color colorLabel = new Color(100, 116, 139);
        Font fontValue = new Font("Segoe UI", Font.BOLD, 13);
        Color colorValue = new Color(51, 65, 85); 

        for (int i = 0; i < dataInfo.length; i++) {
            gbc.gridx = 0; gbc.gridy = i; gbc.weightx = 0.3;
            JLabel lbl = new JLabel(dataInfo[i][0]);
            lbl.setFont(fontLabel);
            lbl.setForeground(colorLabel);
            panelGrid.add(lbl, gbc);

            gbc.gridx = 1; gbc.weightx = 0.05;
            JLabel lblTitikDua = new JLabel(":");
            lblTitikDua.setFont(fontLabel);
            lblTitikDua.setForeground(colorLabel);
            panelGrid.add(lblTitikDua, gbc);

            gbc.gridx = 2; gbc.weightx = 0.65;
            JLabel val = new JLabel(dataInfo[i][1]);
            val.setFont(fontValue);
            val.setForeground(colorValue);
            panelGrid.add(val, gbc);
        }

        gbc.gridx = 0; gbc.gridy = dataInfo.length; gbc.weightx = 0.3;
        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(fontLabel);
        lblStatus.setForeground(colorLabel);
        panelGrid.add(lblStatus, gbc);

        gbc.gridx = 1; gbc.weightx = 0.05;
        JLabel lblTitikStatus = new JLabel(":");
        lblTitikStatus.setFont(fontLabel);
        lblTitikStatus.setForeground(colorLabel);
        panelGrid.add(lblTitikStatus, gbc);

        gbc.gridx = 2; gbc.weightx = 0.65;
        final String statusUpper = status.toUpperCase();
        JPanel dialogBadge = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (statusUpper.equals("SELESAI") || statusUpper.contains("NORMAL")) {
                    g2.setColor(new Color(16, 171, 119)); 
                } else if (statusUpper.equals("PENDING") || statusUpper.equals("PROSES") || statusUpper.contains("RENDAH")) {
                    g2.setColor(new Color(245, 158, 11)); 
                } else {
                    g2.setColor(new Color(219, 68, 85)); 
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
                g2.dispose();
            }
        };
        dialogBadge.setBorder(BorderFactory.createEmptyBorder(3, 14, 4, 14));
        JLabel txtStatus = new JLabel(statusUpper);
        txtStatus.setFont(new Font("Segoe UI", Font.BOLD, 11));
        txtStatus.setForeground(Color.WHITE);
        dialogBadge.add(txtStatus);
        
        JPanel containerBadge = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        containerBadge.setOpaque(false);
        containerBadge.add(dialogBadge);
        panelGrid.add(containerBadge, gbc);

        panelUtama.add(panelGrid, BorderLayout.CENTER);

        JButton btnTutup = new JButton("Tutup");
        btnTutup.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
            "arc: 8; background: #f1f5f9; foreground: #334155; borderWidth: 0; font: bold 12 SansSerif; focusWidth: 0;");
        btnTutup.setPreferredSize(new Dimension(80, 32));
        btnTutup.addActionListener(e -> detailDialog.dispose());

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelTombol.setOpaque(false);
        panelTombol.add(btnTutup);
        panelUtama.add(panelTombol, BorderLayout.SOUTH);

        detailDialog.setContentPane(panelUtama);
        detailDialog.pack();
        detailDialog.setSize(380, detailDialog.getHeight());
        detailDialog.setLocationRelativeTo(this);
        detailDialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        Cari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tblkeluar = new javax.swing.JScrollPane();
        tblKeluar = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        btnInputBarangKeluar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("MANAJEMEN KOPI KELUAR");

        btnCari.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        Cari.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Cari.addActionListener(this::CariActionPerformed);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        tblKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblkeluar.setViewportView(tblKeluar);

        btnHapus.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnDetail.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnDetail.setText("Detail");
        btnDetail.addActionListener(this::btnDetailActionPerformed);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("Daftar Transaksi Barang Keluar");

        btnUbah.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tblkeluar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnDetail)
                    .addComponent(btnUbah)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        btnInputBarangKeluar.setBackground(new java.awt.Color(48, 62, 84));
        btnInputBarangKeluar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnInputBarangKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnInputBarangKeluar.setText("+ Input Barang Keluar Baru");
        btnInputBarangKeluar.addActionListener(this::btnInputBarangKeluarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(317, 317, 317)
                .addComponent(btnInputBarangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInputBarangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String keyword = Cari.getText().trim();
        if (keyword.isEmpty()) {
            cb.tampilkanData(modelTabel);
        } else {
            cb.cariBarangKeluar(modelTabel, keyword);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnInputBarangKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputBarangKeluarActionPerformed
        // TODO add your handling code here:
        InputBarangKeluarDialog dialog = new InputBarangKeluarDialog(
            javax.swing.SwingUtilities.getWindowAncestor(this),
            cb
        );
        dialog.setVisible(true);
        if (dialog.isDataTersimpan()) {
            cb.tampilkanData(modelTabel);
            refreshAllViews();
        }
    }//GEN-LAST:event_btnInputBarangKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = tblKeluar.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tblKeluar.getValueAt(baris, 0).toString());
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            if (cb.hapusBarangKeluar(id)) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                cb.tampilkanData(modelTabel);
                refreshAllViews();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        tampilkanDetail();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        String keyword = Cari.getText().trim();
        if (keyword.isEmpty()) {
            cb.tampilkanData(modelTabel);
        } else {
            cb.cariBarangKeluar(modelTabel, keyword);
        }
    }//GEN-LAST:event_CariActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        int baris = tblKeluar.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah!");
            return;
        }

        int idTransaksi = Integer.parseInt(String.valueOf(modelTabel.getValueAt(baris, 0)));
        String tanggal = String.valueOf(modelTabel.getValueAt(baris, 1));
        String gradeKopi = String.valueOf(modelTabel.getValueAt(baris, 2));
        String jumlah = String.valueOf(modelTabel.getValueAt(baris, 3));
        String supplier = String.valueOf(modelTabel.getValueAt(baris, 4));
        String statusLama = String.valueOf(modelTabel.getValueAt(baris, 5));

        UbahBarangKeluarDialog dialog = new UbahBarangKeluarDialog(
            javax.swing.SwingUtilities.getWindowAncestor(this),
            cb,
            idTransaksi, tanggal, gradeKopi, jumlah, supplier, statusLama
        );
        dialog.setVisible(true);

        if (dialog.isDataTersimpan()) {
            cb.tampilkanData(modelTabel);
            refreshAllViews();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private static class InputBarangKeluarDialog extends JDialog {
        private final JTextField txtTanggal = new JTextField();
        private final JComboBox<String> cmbGradeKopi = new JComboBox<>();
        private final BarangKeluarController controller;
        private final JTextField txtJumlah = new JTextField();
        private final JTextField txtPembeli = new JTextField();
        private final JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Selesai", "Proses", "Ditolak"});
        private boolean dataTersimpan = false;

        InputBarangKeluarDialog(Window parent, BarangKeluarController controller) {
            super(parent, "Input Barang Keluar Baru", Dialog.ModalityType.APPLICATION_MODAL);
            this.controller = controller;
            buatForm();
            isiDropdownGrade();
            pack();
            setLocationRelativeTo(parent);
        }

        boolean isDataTersimpan() {
            return dataTersimpan;
        }
        
        private void isiDropdownGrade() {
            cmbGradeKopi.removeAllItems();
            java.util.List<String> listGrade = controller.getDaftarGradeKopi();
            for (String grade : listGrade) {
                cmbGradeKopi.addItem(grade);
            }
        }

        private void buatForm() {
            JPanel panelForm = new JPanel(new GridLayout(0, 2, 10, 10));
            panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            txtTanggal.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
            txtJumlah.putClientProperty("JTextField.placeholderText", "Masukkan jumlah kg/karung");
            txtPembeli.putClientProperty("JTextField.placeholderText", "Nama Pembeli / Distributor");

            panelForm.add(new JLabel("Tanggal (yyyy-MM-dd):"));
            panelForm.add(txtTanggal);
            panelForm.add(new JLabel("Grade Kopi:"));
            panelForm.add(cmbGradeKopi);
            panelForm.add(new JLabel("Jumlah:"));
            panelForm.add(txtJumlah);
            panelForm.add(new JLabel("Tujuan Pembeli:"));
            panelForm.add(txtPembeli);
            panelForm.add(new JLabel("Status:"));
            panelForm.add(cmbStatus);

            JButton btnSimpan = new JButton("Simpan");
            JButton btnBatal = new JButton("Batal");
            btnSimpan.putClientProperty("JButton.buttonType", "roundRect");
            btnBatal.putClientProperty("JButton.buttonType", "roundRect");
            
            btnSimpan.addActionListener(e -> simpanData());
            btnBatal.addActionListener(e -> dispose());

            JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelTombol.add(btnBatal);
            panelTombol.add(btnSimpan);

            setLayout(new BorderLayout());
            add(panelForm, BorderLayout.CENTER);
            add(panelTombol, BorderLayout.SOUTH);
            setMinimumSize(new Dimension(380, 280));
        }

        private void simpanData() {
            java.util.Date tanggal;
            try {
                tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(txtTanggal.getText().trim());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Format tanggal salah, gunakan yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gradeKopi = (cmbGradeKopi.getSelectedItem() != null) ? cmbGradeKopi.getSelectedItem().toString() : "";
            String pembeli = txtPembeli.getText().trim();
            String status = (String) cmbStatus.getSelectedItem();

            if (gradeKopi.isEmpty() || pembeli.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Grade Kopi dan Nama Pembeli tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String jumlah = txtJumlah.getText().trim();
            if (jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModelBarangKeluar barang = new ModelBarangKeluar(0, tanggal, gradeKopi, jumlah, pembeli, status);
            boolean berhasil = controller.tambahBarangKeluar(barang);

            if (berhasil) {
                dataTersimpan = true;
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data. Cek koneksi database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static class UbahBarangKeluarDialog extends JDialog {
        private final JTextField txtTanggal = new JTextField();
        private final JComboBox<String> cmbGradeKopi = new JComboBox<>();
        private final JTextField txtJumlah = new JTextField();
        private final JTextField txtPembeli = new JTextField(); 
        private final JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Selesai", "Proses", "Ditolak"});
        private final BarangKeluarController controller;
        private final int idTransaksi;
        private boolean dataTersimpan = false;

        UbahBarangKeluarDialog(Window parent, BarangKeluarController controller,
            int idTransaksi, String tanggal, String gradeKopi, String jumlah,
            String pembeli, String statusLama) {
            
            super(parent, "Ubah Status Barang Keluar", Dialog.ModalityType.APPLICATION_MODAL);
            this.controller = controller;
            this.idTransaksi = idTransaksi;
            buatForm(tanggal, gradeKopi, jumlah, pembeli, statusLama);
            pack();
            setLocationRelativeTo(parent);
        }

        boolean isDataTersimpan() {
            return dataTersimpan;
        }

        private void buatForm(String tanggal, String gradeKopi, String jumlah, String pembeli, String statusLama) {
            JPanel panelForm = new JPanel(new GridLayout(0, 2, 10, 10));
            panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            txtTanggal.setText(tanggal);
            cmbGradeKopi.addItem(gradeKopi);
            cmbGradeKopi.setSelectedItem(gradeKopi);
            txtJumlah.setText(jumlah);
            txtPembeli.setText(pembeli);
            cmbStatus.setSelectedItem(statusLama);

            txtTanggal.setEnabled(false);
            cmbGradeKopi.setEnabled(false);
            txtJumlah.setEnabled(true);
            txtPembeli.setEnabled(false);
            cmbStatus.setEnabled(true);

            panelForm.add(new JLabel("Tanggal:"));
            panelForm.add(txtTanggal);
            panelForm.add(new JLabel("Grade Kopi:"));
            panelForm.add(cmbGradeKopi);
            panelForm.add(new JLabel("Jumlah:"));
            panelForm.add(txtJumlah);
            panelForm.add(new JLabel("Tujuan Pembeli:"));
            panelForm.add(txtPembeli);
            panelForm.add(new JLabel("Status Baru:"));
            panelForm.add(cmbStatus);

            JButton btnSimpan = new JButton("Simpan");
            JButton btnBatal = new JButton("Batal");
            btnSimpan.putClientProperty("JButton.buttonType", "roundRect");
            btnBatal.putClientProperty("JButton.buttonType", "roundRect");

            btnSimpan.addActionListener(e -> simpanPerubahan());
            btnBatal.addActionListener(e -> dispose());

            JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelTombol.add(btnBatal);
            panelTombol.add(btnSimpan);

            setLayout(new BorderLayout());
            add(panelForm, BorderLayout.CENTER);
            add(panelTombol, BorderLayout.SOUTH);
            setMinimumSize(new Dimension(350, 280));
        }

        private void simpanPerubahan() {
            String statusBaru = (String) cmbStatus.getSelectedItem();
            String jumlahBaruStr = txtJumlah.getText().trim();
            
            if (jumlahBaruStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean berhasil = controller.ubahStatusBarangKeluar(idTransaksi, statusBaru, jumlahBaruStr);

            if (berhasil) {
                dataTersimpan = true;
                JOptionPane.showMessageDialog(this, "Perubahan berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengubah data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnInputBarangKeluar;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblKeluar;
    private javax.swing.JScrollPane tblkeluar;
    // End of variables declaration//GEN-END:variables
}

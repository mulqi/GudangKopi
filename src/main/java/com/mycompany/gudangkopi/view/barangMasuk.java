/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gudangkopi.view;

import com.mycompany.gudangkopi.controller.BarangMasukController;
import com.mycompany.gudangkopi.model.ModelBarangMasuk;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mulqi
 */
public class barangMasuk extends javax.swing.JPanel {
    
    com.mycompany.gudangkopi.controller.BarangMasukController cb = new com.mycompany.gudangkopi.controller.BarangMasukController();
    DefaultTableModel modelTabel;
    private dashboard dash;

    /**
     * Creates new form barangMasuk
     * 
     */
    public barangMasuk() {
        initComponents();
        applyFlatLafStyle();
        
        modelTabel = new DefaultTableModel(
                new Object[][] {},
                new String[] {"ID Transaksi", "Tanggal", "Grade Kopi", "Jumlah", "Nama Supplier", "Status"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            if (tblMasuk != null) {
                tblMasuk.setModel(modelTabel);
                setupTableStyle();
            }
            
            if (cb != null && modelTabel != null) {
                    try {
                        cb.tampilkanData(modelTabel);
                    } catch (Exception e) {
                        System.err.println("Gagal memuat data awal di design mode: " + e.getMessage());
                    }
                }
            
            if (btnDetail != null) btnDetail.addActionListener(e -> tampilkanDetail());
      
            if (btnCari != null && kpencarian != null) {
                btnCari.addActionListener(e -> eksekusiPencarian());
            }
            
    }
    
    private void applyFlatLafStyle() {
        Color bgLight = new Color(245, 247, 250);
        this.setBackground(bgLight);

        panelKontrolUtara.setBackground(bgLight);
        panelKontrolUtara.setOpaque(false);
        
        lbljudull.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22));
        lbljudull.setForeground(new Color(33, 44, 62));
        
        lbltransaksi.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
        lbltransaksi.setForeground(new Color(120, 130, 140));
        
        if (kpencarian.getText().equals("SEARCH")) {
            kpencarian.setText(""); 
        }
        kpencarian.putClientProperty(com.formdev.flatlaf.FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        
        JPanel iconWrapper = new JPanel(new BorderLayout());
        iconWrapper.setOpaque(false);
        
        JLabel lblIcon = new JLabel(new com.formdev.flatlaf.icons.FlatSearchIcon());
        
        lblIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 5)); 
        iconWrapper.add(lblIcon, BorderLayout.CENTER);
      
        kpencarian.putClientProperty("JTextField.leadingComponent", iconWrapper);
        
        kpencarian.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
            "arc: 20; " +                  
            "borderColor: #e2e8f0; " +
            "focusedBorderColor: #cbd5e1; " +
            "background: #ffffff; " +
            "margin: 6,4,6,12; " +   
            "focusWidth: 1;");
        
        if (btnCari != null) {
            btnCari.setVisible(false);
        }
        
        btnInputBarangMasuk.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, 
            "arc: 6; background: #1e293b; foreground: #ffffff; borderWidth: 0; font: bold 12 SansSerif; focusWidth: 0;");
        
        String actionBtnStyle = "arc: 6; background: #ffffff; foreground: #334155; borderWidth: 1; borderColor: #e2e8f0; font: 12 SansSerif; focusWidth: 0;";
        if (btnubah != null) btnubah.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, actionBtnStyle);
        if (btnDetail != null) btnDetail.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, actionBtnStyle);
        if (btnhapus != null) btnhapus.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 6; background: #fff5f5; foreground: #ef4444; borderWidth: 1; borderColor: #fecaca; font: 12 SansSerif; focusWidth: 0;");
        
        tblmasuk.setBorder(BorderFactory.createEmptyBorder());
    }



    private void setupTableStyle() {
        tblMasuk.setRowHeight(40); 
        tblMasuk.setShowHorizontalLines(true);
        tblMasuk.setShowVerticalLines(true); 
        
        Color gridColor = new Color(225, 230, 238); 
        tblMasuk.setGridColor(gridColor);
        tblMasuk.setIntercellSpacing(new java.awt.Dimension(1, 1));
        
        tblMasuk.setFont(new java.awt.Font("Segoe UI", 0, 13));
        
        javax.swing.table.JTableHeader header = tblMasuk.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        header.setBackground(Color.WHITE);
        header.setForeground(new Color(33, 44, 62)); 
        header.setOpaque(true);
        
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, gridColor));
        header.putClientProperty("FlatLaf.style", "separatorColor: #e1e6ee;");
        
        if (tblmasuk != null) {
            tblmasuk.setOpaque(false);
            tblmasuk.getViewport().setOpaque(false);
            tblmasuk.setBorder(BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 1));
        }
        
        if (jPanel1 != null) {
            jPanel1.setBackground(Color.WHITE);
            jPanel1.setOpaque(true);
            jPanel1.putClientProperty(com.formdev.flatlaf.FlatClientProperties.STYLE, "arc: 16;");
            jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        }

        tblMasuk.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER); 
                
                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(244, 246, 249));
                    }
                    c.setForeground(new Color(51, 51, 51));
                } else {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground());
                }
                return c;
            }
        });

        tblMasuk.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.TableCellRenderer() {
            private final JLabel labelText = new JLabel("", SwingConstants.CENTER);
            private final JPanel panelBadge = new JPanel(new java.awt.GridBagLayout()) {
                @Override
                protected void paintComponent(java.awt.Graphics g) {
                    super.paintComponent(g);
                    java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                    g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    String statusText = labelText.getText().toUpperCase();
                    if (statusText.equals("SELESAI") || statusText.contains("NORMAL")) {
                        g2.setColor(new Color(16, 171, 119)); 
                    } else if (statusText.equals("PENDING") || statusText.equals("PROSES") || statusText.contains("RENDAH")) {
                        g2.setColor(new Color(217, 131, 12));  
                    } else {
                        g2.setColor(new Color(219, 68, 85));   
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
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                String status = (value != null) ? value.toString() : "";
                labelText.setText(status.toUpperCase()); 
           
                if (!isSelected) {
                    if (row % 2 == 0) {
                        panelBadge.setBackground(Color.WHITE);
                    } else {
                        panelBadge.setBackground(new Color(244, 246, 249));
                    }
                } else {
                    panelBadge.setBackground(table.getSelectionBackground());
                }
                return panelBadge;
            }
        });
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
    
    private void eksekusiPencarian() {
        String keyword = kpencarian.getText().trim();
            if (keyword.isEmpty() || keyword.equalsIgnoreCase("SEARCH")) {
                cb.tampilkanData(modelTabel);
            } else {
                cb.cariBarangMasuk(modelTabel, keyword);
            }
    }
    
    private void tampilkanDetail() {
        int baris = tblMasuk.getSelectedRow();

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
        String supplier = String.valueOf(modelTabel.getValueAt(baris, 4));
        String status = String.valueOf(modelTabel.getValueAt(baris, 5));

        Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        JDialog detailDialog = new JDialog(parentWindow, "Detail Transaksi", Dialog.ModalityType.APPLICATION_MODAL);
        detailDialog.setResizable(false);

        JPanel panelUtama = new JPanel(new BorderLayout(0, 20));
        panelUtama.setBackground(Color.WHITE);
        panelUtama.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panelHeader = new JPanel(new GridLayout(2, 1, 0, 4));
        panelHeader.setOpaque(false);
        JLabel lblSub = new JLabel("INFORMASI BARANG MASUK");
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
            {"Tanggal Masuk", tanggal},
            {"Grade Kopi", gradeKopi},
            {"Jumlah Masuk", jumlah + " Kg"},
            {"Nama Supplier", supplier}
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

        panelKontrolUtara = new javax.swing.JPanel();
        panelAtas = new javax.swing.JPanel();
        panelSubMenu = new javax.swing.JPanel();
        panelAksiKanan = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        btnInputBarangMasuk = new javax.swing.JButton();
        lbljudull = new javax.swing.JLabel();
        kpencarian = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        tblmasuk = new javax.swing.JScrollPane();
        tblMasuk = new javax.swing.JTable();
        lbltransaksi = new javax.swing.JLabel();
        btnubah = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelKontrolUtara.setOpaque(false);

        panelAtas.setOpaque(false);

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelSubMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelSubMenu.setOpaque(false);

        panelAksiKanan.setOpaque(false);

        javax.swing.GroupLayout panelAksiKananLayout = new javax.swing.GroupLayout(panelAksiKanan);
        panelAksiKanan.setLayout(panelAksiKananLayout);
        panelAksiKananLayout.setHorizontalGroup(
            panelAksiKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAksiKananLayout.setVerticalGroup(
            panelAksiKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSubMenuLayout = new javax.swing.GroupLayout(panelSubMenu);
        panelSubMenu.setLayout(panelSubMenuLayout);
        panelSubMenuLayout.setHorizontalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAksiKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelSubMenuLayout.setVerticalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAksiKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelKontrolUtaraLayout = new javax.swing.GroupLayout(panelKontrolUtara);
        panelKontrolUtara.setLayout(panelKontrolUtaraLayout);
        panelKontrolUtaraLayout.setHorizontalGroup(
            panelKontrolUtaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKontrolUtaraLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panelSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelKontrolUtaraLayout.setVerticalGroup(
            panelKontrolUtaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKontrolUtaraLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelKontrolUtaraLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCari.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        btnInputBarangMasuk.setBackground(new java.awt.Color(48, 62, 84));
        btnInputBarangMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnInputBarangMasuk.setText("+   Input Barang Masuk Baru ");
        btnInputBarangMasuk.addActionListener(this::btnInputBarangMasukActionPerformed);

        lbljudull.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbljudull.setText("MANAJEMEN KOPI MASUK");

        kpencarian.setText("SEARCH");
        kpencarian.addActionListener(this::kpencarianActionPerformed);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblmasuk.setViewportView(tblMasuk);

        lbltransaksi.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbltransaksi.setText("Daftar Transaksi Barang Masuk");

        btnubah.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnubah.setText("Ubah");
        btnubah.addActionListener(this::btnubahActionPerformed);

        btnDetail.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnDetail.setText("Detail");
        btnDetail.addActionListener(this::btnDetailActionPerformed);

        btnhapus.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(this::btnhapusActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblmasuk)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbltransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetail)
                        .addComponent(btnhapus)
                        .addComponent(btnubah))
                    .addComponent(lbltransaksi))
                .addGap(30, 30, 30)
                .addComponent(tblmasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbljudull, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addGap(441, 441, 441)
                        .addComponent(btnInputBarangMasuk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelKontrolUtara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelKontrolUtara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbljudull, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInputBarangMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(116, 116, 116))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        int baris = tblMasuk.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih data yang akan dihapus!");
            return;
        }

        int id = Integer.parseInt(tblMasuk.getValueAt(baris, 0).toString());

        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {

            if (cb.hapusBarangMasuk(id)) {

                JOptionPane.showMessageDialog(this,
                        "Data berhasil dihapus.");

                cb.tampilkanData(modelTabel);
                triggerDashboardRefresh();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Data gagal dihapus.");

            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnInputBarangMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputBarangMasukActionPerformed
        // TODO add your handling code here:
        InputBarangMasukDialog dialog = new InputBarangMasukDialog(
            javax.swing.SwingUtilities.getWindowAncestor(this), 
            cb
        );
        dialog.setVisible(true);
        if (dialog.isDataTersimpan()) {
            cb.tampilkanData(modelTabel); 
            triggerDashboardRefresh();    
        }
    }//GEN-LAST:event_btnInputBarangMasukActionPerformed

    private void kpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kpencarianActionPerformed
        // TODO add your handling code here:
       eksekusiPencarian();
    }//GEN-LAST:event_kpencarianActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        int baris = tblMasuk.getSelectedRow();

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

        UbahBarangMasukDialog dialog = new UbahBarangMasukDialog(
            javax.swing.SwingUtilities.getWindowAncestor(this),
            cb,
            idTransaksi, tanggal, gradeKopi, jumlah, supplier, statusLama
        );
        dialog.setVisible(true);

        if (dialog.isDataTersimpan()) {
            cb.tampilkanData(modelTabel);
            triggerDashboardRefresh();
        }
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailActionPerformed

    /**
     * Dialog sederhana untuk menambah data Barang Masuk.
     * Dipanggil dari tombol "+ Input Barang Masuk Baru" di halaman barangMasuk.
     * (Digabung ke dalam barangMasuk.java sebagai inner class, bukan file terpisah.)
     */
    
    private static class InputBarangMasukDialog extends JDialog {

        private final JTextField txtTanggal = new JTextField();
        private final JComboBox<String> cmbGradeKopi = new JComboBox<>();
        private final BarangMasukController controller ;
        private final JTextField txtJumlah = new JTextField();
        private final JTextField txtSupplier = new JTextField();
        private final JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Selesai", "Proses", "Ditolak"});

        private boolean dataTersimpan = false;

        InputBarangMasukDialog(Window parent, BarangMasukController controller) {
            super(parent, "Input Barang Masuk Baru", Dialog.ModalityType.APPLICATION_MODAL);
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

            panelForm.add(new JLabel("Tanggal (yyyy-MM-dd):"));
            panelForm.add(txtTanggal);
            panelForm.add(new JLabel("Grade Kopi:"));
            panelForm.add(cmbGradeKopi);
            panelForm.add(new JLabel("Jumlah:"));
            panelForm.add(txtJumlah);
            panelForm.add(new JLabel("Nama Supplier:"));
            panelForm.add(txtSupplier);
            panelForm.add(new JLabel("Status:"));
            panelForm.add(cmbStatus);

            JButton btnSimpan = new JButton("Simpan");
            JButton btnBatal = new JButton("Batal");
            btnSimpan.addActionListener(e -> simpanData());
            btnBatal.addActionListener(e -> dispose());

            JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelTombol.add(btnBatal);
            panelTombol.add(btnSimpan);

            setLayout(new BorderLayout());
            add(panelForm, BorderLayout.CENTER);
            add(panelTombol, BorderLayout.SOUTH);
            setMinimumSize(new Dimension(350, 250));
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
            String supplier = txtSupplier.getText().trim();
            String status = (String) cmbStatus.getSelectedItem();

            if (gradeKopi.isEmpty() || supplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Grade Kopi dan Nama Supplier tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String jumlah = txtJumlah.getText().trim();
            if (jumlah.isEmpty()) {
                 JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
             }

            ModelBarangMasuk barang = new ModelBarangMasuk(0, tanggal, gradeKopi, jumlah, supplier, status);
            boolean berhasil = controller.tambahBarangMasuk(barang);

            if (berhasil) {
                dataTersimpan = true;
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Dialog sederhana untuk mengubah data Barang Masuk.
     * Dipanggil dari tombol "Ubah" di halaman barangMasuk.
     * Hanya field Status yang boleh diubah (enabled = true),
     * field lainnya dikunci / tidak bisa diedit (enabled = false)
     * karena data transaksi (tanggal, grade, jumlah, supplier) yang sudah
     * tercatat tidak boleh diubah, yang boleh berubah cuma statusnya saja.
     */
    private static class UbahBarangMasukDialog extends JDialog {

        private final JTextField txtTanggal = new JTextField();
        private final JComboBox<String> cmbGradeKopi = new JComboBox<>();
        private final JTextField txtJumlah = new JTextField();
        private final JTextField txtSupplier = new JTextField();
        private final JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Selesai", "Proses", "Ditolak"});
        private final BarangMasukController controller;
        private final int idTransaksi;
        private boolean dataTersimpan = false;

        UbahBarangMasukDialog(Window parent, BarangMasukController controller,
            int idTransaksi, String tanggal, String gradeKopi, String jumlah,
            String supplier, String statusLama) {
            
            super(parent, "Ubah Status Barang Masuk", Dialog.ModalityType.APPLICATION_MODAL);
            this.controller = controller;
            this.idTransaksi = idTransaksi;
            buatForm(tanggal, gradeKopi, jumlah, supplier, statusLama);
            pack();
            setLocationRelativeTo(parent);
        }

        boolean isDataTersimpan() {
            return dataTersimpan;
        }

        private void buatForm(String tanggal, String gradeKopi, String jumlah, String supplier, String statusLama) {
            JPanel panelForm = new JPanel(new GridLayout(0, 2, 10, 10));
            panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            txtTanggal.setText(tanggal);
            cmbGradeKopi.addItem(gradeKopi);
            cmbGradeKopi.setSelectedItem(gradeKopi);
            txtJumlah.setText(jumlah);
            txtSupplier.setText(supplier);
            cmbStatus.setSelectedItem(statusLama);

            txtTanggal.setEnabled(false);
            cmbGradeKopi.setEnabled(false);
            txtJumlah.setEnabled(true);
            txtSupplier.setEnabled(false);
            cmbStatus.setEnabled(true);

            panelForm.add(new JLabel("Tanggal:"));
            panelForm.add(txtTanggal);
            panelForm.add(new JLabel("Grade Kopi:"));
            panelForm.add(cmbGradeKopi);
            panelForm.add(new JLabel("Jumlah:"));
            panelForm.add(txtJumlah);
            panelForm.add(new JLabel("Nama Supplier:"));
            panelForm.add(txtSupplier);
            panelForm.add(new JLabel("Status Baru:"));
            panelForm.add(cmbStatus);

            JButton btnSimpan = new JButton("Simpan");
            JButton btnBatal = new JButton("Batal");
            btnSimpan.addActionListener(e -> simpanPerubahan());
            btnBatal.addActionListener(e -> dispose());

            JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelTombol.add(btnBatal);
            panelTombol.add(btnSimpan);

            setLayout(new BorderLayout());
            add(panelForm, BorderLayout.CENTER);
            add(panelTombol, BorderLayout.SOUTH);
            setMinimumSize(new Dimension(350, 250));
        }

        private void simpanPerubahan() {
            String statusBaru = (String) cmbStatus.getSelectedItem();
            String jumlahBaruStr = txtJumlah.getText().trim();
            
            
            if (jumlahBaruStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                Integer.parseInt(jumlahBaruStr); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka valid!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           
            if (controller.ubahStatusBarangMasuk(idTransaksi, statusBaru, jumlahBaruStr)) {
                dataTersimpan = true;
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui di database!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengubah data ke database. Cek kecocokan tipe data controller.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnInputBarangMasuk;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnubah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kpencarian;
    private javax.swing.JLabel lbljudull;
    private javax.swing.JLabel lbltransaksi;
    private javax.swing.JPanel panelAksiKanan;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelKontrolUtara;
    private javax.swing.JPanel panelSubMenu;
    private javax.swing.JTable tblMasuk;
    private javax.swing.JScrollPane tblmasuk;
    // End of variables declaration//GEN-END:variables
}


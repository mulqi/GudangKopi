/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gudangkopi.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatClientProperties;


/**
 *
 * @author mulqi
 */

public class laporan extends javax.swing.JPanel {
    com.mycompany.gudangkopi.controller.LaporanController cb = new com.mycompany.gudangkopi.controller.LaporanController();
    DefaultTableModel modelTabel;
    
    /**
     * Creates new form laporan
     */
    public laporan() {
        initComponents();
        
        initResponsifLayout();
        
        applyFlatLafStyles();
        
        setupTabelLaporan();
        
        isiComboJenisLaporan();
        isiComboGrade();
        
        if (cb != null && jTable1.getModel() != null) {
            try {
                cb.tampilkanLaporanDinamis((DefaultTableModel) jTable1.getModel(), "Tampil Semua Jenis", "Tampil Semua Grade", null, null);
            } catch (Exception e) {
                System.err.println("Gagal memuat data awal: " + e.getMessage());
            }
        }
    }
    
    private void applyFlatLafStyles() {
            
            String dateChooserStyle = "arc: 8; background: #ffffff; font: 13 Segoe UI;"; 
            if (tanggalMulai != null) tanggalMulai.putClientProperty(FlatClientProperties.STYLE, dateChooserStyle);
            if (tanggalSelesai != null) tanggalSelesai.putClientProperty(FlatClientProperties.STYLE, dateChooserStyle);

            Color bgLight = new Color(248, 250, 252);
            this.setBackground(bgLight);

            if (lblLaporan != null) {
                lblLaporan.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
                lblLaporan.setForeground(new Color(15, 23, 42));
            }

            if (pnlfilter != null) {
                pnlfilter.setBackground(Color.WHITE);
                pnlfilter.setOpaque(true);
                pnlfilter.putClientProperty(FlatClientProperties.STYLE, "arc: 16; background: #ffffff;");
                pnlfilter.setBorder(new com.formdev.flatlaf.ui.FlatLineBorder(
                    new Insets(20, 20, 20, 20), new Color(226, 232, 240), 1, 16
                ));
            }

            String labelFilterStyle = "font: 12 Segoe UI; foreground: #64748b;";
            if (lblJenisLaporan != null) lblJenisLaporan.putClientProperty(FlatClientProperties.STYLE, labelFilterStyle);
            if (lblGrade != null) lblGrade.putClientProperty(FlatClientProperties.STYLE, labelFilterStyle);
            if (lblTanggalMulai != null) lblTanggalMulai.putClientProperty(FlatClientProperties.STYLE, labelFilterStyle);
            if (lblTanggalSelesai != null) lblTanggalSelesai.putClientProperty(FlatClientProperties.STYLE, labelFilterStyle);

            String inputStyle = "arc: 8; borderColor: #cbd5e1; focusedBorderColor: #3b82f6; background: #ffffff; font: 13 Segoe UI;";
            if (cmbJenisLaporan != null) cmbJenisLaporan.putClientProperty(FlatClientProperties.STYLE, inputStyle);
            if (cmbGrade != null) cmbGrade.putClientProperty(FlatClientProperties.STYLE, inputStyle);

            if (btnCariData != null) {
                btnCariData.putClientProperty(FlatClientProperties.STYLE, 
                    "arc: 8; background: #3b82f6; foreground: #ffffff; borderWidth: 0; font: bold 13 Segoe UI; focusWidth: 0; hoverBackground: #2563eb;");
            }

            if (pnlTable != null) {
                pnlTable.setBackground(Color.WHITE);
                pnlTable.setOpaque(true);
                pnlTable.putClientProperty(FlatClientProperties.STYLE, "arc: 16; background: #ffffff;"); 
                pnlTable.setBorder(new com.formdev.flatlaf.ui.FlatLineBorder(
                    new Insets(20, 20, 20, 20), new Color(226, 232, 240), 1, 16
                ));
            }

            if (jLabel6 != null) {
                jLabel6.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 16));
                jLabel6.setForeground(new Color(15, 23, 42));
            }

            String actionBtnStyle = "arc: 8; background: #ffffff; foreground: #334155; borderWidth: 1; borderColor: #cbd5e1; font: bold 12 Segoe UI; focusWidth: 0; hoverBackground: #f8fafc;";
            if (btnExportExel != null) btnExportExel.putClientProperty(FlatClientProperties.STYLE, actionBtnStyle);
            if (btnPDF != null) btnPDF.putClientProperty(FlatClientProperties.STYLE, actionBtnStyle);
            if (btnCetak != null) btnCetak.putClientProperty(FlatClientProperties.STYLE, actionBtnStyle);
        }
  
    private void initResponsifLayout() {
    this.removeAll();
    this.setLayout(new BorderLayout(0, 24));
    this.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
  
    JPanel northWrapper = new JPanel();
    northWrapper.setOpaque(false);
    northWrapper.setLayout(new BoxLayout(northWrapper, BoxLayout.Y_AXIS));
    
    pnlfilter.removeAll();
    pnlfilter.setLayout(new BorderLayout());
    pnlfilter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    JPanel inputsGridPanel = new JPanel(new GridLayout(1, 4, 16, 0));
    inputsGridPanel.setOpaque(false);
    
    Dimension inputSize = new Dimension(150, 36);
    
    JPanel pnlJenis = new JPanel(new BorderLayout(0, 6));
    pnlJenis.setOpaque(false);
    pnlJenis.add(lblJenisLaporan, BorderLayout.NORTH);
    cmbJenisLaporan.setPreferredSize(inputSize);
    pnlJenis.add(cmbJenisLaporan, BorderLayout.CENTER);
    inputsGridPanel.add(pnlJenis);
    
    JPanel pnlGrade = new JPanel(new BorderLayout(0, 6));
    pnlGrade.setOpaque(false);
    pnlGrade.add(lblGrade, BorderLayout.NORTH);
    cmbGrade.setPreferredSize(inputSize);
    pnlGrade.add(cmbGrade, BorderLayout.CENTER);
    inputsGridPanel.add(pnlGrade);
 
    JPanel pnlMulai = new JPanel(new BorderLayout(0, 6));
    pnlMulai.setOpaque(false);
    pnlMulai.add(lblTanggalMulai, BorderLayout.NORTH);
    tanggalMulai.setPreferredSize(inputSize);
    pnlMulai.add(tanggalMulai, BorderLayout.CENTER);
    inputsGridPanel.add(pnlMulai);
    
    JPanel pnlSelesai = new JPanel(new BorderLayout(0, 6));
    pnlSelesai.setOpaque(false);
    pnlSelesai.add(lblTanggalSelesai, BorderLayout.NORTH);
    tanggalSelesai.setPreferredSize(inputSize);
    pnlSelesai.add(tanggalSelesai, BorderLayout.CENTER);
    inputsGridPanel.add(pnlSelesai);
   
    JPanel actionFilterPanel = new JPanel(new BorderLayout());
    actionFilterPanel.setOpaque(false);
 
    actionFilterPanel.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 0)); 
    
    JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    btnWrapper.setOpaque(false);
    btnCariData.setPreferredSize(new Dimension(120, 36));
    btnWrapper.add(btnCariData);
    
    actionFilterPanel.add(btnWrapper, BorderLayout.SOUTH);
    
    pnlfilter.add(inputsGridPanel, BorderLayout.CENTER);
    pnlfilter.add(actionFilterPanel, BorderLayout.EAST);
    
    lblLaporan.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    pnlfilter.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    
    northWrapper.add(lblLaporan);
    northWrapper.add(Box.createVerticalStrut(16)); 
    northWrapper.add(pnlfilter);
    
    pnlTable.setLayout(new BorderLayout(0, 16));
    pnlTable.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    JPanel tableHeaderPanel = new JPanel(new BorderLayout());
    tableHeaderPanel.setOpaque(false);
    
    jLabel6.setText("Data Keseluruhan Transaksi Gudang");
    tableHeaderPanel.add(jLabel6, BorderLayout.WEST);
    
    JPanel actionButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
    actionButtonPanel.setOpaque(false);
    actionButtonPanel.add(btnExportExel);
    actionButtonPanel.add(btnPDF);
    actionButtonPanel.add(btnCetak);
    tableHeaderPanel.add(actionButtonPanel, BorderLayout.EAST);
   
    pnlTable.removeAll();
    pnlTable.add(tableHeaderPanel, BorderLayout.NORTH);
    pnlTable.add(tblLaporan, BorderLayout.CENTER); 
   
    this.add(northWrapper, BorderLayout.NORTH);
    this.add(pnlTable, BorderLayout.CENTER);
    
    this.revalidate();
    this.repaint();
} 
    
    private void setupTabelLaporan() {
        if (jTable1 == null) return;

        modelTabel = new DefaultTableModel(
            new Object[]{"ID Transaksi", "Tanggal", "Grade Kopi", "Jumlah", "Tujuan / Pembeli", "Status"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(modelTabel);

        jTable1.setRowHeight(44); 
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(false); 
        
        Color gridColor = new Color(241, 245, 249); 
        jTable1.setGridColor(gridColor);
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 13));
        jTable1.setSelectionBackground(new Color(239, 246, 255)); 
        jTable1.setSelectionForeground(new Color(29, 78, 216));
        
        // Custom Table Header
        javax.swing.table.JTableHeader header = jTable1.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        header.setBackground(new Color(248, 250, 252)); // Slate 50
        header.setForeground(new Color(71, 85, 105)); // Slate 600
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)));
        
        if (tblLaporan != null) {
            tblLaporan.setOpaque(false);
            tblLaporan.getViewport().setOpaque(false);
            tblLaporan.setBorder(BorderFactory.createEmptyBorder());
        }

        jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (column == 4 || column == 2) {
                    setHorizontalAlignment(SwingConstants.LEFT); 
                } else {
                    setHorizontalAlignment(SwingConstants.CENTER); 
                }
                
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(250, 251, 253));
                    c.setForeground(new Color(51, 65, 85));
                }
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Inner padding text
                return c;
            }
        });

        jTable1.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.TableCellRenderer() {
            private final JLabel labelText = new JLabel("", SwingConstants.CENTER);
            private final JPanel panelBadge = new JPanel(new java.awt.BorderLayout());

            {
                labelText.setOpaque(true);
                labelText.setHorizontalAlignment(SwingConstants.CENTER);
                labelText.putClientProperty("FlatLaf.style", "arc: 12; font: bold 11 Segoe UI;"); 
                panelBadge.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
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

                    if (status.equals("MASUK") || status.equals("SELESAI")) {
                        labelText.setBackground(new Color(220, 252, 231)); // Light Green
                        labelText.setForeground(new Color(21, 128, 61));  // Dark Green
                    } else if (status.equals("KELUAR") || status.equals("DITOLAK")) {
                        labelText.setBackground(new Color(254, 226, 226)); // Light Red
                        labelText.setForeground(new Color(185, 28, 28));   // Dark Red
                    } else {
                        labelText.setBackground(new Color(254, 243, 199)); // Light Amber
                        labelText.setForeground(new Color(180, 83, 9));    // Dark Amber
                    }
                } else {
                    labelText.setText("");
                }
                return panelBadge;
            }
        });
    }
    
    private void pemicuFilterLaporan() {
        String jenis = (cmbJenisLaporan.getSelectedItem() != null) ? cmbJenisLaporan.getSelectedItem().toString() : "";
        String grade = (cmbGrade.getSelectedItem() != null) ? cmbGrade.getSelectedItem().toString() : "";
        
        java.util.Date mulai = tanggalMulai.getDate();
        java.util.Date selesai = tanggalSelesai.getDate();
        
        cb.tampilkanLaporanDinamis((DefaultTableModel) jTable1.getModel(), jenis, grade, mulai, selesai);
    }
  
    private void isiComboJenisLaporan() {
        cmbJenisLaporan.removeAllItems();
        cmbJenisLaporan.addItem("Tampil Semua Jenis");
        cmbJenisLaporan.addItem("MASUK");
        cmbJenisLaporan.addItem("KELUAR");
    }
    
    private void isiComboGrade() {
        cmbGrade.removeAllItems();
        cmbGrade.addItem("Tampil Semua Grade");
        try {
            java.util.List<String> listGrade = cb.getDaftarGrade();
            if(listGrade != null) {
                for (String grade : listGrade) {
                    cmbGrade.addItem(grade);
                }
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat combobox grade: " + e.getMessage());
        }
    }

    public void refreshLaporanData() {
        pemicuFilterLaporan();
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlfilter = new javax.swing.JPanel();
        lblJenisLaporan = new javax.swing.JLabel();
        lblTanggalMulai = new javax.swing.JLabel();
        lblTanggalSelesai = new javax.swing.JLabel();
        lblGrade = new javax.swing.JLabel();
        cmbJenisLaporan = new javax.swing.JComboBox<>();
        tanggalSelesai = new com.toedter.calendar.JDateChooser();
        tanggalMulai = new com.toedter.calendar.JDateChooser();
        cmbGrade = new javax.swing.JComboBox<>();
        btnCariData = new javax.swing.JButton();
        lblLaporan = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        tblLaporan = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnExportExel = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        pnlfilter.setBackground(new java.awt.Color(255, 255, 255));
        pnlfilter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblJenisLaporan.setText("PIlih Jenis Laporan");

        lblTanggalMulai.setText("Tanggal Mulai");

        lblTanggalSelesai.setText("Tanggal Selesai");

        lblGrade.setText("Pilih Grade (opsional)");

        cmbJenisLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbJenisLaporan.addActionListener(this::cmbJenisLaporanActionPerformed);

        cmbGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCariData.setText("Tampilkan ");
        btnCariData.addActionListener(this::btnCariDataActionPerformed);

        javax.swing.GroupLayout pnlfilterLayout = new javax.swing.GroupLayout(pnlfilter);
        pnlfilter.setLayout(pnlfilterLayout);
        pnlfilterLayout.setHorizontalGroup(
            pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfilterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addComponent(lblJenisLaporan)
                        .addGap(6, 6, 6)
                        .addComponent(cmbJenisLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addComponent(lblTanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addComponent(lblTanggalSelesai)
                        .addGap(28, 28, 28)
                        .addComponent(tanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCariData, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlfilterLayout.setVerticalGroup(
            pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfilterLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJenisLaporan)
                    .addComponent(cmbJenisLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGrade)
                            .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTanggalMulai)
                    .addComponent(tanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlfilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlfilterLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTanggalSelesai))
                            .addComponent(tanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlfilterLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCariData)))
                .addContainerGap())
        );

        lblLaporan.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblLaporan.setText("Laporan Transaksi");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLaporan.setViewportView(jTable1);

        jLabel6.setText("Data Keseluruhan Laporan");

        btnCetak.setIcon(new javax.swing.ImageIcon("/media/mulqi/Data/coding/Dev/Tubes/mulqi/GudangKopi/src/main/resources/assets/Laporan/Cetak.png")); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(this::btnCetakActionPerformed);

        btnPDF.setIcon(new javax.swing.ImageIcon("/media/mulqi/Data/coding/Dev/Tubes/mulqi/GudangKopi/src/main/resources/assets/Laporan/PDF.png")); // NOI18N
        btnPDF.setText("Export PDF");
        btnPDF.addActionListener(this::btnPDFActionPerformed);

        btnExportExel.setIcon(new javax.swing.ImageIcon("/media/mulqi/Data/coding/Dev/Tubes/mulqi/GudangKopi/src/main/resources/assets/Laporan/Excel.png")); // NOI18N
        btnExportExel.setText("Export Exel");
        btnExportExel.addActionListener(this::btnExportExelActionPerformed);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportExel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tblLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportExel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblLaporan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(pnlfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 282, Short.MAX_VALUE)))
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLaporan)
                .addGap(18, 18, 18)
                .addComponent(pnlfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan Laporan PDF");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Document (*.pdf)", "pdf"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                fileToSave = new java.io.File(filePath + ".pdf");
            }

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            try {
                com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(fileToSave));
                document.open();

                com.itextpdf.text.Paragraph title = new com.itextpdf.text.Paragraph("Laporan Transaksi Kopi\n\n");
                title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                document.add(title);

                com.itextpdf.text.pdf.PdfPTable pdfTable = new com.itextpdf.text.pdf.PdfPTable(jTable1.getColumnCount());

                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    pdfTable.addCell(jTable1.getColumnName(i));
                }

                for (int rows = 0; rows < jTable1.getRowCount(); rows++) {
                    for (int cols = 0; cols < jTable1.getColumnCount(); cols++) {
                        Object value = jTable1.getValueAt(rows, cols);
                        pdfTable.addCell(value != null ? value.toString() : "");
                    }
                }

                document.add(pdfTable);
                JOptionPane.showMessageDialog(this, "Export ke PDF Berhasil!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saat export PDF: " + ex.getMessage());
            } finally {
                document.close();
            }
        }  
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnCariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDataActionPerformed
        // TODO add your handling code here:
        pemicuFilterLaporan();
    }//GEN-LAST:event_btnCariDataActionPerformed

    private void cmbJenisLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJenisLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJenisLaporanActionPerformed

    private void btnExportExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExelActionPerformed
            // TODO add your handling code here:
            javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
            fileChooser.setDialogTitle("Simpan Laporan Excel");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel File (*.xls)", "xls"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".xls")) {
                    fileToSave = new java.io.File(filePath + ".xls");
                }

                try (java.io.FileWriter fw = new java.io.FileWriter(fileToSave);
                     java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {

                    for (int i = 0; i < jTable1.getColumnCount(); i++) {
                        bw.write(jTable1.getColumnName(i) + "\t"); 
                    }
                    bw.newLine();

                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        for (int j = 0; j < jTable1.getColumnCount(); j++) {
                            Object value = jTable1.getValueAt(i, j);
                            bw.write((value != null ? value.toString() : "") + "\t");
                        }
                        bw.newLine();
                    }

                    JOptionPane.showMessageDialog(this, "Export ke Excel Berhasil!");
                } catch (java.io.IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saat export Excel: " + ex.getMessage());
                }
            }
    }//GEN-LAST:event_btnExportExelActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
            boolean complete = jTable1.print(
                javax.swing.JTable.PrintMode.FIT_WIDTH,
                new java.text.MessageFormat("Laporan Transaksi Kopi"),
                new java.text.MessageFormat("Halaman {0}")
            );
            if (complete) {
                JOptionPane.showMessageDialog(this, "Print berhasil!");
            } else {
                JOptionPane.showMessageDialog(this, "Print dibatalkan.");
            }
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Error saat mencetak: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariData;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnExportExel;
    private javax.swing.JButton btnPDF;
    private javax.swing.JComboBox<String> cmbGrade;
    private javax.swing.JComboBox<String> cmbJenisLaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblJenisLaporan;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblTanggalMulai;
    private javax.swing.JLabel lblTanggalSelesai;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlfilter;
    private com.toedter.calendar.JDateChooser tanggalMulai;
    private com.toedter.calendar.JDateChooser tanggalSelesai;
    private javax.swing.JScrollPane tblLaporan;
    // End of variables declaration//GEN-END:variables
}

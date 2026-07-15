/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gudangkopi.view;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
            
            if (btnDetail != null) btnDetail.addActionListener(e -> tampilkanDetail());
            
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
        
        tblKeluar.setRowHeight(40); 
        tblKeluar.setShowHorizontalLines(true);
        tblKeluar.setShowVerticalLines(true); 
        
        Color gridColor = new Color(225, 230, 238); 
        tblKeluar.setGridColor(gridColor);
        tblKeluar.setIntercellSpacing(new java.awt.Dimension(1, 1));
        tblKeluar.setFont(new java.awt.Font("Segoe UI", 0, 13));
        
        javax.swing.table.JTableHeader header = tblKeluar.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        header.setBackground(Color.WHITE);
        header.setForeground(new Color(33, 44, 62)); 
        header.setOpaque(true);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, gridColor));
        header.putClientProperty("FlatLaf.style", "separatorColor: #e1e6ee;");
        
        if (tblkeluar != null) {
            tblkeluar.setOpaque(false);
            tblkeluar.getViewport().setOpaque(false);
            tblkeluar.setBorder(BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 1));
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

        tblKeluar.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.TableCellRenderer() {
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
    
    private void setupSearchListener() {
        if (Cari != null) {
            Cari.getDocument().addDocumentListener(new DocumentListener() {
                private void lakukanPencarian() {
                    String keyword = Cari.getText().trim();
                    if (keyword.isEmpty() || keyword.equals("Search...")) {
                        cb.tampilkanData(modelTabel);
                    } else {
                        cb.cariBarangKeluar(modelTabel, keyword);
                    }
                }

                @Override
                public void insertUpdate(DocumentEvent e) { lakukanPencarian(); }

                @Override
                public void removeUpdate(DocumentEvent e) { lakukanPencarian(); }

                @Override
                public void changedUpdate(DocumentEvent e) { lakukanPencarian(); }
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
    
    private void tampilkanDetail() {
        int baris = tblKeluar.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih data yang ingin dilihat detailnya!");
            return;
        }

        String idTransaksi = String.valueOf(modelTabel.getValueAt(baris, 0));
        String tanggal = String.valueOf(modelTabel.getValueAt(baris, 1));
        String gradeKopi = String.valueOf(modelTabel.getValueAt(baris, 2));
        String jumlah = String.valueOf(modelTabel.getValueAt(baris, 3));
        String pembeli = String.valueOf(modelTabel.getValueAt(baris, 4));
        String status = String.valueOf(modelTabel.getValueAt(baris, 5));

        String pesan = "ID Transaksi   : " + idTransaksi + "\n"
                + "Tanggal        : " + tanggal + "\n"
                + "Grade Kopi     : " + gradeKopi + "\n"
                + "Jumlah         : " + jumlah + "\n"
                + "Tujuan Pembeli : " + pembeli + "\n"
                + "Status         : " + status;

        JOptionPane.showMessageDialog(
                this,
                pesan,
                "Detail Barang Keluar",
                JOptionPane.INFORMATION_MESSAGE);
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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(tblkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
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
                .addGap(21, 21, 21)
                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addGap(308, 308, 308)
                        .addComponent(btnInputBarangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))))
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
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
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
            triggerDashboardRefresh();
        }
    }//GEN-LAST:event_btnInputBarangKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = tblKeluar.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih data yang akan dihapus!");
            return;
        }

        int id = Integer.parseInt(tblKeluar.getValueAt(baris, 0).toString());

        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {

            if (cb.hapusBarangKeluar(id)) {

                JOptionPane.showMessageDialog(this,
                        "Data berhasil dihapus.");

                cb.tampilkanData(modelTabel);
                triggerDashboardRefresh();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Data gagal dihapus.");

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
            triggerDashboardRefresh();
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

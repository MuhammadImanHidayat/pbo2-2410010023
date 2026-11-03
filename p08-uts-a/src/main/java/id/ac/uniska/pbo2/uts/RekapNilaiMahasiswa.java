/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 * Nama : Muhammad Iman Hidayat
 * NPM : 2410010023
 * @author ASUS
 */
public class RekapNilaiMahasiswa extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RekapNilaiMahasiswa.class.getName());

    // Deklarasi model tabel[cite: 8, 13]
    private final NilaiTableModel model = new NilaiTableModel();

    public RekapNilaiMahasiswa() {
        initComponents();
        
        nilaiTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Pengaturan judul dan tampilan awal
        setTitle("Rekap Nilai Mahasiswa");
        pesanLabel.setForeground(FlatLaf.isLafDark() ? new Color(0xFF8A80) : new Color(0xC62828));
        pesanLabel.setText("");

        // Placeholder untuk text field
        npmField.putClientProperty("JTextField.placeholderText", "10 digit angka");
        tugasField.putClientProperty("JTextField.placeholderText", "0 sampai 100");
        utsField.putClientProperty("JTextField.placeholderText", "0 sampai 100");
        uasField.putClientProperty("JTextField.placeholderText", "0 sampai 100");

        // Menekan tombol Enter otomatis menjalankan tombol Simpan[cite: 3]
        getRootPane().setDefaultButton(simpanButton);

        // Masukkan data uji contoh dari soal untuk mencocokkan tampilan awal[cite: 4]
        isiDataContoh();

        perbaruiRingkasan();
        pack();
        setLocationRelativeTo(null);
    }
    
    // Masukkan data uji contoh sesuai tabel soal[cite: 4]
    private void isiDataContoh() {
        model.tambah(new NilaiMahasiswa("2410010001", "Siti Rahmah", 80, 75, 90));
        model.tambah(new NilaiMahasiswa("2410010002", "Budi Santoso", 70, 72, 74));
        model.tambah(new NilaiMahasiswa("2410010003", "Nur Aisyah", 65, 60, 58));
    }
    
    // Method Simpan & Validasi[cite: 3]
    private void simpan() {
        pesanLabel.setText("");
        String npm = npmField.getText().trim();
        String nama = namaField.getText().trim();

        // 1. Validasi NPM: Wajib 10 digit angka[cite: 3]
        if (!npm.matches("\\d{10}")) {
            pesanLabel.setText("NPM harus 10 digit angka");
            npmField.requestFocusInWindow();
            return;
        }

        // 2. Validasi NPM Ganda[cite: 3]
        if (model.containsNPM(npm)) {
            pesanLabel.setText("NPM " + npm + " sudah terdaftar");
            npmField.requestFocusInWindow();
            return;
        }

        // 3. Validasi Nama: Wajib diisi[cite: 3]
        if (nama.isEmpty()) {
            pesanLabel.setText("Nama wajib diisi");
            namaField.requestFocusInWindow();
            return;
        }

        // 4. Validasi Nilai Tugas, UTS, UAS (0 - 100)[cite: 3]
        int tugas, uts, uas;
        try {
            tugas = Integer.parseInt(tugasField.getText().trim());
            if (tugas < 0 || tugas > 100) throw new NumberFormatException();
        } catch (Exception e) {
            pesanLabel.setText("Nilai Tugas harus angka bulat 0 sampai 100");
            tugasField.requestFocusInWindow();
            return;
        }

        try {
            uts = Integer.parseInt(utsField.getText().trim());
            if (uts < 0 || uts > 100) throw new NumberFormatException();
        } catch (Exception e) {
            pesanLabel.setText("Nilai UTS harus angka bulat 0 sampai 100");
            utsField.requestFocusInWindow();
            return;
        }

        try {
            uas = Integer.parseInt(uasField.getText().trim());
            if (uas < 0 || uas > 100) throw new NumberFormatException();
        } catch (Exception e) {
            pesanLabel.setText("Nilai UAS harus angka bulat 0 sampai 100");
            uasField.requestFocusInWindow();
            return;
        }

        // Simpan ke model tabel[cite: 3]
        model.tambah(new NilaiMahasiswa(npm, nama, tugas, uts, uas));
        
        // Kosongkan form input[cite: 3]
        bersihkanForm();
        perbaruiRingkasan();
    }

    private void bersihkanForm() {
        npmField.setText("");
        namaField.setText("");
        tugasField.setText("");
        utsField.setText("");
        uasField.setText("");
        pesanLabel.setText("");
        npmField.requestFocusInWindow();
    }

    private void perbaruiRingkasan() {
        int jumlah = model.getRowCount();
        double avg = model.getRataRataNilaiAkhir();
        // Menampilkan teks ringkasan ke label bagian bawah[cite: 2, 4]
        ringkasanLabel.setText(String.format(" Jumlah mahasiswa: %d, rata-rata nilai akhir: %.2f", jumlah, avg));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        westPanel = new javax.swing.JPanel();
        npmLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        tugasLabel = new javax.swing.JLabel();
        utsLabel = new javax.swing.JLabel();
        uasLabel = new javax.swing.JLabel();
        npmField = new javax.swing.JTextField();
        namaField = new javax.swing.JTextField();
        tugasField = new javax.swing.JTextField();
        utsField = new javax.swing.JTextField();
        uasField = new javax.swing.JTextField();
        pesanLabel = new javax.swing.JLabel();
        simpanButton = new javax.swing.JButton();
        bersihkanButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nilaiTable = new javax.swing.JTable();
        ringkasanLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        npmLabel.setText("NPM");

        namaLabel.setText("Nama");

        tugasLabel.setText("Nilai Tugas");

        utsLabel.setText("Nilai UTS");

        uasLabel.setText("Nilai UAS");

        npmField.addActionListener(this::npmFieldActionPerformed);

        pesanLabel.setText(" ");

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(this::simpanButtonActionPerformed);

        bersihkanButton.setText("Bersihkan");
        bersihkanButton.addActionListener(this::bersihkanButtonActionPerformed);

        javax.swing.GroupLayout westPanelLayout = new javax.swing.GroupLayout(westPanel);
        westPanel.setLayout(westPanelLayout);
        westPanelLayout.setHorizontalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pesanLabel)
                        .addGroup(westPanelLayout.createSequentialGroup()
                            .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tugasLabel)
                                .addComponent(namaLabel)
                                .addComponent(npmLabel))
                            .addGap(12, 12, 12)
                            .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(namaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addComponent(tugasField)
                                .addComponent(npmField)))
                        .addGroup(westPanelLayout.createSequentialGroup()
                            .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(uasLabel)
                                .addComponent(utsLabel))
                            .addGap(18, 18, 18)
                            .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(uasField)
                                .addComponent(utsField))))
                    .addGroup(westPanelLayout.createSequentialGroup()
                        .addComponent(simpanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bersihkanButton)))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        westPanelLayout.setVerticalGroup(
            westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(westPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(npmLabel)
                    .addComponent(npmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel)
                    .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tugasLabel)
                    .addComponent(tugasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utsLabel)
                    .addComponent(utsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uasLabel)
                    .addComponent(uasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(westPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanButton)
                    .addComponent(bersihkanButton))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        getContentPane().add(westPanel, java.awt.BorderLayout.LINE_START);

        nilaiTable.setModel(model);
        jScrollPane1.setViewportView(nilaiTable);

        ringkasanLabel.setText(" ");

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ringkasanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ringkasanLabel)
                .addContainerGap())
        );

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void npmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmFieldActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void bersihkanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersihkanButtonActionPerformed
        // TODO add your handling code here:
        bersihkanForm();
    }//GEN-LAST:event_bersihkanButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new RekapNilaiMahasiswa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersihkanButton;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTable nilaiTable;
    private javax.swing.JTextField npmField;
    private javax.swing.JLabel npmLabel;
    private javax.swing.JLabel pesanLabel;
    private javax.swing.JLabel ringkasanLabel;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTextField tugasField;
    private javax.swing.JLabel tugasLabel;
    private javax.swing.JTextField uasField;
    private javax.swing.JLabel uasLabel;
    private javax.swing.JTextField utsField;
    private javax.swing.JLabel utsLabel;
    private javax.swing.JPanel westPanel;
    // End of variables declaration//GEN-END:variables
}

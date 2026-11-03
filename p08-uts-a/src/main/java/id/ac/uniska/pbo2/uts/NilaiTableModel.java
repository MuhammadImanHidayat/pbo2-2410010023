/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

/**
 * Nama : Muhammad Iman Hidayat
 * NPM : 2410010023
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class NilaiTableModel extends AbstractTableModel {
    private static final String[] KOLOM = {"NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"};
    private final List<NilaiMahasiswa> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        NilaiMahasiswa m = daftar.get(baris);
        return switch (kolom) {
            case 0 -> m.npm();
            case 1 -> m.nama();
            case 2 -> m.nilaiTugas();
            case 3 -> m.nilaiUTS();
            case 4 -> m.nilaiUAS();
            case 5 -> String.format("%.2f", m.getNilaiAkhir());
            case 6 -> m.getHurufMutu();
            default -> null;
        };
    }

    public void tambah(NilaiMahasiswa m) {
        daftar.add(m);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public boolean containsNPM(String npm) {
        return daftar.stream().anyMatch(m -> m.npm().equalsIgnoreCase(npm));
    }

    public double getRataRataNilaiAkhir() {
        if (daftar.isEmpty()) return 0.0;
        double total = 0;
        for (NilaiMahasiswa m : daftar) {
            total += m.getNilaiAkhir();
        }
        return total / daftar.size();
    }
}

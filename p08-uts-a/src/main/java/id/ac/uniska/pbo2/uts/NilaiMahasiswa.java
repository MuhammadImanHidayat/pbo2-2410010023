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
public record NilaiMahasiswa(
    String npm,
    String nama,
    int nilaiTugas,
    int nilaiUTS,
    int nilaiUAS) 
{
    public double getNilaiAkhir() {
        return (0.30 * nilaiTugas) + (0.30 * nilaiUTS) + (0.40 * nilaiUAS);
    }

    public String getHurufMutu() {
        double akhir = getNilaiAkhir();
        if (akhir >= 80) return "A";
        if (akhir >= 75) return "B+";
        if (akhir >= 70) return "B";
        if (akhir >= 65) return "C+";
        if (akhir >= 60) return "C";
        if (akhir >= 40) return "D";
        return "E";
    }
}
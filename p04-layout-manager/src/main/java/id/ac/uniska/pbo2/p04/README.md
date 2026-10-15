### Eksperimen Praktikum 2 (Galeri Layout Manager)
1. **Pada `flowPanel`, ubah Alignment layout menjadi Center, lalu kecilkan jendela. Apa yang berubah? Baris mana di `initComponents()` yang ikut berubah?**  
   - *Jawaban:* Tombol-tombol di dalam panel akan bergeser ke tengah (*center*) secara otomatis saat jendela dikecilkan hingga pindah baris. Baris kode di `initComponents()` yang berubah adalah properti *alignment* pada inisialisasi `FlowLayout` (misalnya dari `FlowLayout.LEFT` menjadi `FlowLayout.CENTER`).
2. **Pada `gridPanel`, ubah Rows menjadi 4 dan Columns menjadi 2. Berapa baris yang terbentuk dan mengapa?**  
   - *Jawaban:* Terbentuk 4 baris dan 2 kolom (total 8 sel aktif) karena *GridLayout* memaksa pembagian sel secara merata berdasarkan jumlah baris dan kolom yang diset, sehingga ukuran komponen menyesuaikan ukuran sel yang baru.
3. **Pada `boxPanel`, isi properti `maximumSize` keempat tombol dengan lebar 32767... Bagaimana lebar tombol berubah?**  
   - *Jawaban:* Lebar tombol akan ikut merenggang memenuhi lebar penuh dari panel kontainernya secara vertikal (sumbu Y), karena sumbu BoxLayout diatur ke arah Y dan pembatasan ukuran maksimal dihilangkan/diperbesar.

### Eksperimen Praktikum 4 (Form Biodata)
1. **Ubah `Weight X` pada `namaField` menjadi 0.0, lalu lebarkan jendela. Apa yang terjadi pada isian?**  
   - *Jawaban:* Kolom isian (*Text Field*) tidak ikut melebar atau memanjang saat jendela diperbesar; ukurannya tetap seperti ukuran awal dan meninggalkan ruang kosong di sebelah kanannya.
2. **Ubah Direction `formPanel` di dalam `isiPanel` dari North menjadi Center, lalu tinggikan jendela. Apa perbedaannya?**  
   - *Jawaban:* Komponen form di dalam panel akan ikut terdorong meregang ke tengah secara vertikal mengikuti tinggi jendela, tidak lagi menempel rapi di bagian atas (*North*).
3. **Hapus baris `setMinimumSize(getSize())` di konstruktor, lalu kecilkan jendela sekecil mungkin. Bagian mana yang rusak lebih dulu?**  
   - *Jawaban:* Komponen tombol di bagian bawah atau teks judul akan mulai terpotong lebih dulu karena jendela dapat dikecilkan melebihi batas ukuran minimum komponen aslinya.

## 4. Saran Perbaikan dari Teman (Tahap 4)
- **Nama Pemeriksa:** [Rizqian Ardy Rahman]
- **Saran/Catatan:** Jarak antar komponen sudah rapi, tata letak label dan isian sejajar dengan baik, serta form tetap responsif saat dilebarkan. Pastikan placeholder pada form anggota perpustakaan sudah konsisten.

## 6. Deklarasi Penggunaan AI
Alat bantu AI digunakan sebagai panduan konseptual dalam memahami perilaku *Layout Manager* di Java Swing, struktur *GridBagConstraints*, serta membantu proses *debugging* penulisan kode Java Swing pada lingkungan Apache NetBeans.

- **Ukuran Awal:**  
  ![Form Anggota Perpustakaan Ukuran Awal](screenshots/form_awal.png)

- **Saat Dilebarkan (Responsif):**  
  ![Form Anggota Perpustakaan Dilebarkan](screenshots/form_dilebarkan.png)

- **Tab Design & Navigator:**  
  ![Susunan Panel di Navigator](screenshots/navigator_panel.png)
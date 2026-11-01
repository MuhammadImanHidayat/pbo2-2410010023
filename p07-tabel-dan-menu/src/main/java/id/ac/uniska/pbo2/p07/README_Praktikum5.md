# Laporan Praktikum: Tabel, Menu, dan Komponen Lanjutan (p07-tabel-dan-menu)

## Jawaban Eksperimen Praktikum 5 (Modul 7)

### 1. Pengaruh Mengomentari `fireTableRowsInserted`
* **Pertanyaan:** Di `KontakTableModel`, jadikan baris `fireTableRowsInserted(baris, baris);` sebagai komentar, lalu tambah kontak baru. Apakah tabel langsung berubah?
* **Jawaban:** Tidak, tabel tidak langsung berubah secara visual di layar. Data objek baru sebenarnya berhasil ditambahkan ke dalam *List* pada model, tetapi komponen `JTable` tidak menerima notifikasi pembaruan baris disisipkan. Tampilan tabel baru akan diperbarui setelah ada pemicu pembaruan antarmuka (*UI refresh*) lainnya.

### 2. Efek Mengganti `barisTerpilih` Tanpa Konversi Indeks
* **Pertanyaan:** Di method `barisTerpilih`, ganti isinya menjadi `return kontakTable.getSelectedRow();`. Cari kata "ah", pilih Ahmad Fauzi, lalu klik Hapus dan pilih No. Nama siapa yang muncul di dialog konfirmasi?
* **Jawaban:** Nama yang muncul di dialog konfirmasi adalah **nama kontak dari baris pertama pada model asli** (sebelum penyaringan), bukan "Ahmad Fauzi". Hal ini terjadi karena `getSelectedRow()` mengembalikan indeks baris pada tampilan (*view index*), yang nilainya berbeda dengan indeks asli pada model (*model index*) saat fitur pencarian/penyaringan aktif. Penggunaan `convertRowIndexToModel()` mutlak diperlukan untuk menyesuaikan indeks tersebut.

### 3. Pengaruh Mengubah Parameter Modal Dialog
* **Pertanyaan:** Di konstruktor `DialogKontak`, ubah `super(pemilik, judul, true)` menjadi `false`. Saat dialog terbuka, coba klik jendela utama. Apa yang terjadi pada kontak yang ditambahkan?
* **Jawaban:** Jendela utama (`JFrame`) tetap dapat diakses dan diklik oleh pengguna meskipun form dialog sedang terbuka. Mengubah parameter dari `true` menjadi `false` mengubah sifat dialog dari *modal* (mengunci jendela utama) menjadi *non-modal*. Hal ini memungkinkan pengguna berinteraksi dengan jendela utama secara bersamaan saat dialog input masih aktif.

### 4. Perilaku Accelerator `Ctrl+E` dan `Ctrl+D` saat Tanpa Seleksi
* **Pertanyaan:** Tekan `Ctrl+N`, `Ctrl+E`, dan `Ctrl+D`. Mengapa `Ctrl+E` dan `Ctrl+D` tidak bekerja saat tidak ada baris yang dipilih?
* **Jawaban:** `Ctrl+E` (Ubah) dan `Ctrl+D` (Hapus) tidak bekerja karena tombol dan item menu yang bersangkutan berada dalam keadaan non-aktif (`setEnabled(false)`). Melalui logika `perbaruiTombol()`, komponen aksi Ubah dan Hapus hanya diaktifkan jika terdapat baris tabel yang diseleksi (`getSelectedRow() >= 0`). Komponen yang non-aktif tidak akan merespons pemicu pintasan papan ketik (*accelerator*).

### 5. Perubahan Kode `initComponents()` pada Perubahan Accelerator
* **Pertanyaan:** Di tab Design, ubah accelerator `hapusItem` menjadi tombol `Delete` tanpa `Ctrl`. Baris apa yang berubah di `initComponents()`?
* **Jawaban:** Baris kode inisialisasi akselerator pada `hapusItem` berubah dari yang semula menggunakan kombinasi tombol `CTRL`:
  ```java
  hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));

### 6. Dampak Inisialisasi Model Setelah initComponents()
* **Pertanyaan:** Ubah deklarasi atribut menjadi private KontakTableModel model; lalu isi model = new KontakTableModel(); setelah initComponents(). Jalankan. Pesan error apa yang muncul dan mengapa?
* **Jawaban:** Terjadi error NullPointerException. Penyebabnya adalah di dalam method initComponents(), NetBeans GUI Builder mengeksekusi perintah penataan model tabel seperti bukuTable.setModel(model);. Jika model baru diinisialisasi setelah initComponents(), maka saat method tersebut dipanggil nilai model masih null.
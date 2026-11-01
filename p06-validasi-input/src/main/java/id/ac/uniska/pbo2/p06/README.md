# Tugas 6 - Validasi Input dan Kegunaan

## 1. Lembar Peer Review
![Lembar Peer Review Heuristik 1](images/heuristik1.png)
![Lembar Peer Review Heuristik 2](images/heuristik2.png)

## 2. Tabel Perbaikan Berdasarkan Peer Review
![Tabel Singkat Temuan Teman](images/temuan.png)

## 3. Tangkapan Layar (Screenshot)
### Tangkapan Layar Form dengan Pesan Kesalahan
![Pesan Kesalahan](images/error-form.png)

### Jendela Navigator
![Jendela Navigator](images/navigator.png)

## 4. Jawaban Eksperimen Praktikum 4
1. **Ketik huruf pada NPM:** Karakter diblok oleh `evt.consume();` di `npmFieldKeyTyped`.
2. **Email siti@ + Tab:** Pesan error langsung muncul karena dipicu oleh event `focusLost`.
3. **Nama kosong + Tab:** Tidak ada error karena ada pengecekan kondisi `.isBlank()`.
4. **Daftar dengan form kosong:** Fokus otomatis diarahkan ke NPM (`salah.get(0).requestFocusInWindow()`).
5. **Tekan Alt + N:** Fokus ke Nama lengkap berkat properti `Displayed Mnemonic` dan `Label For`.
6. **Batal lalu pilih No:** Data tetap ada karena aksi dibatalkan (`return;`).

## 5. Deklarasi Penggunaan AI
Alat AI (Gemini) digunakan sebagai kolaborator personal untuk membantu menyusun struktur kode Java Swing, memahami konsep GridBagLayout, serta merapikan logika validasi event handler.

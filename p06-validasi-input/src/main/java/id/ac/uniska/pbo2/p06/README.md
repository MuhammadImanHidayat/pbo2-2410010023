# Tugas 6 - Validasi Input dan Kegunaan

## 1. Lembar Peer Review
*(Lampirkan foto atau scan lembar peer review dari teman di sini)*

## 2. Tabel Perbaikan Berdasarkan Peer Review
| No | Temuan / Masukan Teman | Perbaikan yang Dilakukan | Kode Commit |
|----|------------------------|---------------------------|-------------|
| 1. | Contoh: Label pesan error kurang kontras | Menyesuaikan warna dengan fungsi `warnaKesalahan()` FlatLaf | `a1b2c3d` |

## 3. Tangkapan Layar (Screenshot)
* **Form dengan Pesan Kesalahan:**
  *(Sisipkan screenshot form saat ada error)*
* **Jendela Navigator:**
  *(Sisipkan screenshot jendela Navigator NetBeans yang memperlihatkan label pesan)*

## 4. Jawaban Eksperimen Praktikum 4
1. **Ketik huruf pada NPM:** Karakter diblok oleh `evt.consume();` di `npmFieldKeyTyped`.
2. **Email siti@ + Tab:** Pesan error langsung muncul karena dipicu oleh event `focusLost`.
3. **Nama kosong + Tab:** Tidak ada error karena ada pengecekan kondisi `.isBlank()`.
4. **Daftar dengan form kosong:** Fokus otomatis diarahkan ke NPM (`salah.get(0).requestFocusInWindow()`).
5. **Tekan Alt + N:** Fokus ke Nama lengkap berkat properti `Displayed Mnemonic` dan `Label For`.
6. **Batal lalu pilih No:** Data tetap ada karena aksi dibatalkan (`return;`).

## 5. Deklarasi Penggunaan AI
Alat AI (Gemini) digunakan sebagai kolaborator personal untuk membantu menyusun struktur kode Java Swing, memahami konsep GridBagLayout, serta merapikan logika validasi event handler.

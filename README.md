# P07 - Katalog Buku Perpustakaan

## Deskripsi

Aplikasi Katalog Buku Perpustakaan merupakan mini proyek mata kuliah Pemrograman Berbasis Objek 2. Aplikasi ini dibuat menggunakan Java Swing dan FlatLaf dengan NetBeans GUI Builder.

Aplikasi digunakan untuk mengelola data buku perpustakaan, mulai dari menambahkan, mengubah, menghapus, mencari, hingga melihat status ketersediaan buku.

## Fitur Aplikasi

- Menampilkan daftar buku menggunakan JTable dan AbstractTableModel.
- Menyediakan minimal 5 data buku contoh.
- Menambahkan data buku melalui JDialog Form.
- Mengubah data buku yang sudah tersedia.
- Menghapus buku dengan konfirmasi.
- Memvalidasi kode, judul, dan tahun terbit buku.
- Mencari buku berdasarkan kode, judul, atau penulis.
- Mengurutkan data melalui kolom tabel.
- Menampilkan jumlah buku dan jumlah buku yang tersedia.
- Menyediakan menu dan shortcut keyboard.
- Menggunakan FlatLaf untuk tampilan aplikasi.

## Peta Event

| Komponen     | Event                 | Aksi                                              |
| ------------ | --------------------- | ------------------------------------------------- |
| tambahButton | actionPerformed       | Memanggil method tambah()                         |
| ubahButton   | actionPerformed       | Memanggil method ubah()                           |
| hapusButton  | actionPerformed       | Memanggil method hapus()                          |
| tambahItem   | actionPerformed       | Memanggil method tambah()                         |
| ubahItem     | actionPerformed       | Memanggil method ubah()                           |
| hapusItem    | actionPerformed       | Memanggil method hapus()                          |
| keluarItem   | actionPerformed       | Menutup aplikasi                                  |
| tentangItem  | actionPerformed       | Menampilkan informasi aplikasi                    |
| cariField    | keyReleased           | Menjalankan pencarian buku                        |
| bukuTable    | mouseClicked          | Klik dua kali untuk mengubah buku                 |
| bukuTable    | ListSelectionListener | Mengaktifkan tombol Ubah dan Hapus sesuai pilihan |
| simpanButton | actionPerformed       | Memvalidasi dan menyimpan data buku               |
| batalButton  | actionPerformed       | Membatalkan pengisian data buku                   |

### Shortcut Keyboard

- Ctrl + N : Tambah buku.
- Ctrl + E : Ubah buku.
- Ctrl + D : Hapus buku.

## Jawaban Eksperimen Praktikum 5

### 1. Apa yang terjadi jika fireTableRowsInserted(baris, baris) dijadikan komentar lalu menambahkan kontak baru?

Tabel tidak langsung menampilkan kontak yang baru ditambahkan karena JTable tidak mendapatkan pemberitahuan bahwa ada perubahan data pada model. Meskipun data sudah masuk ke dalam model, tampilan tabel tidak otomatis diperbarui. Method fireTableRowsInserted() diperlukan agar JTable mengetahui adanya baris baru.

### 2. Jika barisTerpilih() hanya mengembalikan getSelectedRow(), siapa nama yang muncul saat memilih Ahmad Fauzi dan menekan Hapus?

Nama yang muncul adalah Budi Santoso. Hal ini terjadi karena indeks baris pada tabel yang sudah difilter berbeda dengan indeks data sebenarnya di model. Ahmad Fauzi berada pada baris tampilan yang berbeda dengan posisi datanya di model. Karena itu, diperlukan convertRowIndexToModel() agar data yang diproses tetap sesuai dengan baris yang dipilih.

### 3. Apa yang terjadi jika dialog diubah menjadi modeless dengan mengubah parameter true menjadi false?

Jendela utama tetap bisa digunakan meskipun dialog masih terbuka. Pengguna dapat berpindah dan berinteraksi dengan kedua jendela. Namun, method setVisible(true) tidak lagi menunggu dialog ditutup. Akibatnya, method tampilkan() dapat langsung mengembalikan nilai null sebelum pengguna selesai mengisi dan menyimpan kontak.

### 4. Mengapa Ctrl+E dan Ctrl+D tidak bekerja saat tidak ada baris yang dipilih?

Karena menu Ubah dan Hapus dibuat nonaktif ketika tidak ada baris yang dipilih. Status tersebut diatur melalui method perbaruiTombol(). Menu yang nonaktif tidak dapat menjalankan accelerator. Sementara itu, Ctrl+N tetap bekerja karena menu Tambah selalu aktif.

### 5. Jika accelerator hapusItem diubah menjadi tombol Delete tanpa Ctrl, baris apa yang berubah di initComponents()?

Baris pengaturan accelerator pada hapusItem akan berubah. Sebelumnya menggunakan tombol D dengan kombinasi Ctrl, kemudian berubah menjadi tombol Delete tanpa kombinasi Ctrl.

Contoh kode sebelumnya:

    hapusItem.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_D,
            java.awt.event.InputEvent.CTRL_DOWN_MASK
        )
    );

Setelah diubah, kode menjadi kurang lebih:

    hapusItem.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_DELETE, 0
        )
    );

### 6. Apa yang terjadi jika atribut model baru dibuat setelah initComponents() dipanggil?

Aplikasi akan mengalami error karena nilai model masih null ketika initComponents() dijalankan. Di dalam initComponents(), JTable langsung menggunakan model melalui setModel(model). Akibatnya, muncul error IllegalArgumentException dengan pesan "Cannot set a null TableModel".

Oleh karena itu, objek model harus dibuat sebelum initComponents() dipanggil agar JTable mendapatkan model yang valid.

## Video Demo

Video demonstrasi aplikasi Katalog Buku Perpustakaan dapat dilihat melalui tautan berikut:

[Video Demo Katalog Buku Perpustakaan](https://drive.google.com/file/d/1dRn9dMIsVrg8j1-qEJPbFfng7x1B82mM/view?usp=sharing)

## Deklarasi Penggunaan AI

Dalam pengerjaan praktikum dan mini proyek ini, saya menggunakan ChatGPT sebagai alat bantu untuk memahami materi, membantu mencari solusi ketika terjadi error dan membantu memperbaiki kalimat pada README.

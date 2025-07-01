@Unit
Feature: Unit CRUD

  Scenario: Verifikasi fungsi tombol 'Tambahkan' untuk menambah unit baru
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Klik tombol Tambahkan
    And Isi Nama Unit "1 Tambah Unit"
    And Centang checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3"
    And Pilih Aturan Cuti "Jangan dihapus sama edit YA!! Cuti punya kelompok 3"
    And Cari Overtime Reason "Lembur Kelompok 3"
    And Isi Maksimal hari pengajuan "3"
    And Pilih bukti lembur "Ya"
    And Klik tombol Tambah
    Then Unit baru berhasil ditambahkan

  Scenario: Verifikasi fungsi tombol 'batal' untuk batal menambahkan unit baru
    Given Klik tombol Tambahkan
    And Isi Nama Unit "1 Batal Tambah Unit" untuk batal
    And Centang checkbox Lokasi Absen Tetap untuk batal
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3" untuk batal
    And Pilih Aturan Cuti "Jangan dihapus sama edit YA!! Cuti punya kelompok 3" untuk batal
    And Klik tombol Batal
    Then Unit baru batal ditambahkan

  Scenario: Menambahkan unit baru dengan mengosongkan data 'nama unit'
    Given Klik tombol Tambahkan
    When Kosongkan Nama Unit ""
    And Centang checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3"
    And Pilih Aturan Cuti "Jangan dihapus sama edit YA!! Cuti punya kelompok 3"
    And Klik tombol Tambah
    Then Notifikasi error muncul menampilkan pesan "Nama unit tidak boleh kosong!."

  Scenario: Menambahkan unit baru dengan mengosongkan checkbox 'Lokasi Absen Tetap'
    Given Klik tombol Tambahkan
    And Isi Nama Unit "1 Tambah Unit checkbox kosong"
    And Kosongkan checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3"
    And Pilih Aturan Cuti "Jangan dihapus sama edit YA!! Cuti punya kelompok 3"
    And Klik tombol Tambah
    Then Notifikasi error muncul

  Scenario: Menambahkan unit baru dengan mengosongkan data 'Unit Kalender'
    Given Klik tombol Tambahkan
    When Isi Nama Unit "1 Tambah Unit Kalender kosong"
    And Centang checkbox Lokasi Absen Tetap
    And Kosongkan Unit Kalender
    And Pilih Aturan Cuti "Jangan dihapus sama edit YA!! Cuti punya kelompok 3"
    And Klik tombol Tambah
    Then Notifikasi error muncul

  Scenario: Menambahkan unit baru dengan mengosongkan data 'Aturan Cuti'
    Given Klik tombol Tambahkan
    And Isi Nama Unit "1 Tambah Unit Aturan Cuti kosong"
    And Centang checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3"
    And Kosongkan Aturan Cuti
    And Klik tombol Tambah
    Then Notifikasi Error muncul

  Scenario: Verifikasi fungsi tombol 'Edit' untuk mengedit unit
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Edit
    And Isi Nama Unit "1 Tambah 1"
    And Kosongkan checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus kelompok 3 punya"
    And Pilih Aturan Cuti "Aturan Cuti Desember"
    And Klik Simpan
    Then Data unit berhasil diedit  atau berubah

  Scenario: Verifikasi fungsi tombol 'Batal' untuk batal mengedit unit
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Edit
    And Isi Nama Unit "1 Tambah 1"
    And Kosongkan checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus kelompok 3 punya"
    And Pilih Aturan Cuti "Aturan Cuti Desember"
    And Klik Batal
    Then Data unit berhasil diedit  atau berubah

  Scenario: Verifikasi fungsi tombol 'Delete' untuk menghapus unit
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Delete
    And Klik Ya
    Then Data unit berhasil dihapus

  Scenario: Verifikasi fungsi tombol 'Batal Delete' untuk batal menghapus unit
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Delete
    And Klik Tidak
    Then Data unit batal dihapus

  Scenario: Mengosongkan input gambar saat mengatur "Virtual ID"
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Atur Virtual ID
    And Kosongkan file foto
    And Pilih Warna Footer "000FFF"
    And Klik tombol Atur
    Then Validasi jika gambar lebih kosong

  Scenario: Verifikasi fungsi tombol 'Atur Virtual ID' untuk mengatur virtual ID
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Atur Virtual ID
    And Upload file foto yang berukuran kurang dari 2 MB
    And Pilih Warna Footer "000FFF"
    And Klik tombol Atur
    Then Virtual ID berhasil diatur

  Scenario: Menginput gambar dengan ukuran lebih dari 2 MB saat mengatur 'Virtal ID'
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Atur Virtual ID
    And Upload file foto yang berukuran lebih dari 2 MB
    And Pilih Warna Footer "000FFF"
    And Klik tombol Atur
    Then Validasi jika gambar lebih dari 2MB

  Scenario: Verifikasi fungsi tombol batal pada 'Atur Virtual ID' untuk batal mengatur virtual ID
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Atur Virtual ID
    And Upload file foto yang berukuran kurang dari 2 MB
    And Pilih Warna Footer "000FFF"
    And Klik tombol Batal
    Then Virtual ID batal diatur

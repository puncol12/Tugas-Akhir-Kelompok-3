Feature: Unit 02 Tambah Unit

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
    And Isi Nama Unit "1 Tambah Unit Kalender kosong"
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


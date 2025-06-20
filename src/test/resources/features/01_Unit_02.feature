Feature: Unit 02 Tambah Unit

  Scenario: Verifikasi fungsi tombol 'Tambahkan' untuk menambah unit baru
    Given Login dengan user valid
    When Klik menu Management
    And Klik tombol Tambahkan
    And Isi Nama Unit "123qwe456"
    And Centang checkbox Lokasi Absen Tetap
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3"
    And Pilih Aturan Cuti "Cuti punya kelompok 3"
    And Cari Overtime Reason "Lembur Kelompok 3"
    And Isi Maksimal hari pengajuan "3"
    And Pilih bukti lembur "Ya"
    And Klik tombol Tambah
    Then Unit baru berhasil ditambahkan

  Scenario: Verifikasi fungsi tombol 'batal' untuk batal menambahkan unit baru
    Given Klik tombol Tambahkan
    And Isi Nama Unit "1" untuk batal
    And Centang checkbox Lokasi Absen Tetap untuk batal
    And Pilih Unit Kalender "jangan dihapus punya kelompok 3" untuk batal
    And Pilih Aturan Cuti "Cuti punya kelompok 3" untuk batal
    And Klik tombol Batal
    Then Unit baru batal ditambahkan

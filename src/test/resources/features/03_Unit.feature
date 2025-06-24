Feature: 03 Unit Shift

  Scenario: Verifikasi fungsi tombol 'Shift' untuk dan menambahkan shift
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Klik tombol titik 3 pada salah satu unit
    And Klik tombol Shift
    Then Masuk ke menu shift

  Scenario: Verifikasi Menambahkan Shift pada menu shift
    Given Klik tombol Tambahkan
    When Masukkan nama shift "yusuf"
    And Klik tombol Tambah
    Then Berhasil menambahkan shift

  Scenario: Verifikasi Batal Menambahkan Shift pada menu shift
    Given Klik tombol Tambahkan
    When Masukkan nama shift "yusuf"
    And Klik tombol Batal
    Then Batal menambahkan shift

  Scenario: Menambahkan shift baru dengan mengosongkan nama shift
    Given Klik tombol Tambahkan
    When Kosongkan nama shift ""
    And Klik tombol Tambah
    Then Notifikasi error muncul dan menampilkan pesan "Nama Shift tidak boleh kosong!."

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

  Scenario: Verifikasi tombol 'edit' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Edit
    And Masukkan nama shift "yusuf nur rizqi"
    And Klik Simpan
    Then Berhasil mengedit nama shift

  Scenario: Verifikasi tombol 'delete' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Delete
    And Klik Ya
    Then Shift berhasil dihapus

  Scenario: Verifikasi tombol 'batal delete' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Delete
    And Klik Tidak
    Then Shift batal dihapus

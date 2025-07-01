@Posisi
Feature: Posisi
  Sebagai Admin
  Admin ingin melakukan pengolaan data Posisi
  Sehingga data dapat ditampilkan, ditambahkan, diubah, dihapus dan dicari

  Scenario: Menampilkan Menu Posisi
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Posisi
    Then Daftar Posisi ditampilkan

  Scenario: Menambahkan posisi baru dengan nama dan department
    Given Klik tombol Tambahkan
    When Mengisi field Nama Posisi dengan "Staff Admin"
    And Mengisi field Department dengan "1 Tambah Unit Kalender kosong"
    And Klik tombol Simpan
    Then Data posisi baru berhasil ditambahkan

  Scenario: Melakukan simpan tanpa isi nama posisi dan mengisi department
    Given Klik tombol Tambahkan
    When Mengisi field Nama Posisi dengan ""
    And Mengisi field Department dengan "1 Tambah Unit Kalender kosong"
    And Klik tombol Simpan
    Then Tampil pesan error Nama Posisi wajib diisi pada menu tambah

  Scenario: Melakukan simpan posisi mengisi nama posisi tanpa mengisi department (opsional)
    Given Klik tombol Tambahkan
    When Mengisi field Nama Posisi dengan "Staff Admin"
    And Mengosongkan field Department
    And Klik tombol Simpan
    Then Data posisi baru berhasil ditambahkan

  Scenario: Melakukan simpan posisi tanpa isi nama dan department
    Given Klik tombol Tambahkan
    When Mengisi field Nama Posisi dengan ""
    And Mengosongkan field Department
    And Klik tombol Simpan
    Then Tampil pesan error Nama Posisi wajib diisi pada menu tambah

  Scenario: Mengedit nama posisi
    Given Klik tombol titik 3 pada salah satu data posisi
    When Klik tombol Edit Posisi
    And Mengubah field Nama Posisi menjadi "Supervisor"
    And Klik tombol Simpan Edit
    Then Data posisi berhasil diperbaharui

  Scenario: Mengedit nama posisi dengan nama kosong
    Given Klik tombol titik 3 pada salah satu data posisi
    When Klik tombol Edit Posisi
    And Mengubah field Nama Posisi menjadi ""
    And Klik tombol Simpan Edit
    Then Tampil pesan error Nama Posisi wajib diisi edit

  Scenario: Membatalkan menu edit posisi
    Given Klik tombol titik 3 pada salah satu data posisi
    When Klik tombol Edit Posisi
    And Klik tombol Batal Edit
    Then Data posisi tidak berubah

  Scenario: Menghapus Posisi
    Given Klik tombol titik 3 pada salah satu data posisi
    When Klik tombol Delete Posisi
    And Muncul konfirmasi hapus posisi atau tidak
    And Klik tombol Ya
    Then Data posisi berhasil dihapus

  Scenario: Tidak menghapus Posisi
    Given Klik tombol titik 3 pada salah satu data posisi
    When Klik tombol Delete Posisi
    And Muncul konfirmasi hapus posisi atau tidak
    And Klik tombol Tidak
    Then Data posisi tidak terhapus

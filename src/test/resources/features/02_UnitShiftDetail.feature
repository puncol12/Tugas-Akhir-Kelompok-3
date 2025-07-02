@Unit
Feature: Unit Shift Detail

  Scenario: Verifikasi fungsi tombol 'Shift' untuk dan menambahkan shift
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Klik tombol titik 3 pada salah satu unit
    And Klik tombol Shift
    Then Masuk ke menu shift

  Scenario Outline: Verifikasi Menambahkan Shift pada menu shift
    Given Klik tombol Tambahkan
    When Masukkan nama shift "<Nama>"
    And Klik tombol Tambah
    Then Berhasil menambahkan shift

    Examples:
      | Nama  |
      | yusuf |
      | nur   |
      | rizqi |

  Scenario: Verifikasi Batal Menambahkan Shift pada menu shift
    Given Klik tombol Tambahkan
    When Masukkan nama shift "putra"
    And Klik tombol Batal
    Then Batal menambahkan shift

  Scenario: Menambahkan shift baru dengan mengosongkan nama shift
    Given Klik tombol Tambahkan
    When Kosongkan nama shift ""
    And Klik tombol Tambah
    Then Notifikasi Error muncul dan menampilkan pesan "Nama Shift tidak boleh kosong!."

  Scenario: Verifikasi tombol 'edit' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Edit
    And Masukkan nama shift "yusuf nur rizqi"
    And Klik Simpan
    Then Berhasil mengedit nama shift

  Scenario: Mengedit shift dengan mengosongkan nama shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Edit
    And Masukkan nama shift ""
    And Klik Simpan
    Then Notifikasi Error muncul dan menampilkan pesan 'Nama Shift tidak boleh kosong!.'

  Scenario: Verifikasi tombol 'batal edit' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Edit
    And Masukkan nama shift "raharjo"
    And Klik Batal
    Then Nama shift tidak berubah

  Scenario: Verifikasi tombol 'delete' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Delete
    And Klik Ya
    Then Shift berhasil dihapus

  Scenario: Verifikasi tombol 'batal delete' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Delete1
    And Klik Tidak
    Then Shift batal dihapus

  Scenario: Verifikasi tombol 'view' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol View
    Then Menampilkan informasi shift

  Scenario: Verifikasi Menambahkan detail Shift pada menu view
    Given Klik tombol Tambahkan
    When Pilih nama shift "punya yusuf"
    And Klik tombol Tambah view
    And Klik tombol Tambahkan
    And Pilih nama shift "punya kelompok 3"
    And Klik tombol Tambah view
    And Klik tombol Tambahkan
    And Pilih nama shift "Hatata"
    And Klik tombol Tambah view
    Then Berhasil menambahkan detail shift

  Scenario: Verifikasi tombol 'edit' pada salah satu view
    Given Klik tombol titik 3 pada salah satu shift view
    When Klik tombol Edit
    And Pilih nama shift "True Money BSNI"
    And Klik Simpan
    Then Berhasil mengedit nama shift

  Scenario: Verifikasi tombol 'batal edit' pada salah satu view
    Given Klik tombol titik 3 pada salah satu shift view
    When Klik tombol Edit
    And Pilih nama shift "Zurich"
    And Klik Batal
    Then Nama shift tidak berubah

  Scenario: Verifikasi tombol 'delete' pada salah satu view
    Given Klik tombol titik 3 pada salah satu shift view
    When Klik tombol Delete
    And Klik Hapus Edit View
    Then Detail Shift berhasil dihapus

  Scenario: Verifikasi tombol 'batal delete' pada salah satu view
    Given Klik tombol titik 3 pada salah satu shift view
    When Klik tombol Delete
    And Klik Batal Edit View
    Then Shift batal dihapus view

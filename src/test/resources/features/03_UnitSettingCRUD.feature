@UnitSetting
Feature: Unit Setting Management CRUD

  Scenario: Test Menambahkan Departemens
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit Setting
    And Klik tombol Tambahkan
    And Klik Tombol Drop Down
    And User memilih "test unit 33"
    And Klik tombol Tambah
    Then Muncul notifikasi "Berhasil Menambahkan Departemens"

  Scenario: Test Menambahkan Departemens yang sama
    Given Klik tombol Tambahkan
    When Klik Tombol Drop Down
    And User memilih "test unit 33"
    And Klik tombol Tambah
    Then Muncul Notifikasi "Gagal Menambahkan Departemens"

  Scenario: Test Membatalkan Proses Penambahan Departemens
    Given Klik tombol Tambahkan
    When Klik Tombol Drop Down
    And User memilih "test unit 33"
    And Klik tombol Batal
    Then Data tetap seperti awal "test unit 33"

  Scenario: Test Membatalkan Proses Penghapusan Departemens
    Given Klik ikon Hapus Data pada baris mana pun
    When Muncul pop-up Apakah anda ingin menghapus departments yang ingin di hapus
    And Klik Tombol Tidak
    Then Data tetap ada di dalam tabel

  Scenario: Test Menghapus Departemens yang ada dengan sukses
    Given Klik ikon Hapus Data pada baris mana pun
    When Muncul pop-up Apakah anda ingin menghapus departments yang ingin di hapus
    And Klik Tombol Ya
    Then muncul notifikasi "Berhasil Delete Departemens"

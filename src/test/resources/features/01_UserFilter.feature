@User
Feature: User Search, Filter And Export

  Scenario: Pencarian Nama den Reset
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Klik Export
    And Pilih Pencarian Nama
    And Masukan Pencarian "yusuf"
    And Klik tombol Search
    And Klik Export
    And Klik tombol Reset
    Then Menampilkan data yang dicari berdasarkan Status yang dipilih

  Scenario: Pencarian NIK
    And Pilih Pencarian NIK
    And Masukan Pencarian "D7240017"
    And Klik tombol Search
    And Klik Export
    And Klik tombol Reset
    Then Menampilkan data yang dicari berdasarkan Status yang dipilih

  Scenario: Terapkan Filter by Unit
    Given Klik Filter
    When Pilih unit "1 Tambah Unit Aturan Cuti kosong"
    And Klik Terapkan
    Then Menampilkan data yang dicari

  Scenario: Terapkan Filter by Job Level
    Given Klik Filter
    When Pilih Job Level "TC-A-001"
    And Klik Terapkan
    Then Menampilkan data yang dicari

  Scenario: Terapkan Filter by Tipe Karyawan
    Given Klik Filter
    When Pilih Tipe Karyawan "Magang"
    And Klik Terapkan
    Then Menampilkan data yang dicari

  Scenario: Terapkan Filter by Posisi Kerja
    Given Klik Filter
    When Pilih Posisi Kerja "1234567890"
    And Klik Terapkan
    Then Menampilkan data yang dicari

  Scenario: Terapkan Filter by Lokasi Kerja
    Given Klik Filter
    When Pilih Lokasi Kerja "123456"
    And Klik Terapkan
    Then Menampilkan data yang dicari

  Scenario: Terapkan Filter by Status
    Given Klik Filter
    When Pilih Status "Tidak Aktif"
    And Klik Terapkan
    Then Menampilkan data yang dicari

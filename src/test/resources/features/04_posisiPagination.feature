@MenuManagement
Feature: Posisi searching, reset searching, next page, previous page, last page, first pag

  Scenario: Melakukan search dengan menginput 'Admin'
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Posisi
    And Masukkan nama posisi pada kotak Search dengan input "Admin"
    And Klik tombol Search di halaman Posisi
    Then Data posisi yang sesuai dengan pencarian ditampilkan untuk "Admin"

  Scenario: Melakukan 'Reset' untuk menghapus input pada filter
    Given Klik tombol Reset
    Then Input pada kotak Search dihapus dan data unit kembali ke kondisi awal

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to next page
    Given Klik go to next page di bagian bawah halaman tambah posisi
    Then Menampilkan data posisi halaman selanjutnya

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to previous page
    Given Klik go to previous page di bagian bawah halaman tambah posisi
    Then Menampilkan data posisi halaman sebelumnya

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to last page
    Given Klik go to last page di bagian bawah halaman tambah posisi
    Then Menampilkan data posisi halaman terakhir

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to first page
    Given Klik go to first page di bagian bawah halaman tambah posisi
    Then Menampilkan data posisi halaman pertama

  Scenario Outline: Tampilan data per halaman menggunakan Show Page
    Given Pilih jumlah data <jumlah> yang ingin ditampilkan per halaman di field Show Page Posisi
    Then Data posisi ditampilkan sesuai dengan jumlah <jumlah> yang dipilih di Show Page

    Examples:
      | jumlah |
      |      5 |

Feature: Unit 01 searching, reset searching, next page, previous page, last page, first pag

  Scenario: Melakukan search dengan menginput 'Nama Unit'
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Masukkan nama unit pada kotak Search dengan input "1234"
    And Klik tombol Search
    Then Data unit yang sesuai dengan pencarian ditampilkan untuk "1234"

  Scenario: Melakukan 'Reset' untuk menghapus input pada filter
    Given Klik tombol Reset
    Then Input pada kotak Search dihapus dan data unit kembali ke kondisi awal

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to next page
    Given Klik go to next page di bagian bawah halaman tambah unit
    Then Menampilkan data unit halaman selanjutnya

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to previous page
    Given Klik go to previous page di bagian bawah halaman tambah unit
    Then Menampilkan data unit halaman sebelumnya

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to last page
    Given Klik go to last page di bagian bawah halaman tambah unit
    Then Menampilkan data unit halaman terakhir

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to first page
    Given Klik go to first page di bagian bawah halaman tambah unit
    Then Menampilkan data unit halaman pertama

  Scenario Outline: Tampilan data per halaman menggunakan Show Page
    Given Pilih jumlah data <jumlah> yang ingin ditampilkan per halaman di field Show Page
    Then Data unit ditampilkan sesuai dengan jumlah <jumlah> yang dipilih di Show Page

    Examples:
      | jumlah |
      |      5 |

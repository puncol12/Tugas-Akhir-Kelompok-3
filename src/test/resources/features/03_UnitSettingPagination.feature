Feature: Pagination untuk Go to next page Go to previous, Go to last page Go to first page, dan Show Page

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to next page dan previous page
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit Setting
    And Klik go to next page di bagian bawah halaman unit setting
    And Klik go to previous page di bagian bawah halaman unit setting
    Then Menampilkan data unit halaman sebelumnya

  Scenario: Mengubah tampilan data perhalaman menggunakan Go to last page dan first page
    Given Klik go to last page di bagian bawah halaman unit setting
    When Klik go to first page di bagian bawah halaman unit setting
    Then Menampilkan data unit halaman pertama

  Scenario Outline: Tampilan data per halaman menggunakan Show Page
    Given Pilih jumlah data <jumlah> yang ingin ditampilkan per halaman di field Show Page
    Then Data unit ditampilkan sesuai dengan jumlah <jumlah> yang dipilih di Show Page

    Examples:
      | jumlah |
      |      5 |
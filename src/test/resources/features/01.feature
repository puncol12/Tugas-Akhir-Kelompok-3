Feature: Unit

  Scenario: Melakukan search dengan menginput 'Nama Unit'
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Masukkan nama unit pada kotak Search dengan input "1234"
    And Klik tombol Search
    Then Data unit yang sesuai dengan pencarian ditampilkan untuk "1234"

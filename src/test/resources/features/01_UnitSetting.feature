Feature: Unit Setting

  Scenario: Menambahkan Departements Unit Setting
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit Setting
    And Klik Tombol Tambahkan
    And Klik Tombol Drop Down
    And User memilih test unit 33
    And Klik Tombol Tambah
    And Muncul notifikasi berhasil menambahkan departemens
    Then Muncul nama departemens yang telah
Feature: Unit Setting

  Scenario: Melakukan search dengan menginput 'Nama Unit'
    Given Login dengan User valid
    When Klik menu management
    And Klik submenu Unit Setting
    And Klik Tombol Tambahkan
    And Klik Tombol Drop Down
    And User memilih test unit 33
    And Klik Tombol Tambah
  
Feature: 04 Unit Shift delete

  Scenario: Verifikasi tombol 'delete' pada salah satu shift
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit
    And Klik tombol titik 3 pada salah satu unit
    And Klik tombol Shift untuk delete
    And Klik tombol titik 3 pada salah satu shift
    And Klik tombol Delete
    And Klik Ya
    Then Shift berhasil dihapus

  Scenario: Verifikasi tombol 'batal delete' pada salah satu shift
    Given Klik tombol titik 3 pada salah satu shift
    When Klik tombol Delete
    And Klik Tidak
    Then Shift batal dihapus

Feature: Toggle Selfie Department

  Scenario: Menonaktifkan Fitur Selfie untuk Departemens
    Given Login dengan user valid
    And Klik menu Management
    And Klik submenu Unit Setting
    And Klik toggle button pada kolum selfie On "6 Estates"
    And Muncul pop-up Sukses dan klik tombol OK untuk OFF
    Then Validasi tanggal update untuk defect report OFF "6 Estatesr"

  Scenario: Mengaktifkan Fitur Selfie untuk Departemens
    Given Klik toggle button pada kolum selfie Off "Credit Card"
    And Muncul pop-up Sukses dan klik tombol OK untuk ON
    Then Validasi tanggal update untuk defect report ON "Credit Card"
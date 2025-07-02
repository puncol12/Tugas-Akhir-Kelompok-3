@UnitSetting
Feature: Toggle Selfie Department

  Scenario: Menonaktifkan Fitur Selfie untuk Departemens
    Given Login dengan user valid
    And Klik menu Management
    And Klik submenu Unit Setting
    And Klik toggle button pada kolum selfie On "qaz"
    And Muncul pop-up Sukses dan klik tombol OK untuk OFF
    Then Validasi tanggal update untuk defect report OFF "qaz"

  Scenario: Mengaktifkan Fitur Selfie untuk Departemens
    Given Klik toggle button pada kolum selfie Off "123456789"
    And Muncul pop-up Sukses dan klik tombol OK untuk ON
    Then Validasi tanggal update untuk defect report ON "123456789"

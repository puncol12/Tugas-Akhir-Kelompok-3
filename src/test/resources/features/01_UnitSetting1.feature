Feature: Unit Setting Management

  Scenario: Test Menambahkan Departemens 
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Unit Setting
    And Klik tombol Tambahkan
    And Klik Tombol Drop Down
    And User memilih "test unit 33"
    And Klik Tombol Tambah
    Then Muncul notifikasi "Berhasil Menambahkan Departemens"
    
    Scenario: Test Menambahkan Departemens yang sama
    Given Klik tombol Tambahkan
    When Klik Tombol Drop Down
    And User memilih "test unit 33"
    And Klik Tombol Tambah
    Then Muncul notifikasi "Gagal Menambahkan Departemens"

#   Scenario Outline: Test Membatalkan Proses Penambahan Departemens
#     When Klik submenu Unit Setting
#     And Klik tombol Tambahkan
#     And Klik Tombol Drop Down
#     And User memilih "<department_name>"
#     And Klik Tombol Batal
#     Then Data tetap seperti awal

#     Examples:
#       | department_name  |
#       | test unit 33     |

#   Scenario Outline: Test Membatalkan Proses Penghapusan Departemens
#     When Klik submenu Unit Setting
#     And Klik Tombol Delete untuk "<department_name>"
#     And Klik Tombol Tidak
#     Then Data tetap seperti awal

#     Examples:
#       | department_name  |
#       | test unit 33     |

#   Scenario Outline: Test Menghapus Departemens yang ada dengan sukses
#     When Klik submenu Unit Setting
#     And Klik Tombol Delete untuk "<department_name>"
#     And Klik Tombol Ya
#     Then Muncul notifikasi "<expected_notification>"

#     Examples:
#       | department_name  | expected_notification        |
#       | test unit 33     | Berhasil Delete Departemens  |
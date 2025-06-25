# Feature: Unit Setting Management

#   Background:
#     Given Login dengan user valid
#     When Klik menu Management

#   Scenario Outline: Test Menambahkan Departemens dan Menambahkan Departemens yang sama
#     When Klik submenu Unit Setting
#     And Klik Tombol Tambahkan
#     And Klik Tombol Drop Down
#     And User memilih "<department_name>"
#     And Klik Tombol Tambah
#     Then Muncul notifikasi "<expected_notification>"

#     Examples:
#       | department_name  | expected_notification              |
#       | test unit 33     | Berhasil Menambahkan Departemens   |
#       | test unit 33     | Gagal Menambahkan Departemens      |

#   Scenario Outline: Test Membatalkan Proses Penambahan Departemens
#     When Klik submenu Unit Setting
#     And Klik Tombol Tambahkan
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
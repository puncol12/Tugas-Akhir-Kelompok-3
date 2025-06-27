@Posisi
Feature: Posisi

  Sebagai Admin
  Admin ingin melakukan pengolaan data Posisi
  Sehingga data dapat ditampilkan, ditambahkan, diubah, dihapus dan dicari


    #Positif Case
  Scenario: Menampilkan Menu Posisi
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu Posisi
    Then Daftar Posisi ditampilkan

    #Menu tambah - done
  Scenario: Menambahkan posisi baru dengan nama dan department
    Given Klik tombol Tambahkan
    #When Form tambah posisi ditampilkan
    When Mengisi field Nama Posisi dengan "Staff Admin"
    And Mengisi field Department dengan "Juara Coding"
    And Klik tombol Simpan
    Then Data posisi baru berhasil ditambahkan

  # Negatif Case - done
  Scenario: Melakukan simpan tanpa isi nama posisi dan mengisi department
    Given Klik tombol Tambahkan
    When Mengosongkan field Nama Posisi
    And Mengisi Field Department dengan "Juara Coding"
    And Klik tombol Simpan
    Then Tampil pesan error Nama Posisi wajib diisi pada menu tambah

# done
  Scenario: Melakukan simpan posisi mengisi nama posisi tanpa mengisi department (opsional)
    Given Klik tombol Tambahkan
    #Then Form tambah posisi ditampilkan
    When Mengisi field Nama Posisi dengan "Staff Admin"
    And Mengosongkan field Department
    And Klik tombol Simpan
    Then Data posisi baru berhasil ditambahkan
#done
  Scenario: Melakukan simpan posisi tanpa isi nama dan department
     Given Klik tombol Tambahkan
    #Then Form tambah posisi ditampilkan
    When Mengosongkan field Nama Posisi
    And Mengosongkan field Department
    And Klik tombol Simpan
    Then Tampil pesan error Nama Posisi wajib diisi pada menu tambah

    #Menu edit
#   #Positif case
#  Scenario: Mengedit nama posisi
#    Given Klik tombol titik 3 pada salah satu data posisi
#    When Klik tombol Edit
#    And Mengubah field Nama Posisi menjadi "Supervisor"
#    And Klik tombol Simpan Edit
#    Then Data posisi berhasil diperbaharui
##
## Negatif case
#  Scenario: Mengedit nama posisi dengan nama kosong
#    Given Klik tombol titik 3 pada salah satu data posisi
#    When Klik tombol Edit
#    And Mengosongkan field Nama Posisi pada menu edit
#    And Klik tombol Simpan Edit
#    Then Tampil pesan error "Nama Posisi wajib diisi" edit
#
#  Scenario: Membatalkan menu edit posisi
  #  Given Klik tombol titik 3 pada salah satu data posisi
#    When Klik tombol Edit
#    And Klik tombol Batal Edit
#    Then Data posisi tidak berubah
#
#
#    #menu delete
#  Scenario: Menghapus Posisi
#    Given Klik tombol titik 3 pada salah satu data posisi
#    When Klik tombol Delete
#    And Muncul konfirmasi hapus posisi atau tidak
#    And Klik tombol Ya
#    Then Data posisi berhasil dihapus
#
#  Scenario: Tidak menghapus Posisi
#    Given Klik tombol titik 3 pada salah satu data posisi
#    When Klik tombol Delete
#    And Muncul konfirmasi hapus posisi atau tidak
#    And Klik tombol Tidak
#    Then Data posisi tidak terhapus
#
#    #menu search
#  Scenario: Mencari Posisi dengan kata kunci
#    When Masukkan kata kunci "Admin" pada kotak Search
#    And Klik tombol Search pada menu Posisi
#    Then Data posisi yang sesuai dengan kata kunci "Admin" ditampilkan
#
#    #Menu reset
#  Scenario: Mereset kata kunci dalam pencarian
#    Given Klik tombol Reset pada kotak Search di menu Posisi
#    Then Data posisi ditampilkan seluruhnya
#
#    #pagination
#  Scenario: Mengubah tampilan data perhalaman menggunakan Go to next page
#    Given Klik go to next page di bagian bawah halaman tambah posisi
#    Then Menampilkan data posisi halaman selanjutnya
#
#  Scenario: Mengubah tampilan data perhalaman menggunakan Go to previous page
#    Given Klik go to previous page di bagian bawah halaman tambah posisi
#    Then Menampilkan data posisi halaman sebelumnya
#
#  Scenario Outline: Tampilan data per halaman menggunakan Show Page
#    Given Pilih jumlah data <jumlah> yang ingin ditampilkan per halaman di field Show Page di posisi
#    Then Data posisi ditampilkan sesuai dengan jumlah <jumlah> yang dipilih di Show Page Posisi
#
#    Examples:
#      | jumlah |
#      | 5      |
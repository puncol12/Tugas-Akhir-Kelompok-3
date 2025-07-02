@User
Feature: User CRUD

  Scenario: Edit User dengan Mengosongkan Salah satu Data
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Pilih Pencarian Nama
    And Masukan Pencarian "jemes"
    And Klik tombol Search
    And Klik tombol titik 3 pada salah satu unit
    And Klik tombol Edit
    And Isi NIK ""
    And Klik Submit Edit
    Then Tampil pesan error wajib diisi

  Scenario: Edit User dengan Upload Foto Karyawan lebih dari 2 MB
    Given Klik icon Hapus
    When Upload file foto yang berukuran lebih dari 2 MB
    And Klik Submit
    Then Foto tidak Terupload

  Scenario: Edit User dengan Upload Foto Karyawan kurang dari 2 MB
    Given Upload file foto yang berukuran kurang dari 2 MB
    When Isi NIK "D7240017"
    And Isi Nama Karyawan "1 Pete"
    And Isi Email "jamesjampes@gmail.com"
    And Pilih Devisi "123456"
    And Pilih Unit "BCA Biro Quality Assurance, Support & System Development"
    And Pilih Tipe Kontrak "Magang"
    And Pilih Edit Posisi Kerja "Quality Assurance"
    And Pilih Jabatan "Sigma Boy"
    And Pilih Edit Lokasi Kerja "DIKA Balikpapan"
    And Pilih Tipe Shift "Shift"
    And Pilih Jadwal Kerja "SQA-Testing-Auto"
    And Pilih Selfie "No Selfie"
    And Isi Jumlah Cuti 10
    And Klik Tombol Status Active yang tidak aktif
    And Klik Tombol User Project yang tidak aktif
    And Klik Submit
    Then Data Berhasil diubah dan aktifkan tracking dan projek akan menyala

  Scenario: Lihat Sisa Cuti
    Given Klik tombol titik 3 pada salah satu unit
    When Klik tombol Lihat Sisa Cuti
    And Klik tombol Tutup
    Then Menampilkan Sisa Cuti

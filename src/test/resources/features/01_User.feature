Feature: User 01

  Scenario: Edit User dengan Upload Foto Karyawan kurang dari 2 MB
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Pilih Pencarian Nama
    And Masukan Pencarian "yusuf"
    And Klik tombol Search
    And Klik tombol titik 3 pada salah satu unit
    And Klik tombol Edit
    And Klik icon Hapus
    And Upload file foto yang berukuran kurang dari 2 MB
    And Isi NIK "D7240017"
    And Isi Nama Karyawan "Jemes Pete"
    And Isi Email "jamesjampes@mail.com"
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
    # And 25. Klik Aktifkan Tracking
    # And 26. Aktifkan Project
    # And 27. Klik Submit"

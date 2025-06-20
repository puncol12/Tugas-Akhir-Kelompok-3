Feature: Tambah Unit

  Scenario: Verifikasi fungsi tombol 'Tambahkan' untuk menambah unit baru
    Given Klik tombol 'Tambahkan'
    When Isi 'Nama Unit'
    And Centang checkbox 'Lokasi Absen Tetap'
    And Pilih Unit Kalender'
    And Pilih 'Aturan Cuti'
    And Klik tombol 'Tambah'
    Then Unit baru berhasil ditambahkan

@User
Feature: Menghidupkan dan Mematikan User Project

  Scenario: Menyalakan User Project
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Masukkan data untuk pencarian "234234"
    And Klik Tombol User Project yang tidak aktif
    Then Muncul Notifikasi project diaktifkan

  Scenario: Mematikan User Project
    Given Cari User dengan data "234234"
    When Klik Tombol User Project yang aktif
    Then Muncul Notifikasi project dinonaktifkan
    
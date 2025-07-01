@User
Feature: Menghidupkan dan Mematikan Active

  Scenario: Menyalakan Active
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Masukkan data untuk pencarian "234234"
    And Klik Tombol Status Active yang tidak aktif
    Then Muncul Notifikasi user diaktifkan

  Scenario: Mematikan Active
    Given Cari User dengan data "234234"
    When Klik Tombol Acvite yang aktif
    Then Muncul Notifikasi user dinonaktifkan
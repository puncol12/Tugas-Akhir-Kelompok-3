@User
Feature: Menghidupkan dan Mematikan User Project

  Scenario: Menyalakan User Project
    Given Login dengan user valid
    When Klik menu Management
    And Klik submenu User
    And Masukkan data untuk pencarian "1 jemes apete"
    And Klik Tombol User Project yang tidak aktif
    Then Muncul Notifikasi project diaktifkan

  Scenario: Mematikan User Project
    Given Klik Tombol User Project yang aktif
    Then Muncul Notifikasi project dinonaktifkan

  Scenario:Menyalakan Active
    Given Klik Tombol Status Active yang tidak aktif
    Then Muncul Notifikasi user diaktifkan

  Scenario: Mematikan Active
    Given Klik Tombol Acvite yang aktif
    Then Muncul Notifikasi user dinonaktifkan
    
package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.And;

public class UserEditSteps {

    WebDriver driver;
    UserPage userPage;

    public UserEditSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userPage = new UserPage(driver);
    }

    @And("Klik icon Hapus")
    public void delete_Image() throws InterruptedException {
        userPage.hapusGambar();
        Thread.sleep(2000);
    }

    @And("Isi NIK {string}")
    public void input_NIK(String nik) throws InterruptedException {
        userPage.inputNik(nik);
        Thread.sleep(500);
    }

    @And("Isi Nama Karyawan {string}")
    public void input_Nama(String name) throws InterruptedException {
        userPage.inputNama(name);
        Thread.sleep(500);
    }

    @And("Isi Email {string}")
    public void input_Email(String email) throws InterruptedException {
        userPage.inputEmail(email);
        Thread.sleep(500);
    }

    @And("Pilih Devisi {string}")
    public void input_Divisi(String divisi) throws InterruptedException {
        userPage.inputDivisi(divisi);
        Thread.sleep(500);
    }

    @And("Pilih Unit {string}")
    public void input_Unit(String unit) throws InterruptedException {
        userPage.inputUnit(unit);
        Thread.sleep(500);
    }

    @And("Pilih Tipe Kontrak {string}")
    public void input_Kontrak(String tipeKontrak) throws InterruptedException {
        userPage.inputKontrak(tipeKontrak);
        Thread.sleep(500);
    }

    @And("Pilih Edit Posisi Kerja {string}")
    public void input_Posisi(String posisi) throws InterruptedException {
        userPage.inputPosisi(posisi);
        Thread.sleep(500);
    }

    @And("Pilih Jabatan {string}")
    public void input_Jabatan(String jabtan) throws InterruptedException {
        userPage.inputJabatan(jabtan);
        Thread.sleep(500);
    }

    @And("Pilih Edit Lokasi Kerja {string}")
    public void input_Edit_Lokasi_Kerja(String lokasi) throws InterruptedException {
        userPage.inputLokasiKerja(lokasi);
        Thread.sleep(500);
    }

    @And("Pilih Tipe Shift {string}")
    public void input_Tipe_Shift(String shift) throws InterruptedException {
        userPage.inputShift(shift);
        Thread.sleep(500);
    }

    @And("Pilih Jadwal Kerja {string}")
    public void input_Jadwal_Kerja(String jadwal) throws InterruptedException {
        userPage.inputJadwal(jadwal);
        Thread.sleep(500);
    }

    @And("Pilih Selfie {string}")
    public void input_Selfie(String selfie) throws InterruptedException {
        userPage.inputSelfie(selfie);
        Thread.sleep(500);
    }

    @And("Isi Jumlah Cuti {int}")
    public void input_Jumlah_Cuti(int cuti) throws InterruptedException {
        userPage.inputJumlahCuti(cuti);
        Thread.sleep(500);
    }

}

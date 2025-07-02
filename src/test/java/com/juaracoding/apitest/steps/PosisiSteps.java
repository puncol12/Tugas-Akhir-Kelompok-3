package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PosisiSteps {

    WebDriver driver;
    PagePosisi pagePosisi;
    UnitPage unitPage;

    public PosisiSteps() {
        driver = DriverSingleton.driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        pagePosisi = new PagePosisi(driver);
        unitPage = new UnitPage(driver);
    }

    @When("Mengisi field Nama Posisi dengan {string}")
    public void input_field_posisi(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(1000);
    }

    @And("Mengisi field Department dengan {string}")
    public void input_field_department(String dept) throws InterruptedException {
        pagePosisi.inputDepartment(dept);
        Thread.sleep(1000);
    }

    @And("Klik tombol Simpan")
    public void klik_simpan_tambah() throws InterruptedException {
        unitPage.clickButtonTambah();
        Thread.sleep(1000);
    }

    @And("Mengosongkan field Department")
    public void mengosongkan_department() throws InterruptedException {
        Thread.sleep(1000);
    }

    @And("Klik tombol Edit Posisi")
    public void klik_tombol_edit() throws InterruptedException {
        pagePosisi.klikEditPosisi();
        Thread.sleep(1000);
    }

    @And("Mengubah field Nama Posisi menjadi {string}")
    public void edit_field_posisi(String namaBaru) {
        unitPage.inputNama(namaBaru);
    }

    @And("Klik tombol Simpan Edit")
    public void klik_tombol_simpan_edit() throws InterruptedException {
        pagePosisi.klikSimpan();
        Thread.sleep(1000);
    }

    @And("Klik tombol Batal Edit")
    public void klik_tombol_batal_edit() throws InterruptedException {
        pagePosisi.klikBatal();
        Thread.sleep(1000);
    }

    @And("Klik tombol Delete Posisi")
    public void Klik_Tombol_Delete() throws InterruptedException {
        pagePosisi.klikTombolDelete();
        Thread.sleep(1000);
    }

    @And("Muncul konfirmasi hapus posisi atau tidak")
    public void konfirmasi_Hapus_posisi() throws InterruptedException {
        pagePosisi.halamanKonfirmasiHapus();
        Thread.sleep(1000);
    }

    @And("Klik tombol Ya")
    public void klik_Tombol_Ya() throws InterruptedException {
        pagePosisi.konfirmasiHapusYa();
        Thread.sleep(1000);
    }

    @And("Klik tombol Tidak")
    public void klik_Tombol_Tidak() throws InterruptedException {
        pagePosisi.konfirmasiHapusTidak();
        Thread.sleep(1000);
    }

    @Then("Data posisi berhasil dihapus")
    public void data_Posisi_Berhasil_Dihapus() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi tidak berhasil dihapus");
    }

    @Then("Data posisi tidak terhapus")
    public void data_Posisi_Tidak_Dihapus() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi berhasil dihapus");
    }

    @Then("Data posisi berhasil diperbaharui")
    public void data_posisi_berhasil_diperbaharui() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi tidak berhasil diperbaharui");
    }

    @Then("Data posisi tidak berubah")
    public void data_posisi_tidak_berubah() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi berhasil diperbaharui");
    }

    @Then("Tampil pesan error Nama Posisi wajib diisi edit")
    public void tampil_pesan_error_menu_edit() throws InterruptedException {
        Thread.sleep(1000);
        String actualMsg = pagePosisi.getErrorMessageTambah();
        Assert.assertEquals(actualMsg, "Please fill out this field.");
        unitPage.clickButtonBatalTambah();
        driver.navigate().refresh();
    }

    @Then("Data posisi baru berhasil ditambahkan")
    public void data_posisi_baru_berhasil_ditambahkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Posisi tidak muncul");
    }

    @Then("Tampil pesan error Nama Posisi wajib diisi pada menu tambah")
    public void tampil_pesan_error_menu_tambah() throws InterruptedException {
        Thread.sleep(1000);
        String actualMsg = pagePosisi.getErrorMessageTambah();
        Assert.assertEquals(actualMsg, "Please fill out this field.");
        unitPage.clickButtonBatalTambah();
        driver.navigate().refresh();
    }

    @Then("Daftar Posisi ditampilkan")
    public void tampilanDataPosisi() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Posisi tidak muncul");
    }
}

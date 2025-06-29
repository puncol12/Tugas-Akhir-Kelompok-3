package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class TambahPosisiStep {
    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    PagePosisi pagePosisi;
    UnitPage unitPage;

    @When("Mengisi field Nama Posisi dengan {string}")
    public void input_field_posisi(String nama) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        pagePosisi = new PagePosisi(driver);
        unitPage = new UnitPage(driver);

        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }

    @And("Mengisi field Department dengan {string}")
    public void input_field_department(String dept) throws InterruptedException {
        pagePosisi.inputDepartment(dept);
        Thread.sleep(1000);
    }

    @And("Klik tombol Simpan")
    public void klik_simpan_tambah() throws InterruptedException {
        unitPageAddUnit.clickButtonTambah();
        Thread.sleep(1000);
    }

    @And("Mengosongkan field Department")
    public void mengosongkan_department() throws InterruptedException {
        Thread.sleep(1000);

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
        unitPageAddUnit.clickButtonBatalTambah();
        driver.navigate().refresh();
    }

}
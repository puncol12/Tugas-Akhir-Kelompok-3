package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonButtonAddSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    UnitSettingPage unitSettingPage;

    public CommonButtonAddSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitSettingPage = new UnitSettingPage(driver);
    }

    @When("Klik tombol Tambahkan")
    public void clickButtonTambahkan() throws InterruptedException {
        unitPageAddUnit.clickButtonTambahkan();
        Thread.sleep(500);
    }

    @When("Isi Nama Unit {string}")
    public void inputNameUnit(String nama) throws InterruptedException {
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Centang checkbox Lokasi Absen Tetap")
    public void checkTheCheckbok() throws InterruptedException {
        unitPageAddUnit.centangLokasiAbsen();
        Thread.sleep(500);
    }


    @And("Pilih Unit Kalender {string}")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPageAddUnit.pilihUnitKalender(Kalender);
        Thread.sleep(500);
    }

    @And("Pilih Aturan Cuti {string}")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPageAddUnit.pilihAturanCuti(Aturan);
        Thread.sleep(500);
    }

    @And("Klik tombol Tambah")
    public void clickButtonTambah() throws InterruptedException {
        unitPageAddUnit.clickButtonTambah();
        Thread.sleep(500);
    }

    @And("Klik tombol Batal")
    public void clickButtonBatal() throws InterruptedException {
        unitPageAddUnit.clickButtonBatalTambah();
        Thread.sleep(500);
    }

    @And("Klik Tombol Drop Down")
    public void userKlikTombolDropDown() throws InterruptedException {
        unitSettingPage.klikTombolDropDown();
        Thread.sleep(500);
    }

    @Then("Unit baru berhasil ditambahkan")
    public void unitNewSuccesAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }

    @Then("Notifikasi error muncul")
    public void unitNewFailAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertFalse(isExsist,
                "Unit baru justru berhasil ditambahkan, padahal seharusnya gagal.");
    }
}

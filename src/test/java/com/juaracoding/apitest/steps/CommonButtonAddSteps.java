package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonButtonAddSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Klik tombol Tambahkan")
    public void clickButtonTambahkan() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnit.clickButtonTambahkan();
    }

    @When("Isi Nama Unit {string}")
    public void inputNameUnit(String nama) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }

    @And("Centang checkbox Lokasi Absen Tetap")
    public void checkTheCheckbok() throws InterruptedException {
        unitPageAddUnit.centangLokasiAbsen();
        Thread.sleep(1000);
    }


    @And("Pilih Unit Kalender {string}")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPageAddUnit.pilihUnitKalender(Kalender);
        Thread.sleep(1000);
    }

    @And("Pilih Aturan Cuti {string}")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPageAddUnit.pilihAturanCuti(Aturan);
        Thread.sleep(1000);
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

    @Then("Unit baru berhasil ditambahkan")
    public void unitNewSuccesAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }
}

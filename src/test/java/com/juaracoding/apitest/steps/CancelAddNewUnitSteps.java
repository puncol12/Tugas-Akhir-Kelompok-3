package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancelAddNewUnitSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Isi Nama Unit {string} untuk batal")
    public void inputNameUnit(String nama) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }

    @When("Centang checkbox Lokasi Absen Tetap untuk batal")
    public void checkTheCheckbok() throws InterruptedException {
        unitPageAddUnit.centangLokasiAbsen();
        Thread.sleep(1000);
    }

    @And("Pilih Unit Kalender {string} untuk batal")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPageAddUnit.pilihUnitKalender(Kalender);
        Thread.sleep(1000);
    }

    @And("Pilih Aturan Cuti {string} untuk batal")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPageAddUnit.pilihAturanCuti(Aturan);
        Thread.sleep(1000);
    }

    @Then("Unit baru batal ditambahkan")
    public void unitNewCancelAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Form tidak ditutup, pembatalan gagal");
    }
}


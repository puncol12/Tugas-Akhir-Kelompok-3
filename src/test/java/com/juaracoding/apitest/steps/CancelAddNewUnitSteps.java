package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancelAddNewUnitSteps {

    WebDriver driver;
    UnitPage unitPage;

    public CancelAddNewUnitSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPage = new UnitPage(driver);
    }

    @When("Isi Nama Unit {string} untuk batal")
    public void inputNameUnit(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Centang checkbox Lokasi Absen Tetap untuk batal")
    public void checkTheCheckbok() throws InterruptedException {
        unitPage.centangLokasiAbsen();
        Thread.sleep(500);
    }

    @And("Pilih Unit Kalender {string} untuk batal")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPage.pilihUnitKalender(Kalender);
        Thread.sleep(500);
    }

    @And("Pilih Aturan Cuti {string} untuk batal")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPage.pilihAturanCuti(Aturan);
        Thread.sleep(500);
    }

    @Then("Unit baru batal ditambahkan")
    public void unitNewCancelAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Form tidak ditutup, pembatalan gagal");
    }
}


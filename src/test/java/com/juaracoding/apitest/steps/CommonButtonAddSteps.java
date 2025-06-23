package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonButtonAddSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Klik tombol Tambahkan")
    public void clickButtonTambahkan() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPage.bukaSubmenuUnit();
        Thread.sleep(1000);
        unitPageAddUnit.clickButtonTambahkan();
    }
    
    @When("Centang checkbox Lokasi Absen Tetap")
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
}

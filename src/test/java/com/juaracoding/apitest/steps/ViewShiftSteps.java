package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewShiftSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;
    UnitPageUnitShift unitPageUnitShift;

    @When("Klik tombol View")
    public void viewSteps() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageUnitShift = new UnitPageUnitShift(driver);

        unitPageUnitShift.isViewShift();
        Thread.sleep(1000);
    }

    @And("Pilih nama shift {string}")
    public void pilihNamaShift(String namaShift) {
        unitPageAddUnit.pilihUnitShiftDetail(namaShift);
    }

    @Then("Menampilkan informasi shift")
    public void validasiDataView() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

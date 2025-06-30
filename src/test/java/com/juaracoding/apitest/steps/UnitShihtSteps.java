package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UnitShihtSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageUnitShift unitPageUnitShift;

    public UnitShihtSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        unitPageUnitShift = new UnitPageUnitShift(driver);
    }

    @And("Klik tombol Shift")
    public void clickShiftStep() throws InterruptedException {
        unitPage.action01();
        Thread.sleep(1000);
    }

    @Then("Masuk ke menu shift")
    public void validasiDataShift() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

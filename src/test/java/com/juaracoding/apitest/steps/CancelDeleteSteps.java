package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CancelDeleteSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    @Given("Klik Tidak")
    public void deleteKlikTidak() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);
        unitPageUnitShift.isCancelDeleteShift();
        Thread.sleep(1000);
    }

    @Then("Shift batal dihapus")
    public void validasiBatalHapus() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

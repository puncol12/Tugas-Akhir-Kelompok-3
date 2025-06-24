package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UnitShihtSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageAddUnitShift unitPageAddUnitShift;

    @Given("Klik tombol titik 3 pada salah satu unit")
    public void shiftStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageAddUnitShift = new UnitPageAddUnitShift(driver);
        unitPage.bukaAction();
        Thread.sleep(1000);
    }

    @When("Klik tombol Shift")
    public void clickShiftStep() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage.action01();
        Thread.sleep(1000);
    }

    @And("Masuk ke menu shift")
    public void validasiDataShift() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

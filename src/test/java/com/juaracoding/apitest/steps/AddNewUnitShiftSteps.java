package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPageAddUnitShift;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewUnitShiftSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    UnitPageAddUnitShift unitPageAddUnitShift;

    @Given("Masukkan nama shift {string}")
    public void inputNameShift(String nama) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnitShift = new UnitPageAddUnitShift(driver);
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }

    @Then("Berhasil menambahkan shift")
    public void isShiftSuccesAdded() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnitShift.isShiftSuccesAdded();
        Assert.assertTrue(isExsist, "Unit Shift baru tidak berhasil ditambahkan");
    }
}

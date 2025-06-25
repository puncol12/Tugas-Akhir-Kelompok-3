package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewUnitShiftSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    UnitPageUnitShift unitPageUnitShift;

    @Given("Masukkan nama shift {string}")
    public void inputNameShift(String nama) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageUnitShift = new UnitPageUnitShift(driver);
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }

    @Then("Berhasil menambahkan shift")
    public void isShiftSuccesAdded() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isShiftSuccesAdded();
        Assert.assertTrue(isExsist, "Unit Shift baru tidak berhasil ditambahkan");
    }
}

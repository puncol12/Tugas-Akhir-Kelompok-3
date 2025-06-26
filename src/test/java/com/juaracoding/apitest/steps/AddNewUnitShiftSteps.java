package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Then;

public class AddNewUnitShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;
    
    @Then("Berhasil menambahkan shift")
    public void isShiftSuccesAdded() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isShiftSuccesAdded();
        Assert.assertTrue(isExsist, "Unit Shift baru tidak berhasil ditambahkan");
    }
}

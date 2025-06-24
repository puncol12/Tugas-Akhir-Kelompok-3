package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewUnitLeaveRulesEmptySteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Kosongkan Aturan Cuti")
    public void leaveRulesEmpty() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
    }

    @Then("Unit Baru berhasil ditambahkan")
    public void unitNewSuccesAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
        driver.quit();
    }
}

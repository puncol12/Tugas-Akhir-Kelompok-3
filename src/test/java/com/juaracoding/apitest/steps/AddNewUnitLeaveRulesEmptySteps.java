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

    @Then("Notifikasi Error muncul")
    public void unitNewSuccesAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertFalse(isExsist, "Unit baru justru berhasil ditambahkan, padahal seharusnya gagal.");
        driver.quit();
    }
}

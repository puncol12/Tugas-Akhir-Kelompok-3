package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddNewUnitLeaveRulesEmptySteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    public AddNewUnitLeaveRulesEmptySteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPageAddUnit = new UnitPageAddUnit(driver);
    }

    @And("Kosongkan Aturan Cuti")
    public void leaveRulesEmpty() throws InterruptedException {
        Thread.sleep(500);
    }

    @Then("Notifikasi Error muncul")
    public void unitNewSuccesAdd() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertFalse(isExsist,
                "Unit baru justru berhasil ditambahkan, padahal seharusnya gagal.");
        // driver.quit();
    }
}

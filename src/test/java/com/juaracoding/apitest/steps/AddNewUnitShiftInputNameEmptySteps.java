package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddNewUnitShiftInputNameEmptySteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    @And("Kosongkan nama shift {string}")
    public void inputShiftNameEmpty(String nama) {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnit.inputNama(nama);
    }

    @Then("Notifikasi error muncul dan menampilkan pesan {string}")
    public void notifRequiredInputShiftName(String notif) throws InterruptedException {
        String actualError = unitPageAddUnit.isRequiredName();
        Assert.assertEquals(actualError, notif);
        unitPageAddUnit.clickButtonBatalTambah();
        Thread.sleep(1000);
        // driver.quit();
    }

}

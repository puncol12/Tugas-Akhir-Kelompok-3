package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewUnitInputNameEmptySteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    public AddNewUnitInputNameEmptySteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPageAddUnit = new UnitPageAddUnit(driver);
    }

    @When("Kosongkan Nama Unit {string}")
    public void inputNameEmpty(String nama) throws InterruptedException {
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(500);
    }

    @Then("Notifikasi error muncul menampilkan pesan {string}")
    public void notifRequiredInputName(String notif) throws InterruptedException {
        String actualError = unitPageAddUnit.isRequiredName();
        Assert.assertEquals(actualError, notif);
        Thread.sleep(1000);
        unitPageAddUnit.clickButtonBatalTambah();
    }
}

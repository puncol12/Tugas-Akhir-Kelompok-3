package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddNewUnitShiftInputNameEmptySteps {

    WebDriver driver;
    UnitPage unitPage;

    public AddNewUnitShiftInputNameEmptySteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPage = new UnitPage(driver);
    }

    @And("Kosongkan nama shift {string}")
    public void inputShiftNameEmpty(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @Then("Notifikasi error muncul dan menampilkan pesan {string}")
    public void notifRequiredInputShiftName(String notif) throws InterruptedException {
        String actualError = unitPage.isRequiredName();
        Assert.assertEquals(actualError, notif);
        unitPage.clickButtonBatalTambah();
        Thread.sleep(1000);
    }

}

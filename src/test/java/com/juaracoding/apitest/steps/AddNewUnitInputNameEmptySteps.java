package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewUnitInputNameEmptySteps {

    WebDriver driver;
    UnitPage unitPage;

    public AddNewUnitInputNameEmptySteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
    }

    @When("Kosongkan Nama Unit {string}")
    public void inputNameEmpty(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @Then("Notifikasi error muncul menampilkan pesan {string}")
    public void notifRequiredInputName(String notif) throws InterruptedException {
        String actualError = unitPage.isRequiredName();
        Assert.assertEquals(actualError, notif);
        Thread.sleep(1000);
        unitPage.clickButtonBatalTambah();
    }
}

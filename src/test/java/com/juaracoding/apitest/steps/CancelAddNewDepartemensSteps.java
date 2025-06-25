package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitSettingPage;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CancelAddNewDepartemensSteps {
    WebDriver driver;
    UnitSettingPage unitSettingPage;
    UnitPage unitPage;

    @Given("user memilih {string}")
    public void userMemilihDepartment(String departmentName) throws InterruptedException {
    driver = DriverSingleton.createOrGetDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    unitPage = new UnitPage(driver);
    unitSettingPage = new UnitSettingPage(driver);
    unitSettingPage.pilihDepartment(departmentName);
    Thread.sleep(1000);
    }

    @Then("Data tetap seperti awal {string}")
    public void unitNewSuccesAdd(String notifSucces) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Departemens tidak muncul");
    }
}

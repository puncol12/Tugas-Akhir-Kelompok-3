package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DuplicateDepartemensSteps {

    WebDriver driver;
    UnitSettingPage unitSettingPage;

    @Given("User Memilih {string}")
    public void userMemilihDepartment(String departmentName) throws InterruptedException {
    driver = DriverSingleton.createOrGetDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    unitSettingPage = new UnitSettingPage(driver);
    unitSettingPage.pilihDepartment(departmentName);
    }

    @Then("Muncul Notifikasi {string}")
    public void unitNewSuccesAdd(String pesanNotifikasi) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitSettingPage.failAddDuplicateDepartemens();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }

}

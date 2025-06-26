package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;
    UnitPage unitPage;

    @Given("Klik tombol Shift untuk delete")
    public void clickShiftStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageUnitShift = new UnitPageUnitShift(driver);
        unitPage.action01();
        Thread.sleep(1000);
    }

    @Given("Klik tombol Delete")
    public void klikTombolDelete() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift.isDeletedShift();
        Thread.sleep(1000);
    }

    @When("Klik Ya")
    public void klikTombolYa() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift.isAccDeleteShift();
        Thread.sleep(1000);
    }

    @Then("Shift berhasil dihapus")
    public void isSuccesDeleted() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDeleteShiftSucces();
        Assert.assertTrue(isExsist, "Unit Shift tidak berhasil dihapus");
    }
}

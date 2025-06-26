package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUnitShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;
    UnitPage unitPage;

    @When("Klik tombol Edit")
    public void klikButtonEdit() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);
        unitPage = new UnitPage(driver);

        unitPageUnitShift.isEditShift();
        Thread.sleep(1000);
    }

    @When("Klik Simpan")
    public void klikSimpanEdit() throws InterruptedException {
        unitPageUnitShift.isButtonSave();
        Thread.sleep(500);
    }

    @Then("Berhasil mengedit nama shift")
    public void validasiDataEdit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit Shift tidak berhasil teredit");
    }
}

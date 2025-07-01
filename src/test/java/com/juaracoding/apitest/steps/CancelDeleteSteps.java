package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CancelDeleteSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    public CancelDeleteSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);
    }

    @When("Klik tombol Delete1")
    public void klikTombolDelete() throws InterruptedException {
        unitPageUnitShift.isDeletedShift();
        Thread.sleep(1000);
    }

    @And("Klik Tidak")
    public void deleteKlikTidak() throws InterruptedException {
        unitPageUnitShift.isCancelDeleteShift();
        Thread.sleep(1000);
    }

    @And("Klik Batal Edit View")
    public void viewDeleteKlikTidak() throws InterruptedException {
        unitPageUnitShift.isCancelDeleteShift();
        Thread.sleep(1000);
    }

    @Then("Shift batal dihapus")
    public void validasiBatalHapus() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
    @Then("Shift batal dihapus view")
    public void validasiBatalHapusViewd() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

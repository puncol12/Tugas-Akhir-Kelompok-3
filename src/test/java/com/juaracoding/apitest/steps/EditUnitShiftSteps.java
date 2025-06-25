package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUnitShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    @Given("Klik tombol Edit")
    public void klikButtonEdit() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);

        unitPageUnitShift.isEditShift();
        Thread.sleep(1000);
    }

    @When("Klik Simpan")
    public void klikSimpanEdit() {}

    @Then("Berhasil mengedit nama shift")
    public void validasiDataEdit() {}
}

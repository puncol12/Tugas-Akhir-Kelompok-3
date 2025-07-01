package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.When;

public class CommonInputSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    public CommonInputSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPageAddUnit = new UnitPageAddUnit(driver);
    }

    @When("Masukkan nama shift {string}")
    public void inputNameShift(String nama) throws InterruptedException {
        unitPageAddUnit.inputNama(nama);
        Thread.sleep(1000);
    }
}

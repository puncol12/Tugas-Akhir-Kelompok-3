package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Given;

public class CommonShiftButtonActionSteps {
    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    public CommonShiftButtonActionSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
        driver.navigate().refresh();
        unitPageUnitShift = new UnitPageUnitShift(driver);      
    }
    
    @Given("Klik tombol titik 3 pada salah satu shift")
    public void shiftActionStep() throws InterruptedException {
        Thread.sleep(1000);
        unitPageUnitShift.buttonShiftAction();
    }
}

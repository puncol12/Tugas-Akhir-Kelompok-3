package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.Given;

public class AddNewUnitLeaveRulesEmpty {

    WebDriver driver;

    @Given("Kosongkan Aturan Cuti")
    public void leaveRulesEmpty() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

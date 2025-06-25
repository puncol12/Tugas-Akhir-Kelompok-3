package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.Given;

public class AddNewUnitCheckboxEmptySteps {

    WebDriver driver;

    @Given("Kosongkan checkbox Lokasi Absen Tetap")
    public void emptyCheckbox() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

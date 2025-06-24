package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.en.Given;

public class AddNewUnitCalendarEmptySteps {

    WebDriver driver;

    @Given("Kosongkan Unit Kalender")
    public void calendarEmpty() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPagePages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PreviousPageSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPagePages unitPagePages;

    public PreviousPageSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        unitPage =new UnitPage(driver);
        unitPagePages = new UnitPagePages(driver);
    }

}

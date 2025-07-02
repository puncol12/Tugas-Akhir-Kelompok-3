package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPagePages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GoToNextPrevPageUnitSettingSteps {

    WebDriver driver;
    UnitPagePages unitPagePages;

    @Given("Klik go to next page di bagian bawah halaman unit setting")
    public void clickNextStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPagePages = new UnitPagePages(driver);
        unitPagePages.clickNextPage();
        Thread.sleep(1000); //2000
    }
    
  @Then("Klik go to previous page di bagian bawah halaman unit setting")
    public void clickPreviousStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPagePages = new UnitPagePages(driver);
        unitPagePages.clickPreviousPage();
        Thread.sleep(1000);
    }
}

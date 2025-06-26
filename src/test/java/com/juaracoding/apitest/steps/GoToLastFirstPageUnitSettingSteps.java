package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPagePages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GoToLastFirstPageUnitSettingSteps {
    
    WebDriver driver;
    UnitPagePages unitPagePages;

    @Given("Klik go to last page di bagian bawah halaman unit setting")
    public void lastPageSteps() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPagePages = new UnitPagePages(driver);
        unitPagePages.clickLastPage();
        Thread.sleep(1000);
    }

    @Then("Klik go to first page di bagian bawah halaman unit setting")
    public void firstPageSteps() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPagePages = new UnitPagePages(driver);
        
        unitPagePages.clickFirstPage();
        Thread.sleep(1000);
    }

}

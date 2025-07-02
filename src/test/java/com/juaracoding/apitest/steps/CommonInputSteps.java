package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.When;

public class CommonInputSteps {

    WebDriver driver;
    UnitPage unitPage;

    public CommonInputSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPage = new UnitPage(driver);
    }

    @When("Masukkan nama shift {string}")
    public void inputNameShift(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(1000);
    }
}

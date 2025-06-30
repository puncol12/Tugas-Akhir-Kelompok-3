package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;

public class CommonButtonActionSteps {

    WebDriver driver;
    UnitPage unitPage;

    public CommonButtonActionSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPage = new UnitPage(driver);
    }

    @And("Klik tombol titik 3 pada salah satu unit")
    public void unitActionStep() throws InterruptedException {
        driver.navigate().refresh();
        unitPage.bukaAction();
        Thread.sleep(500);
    }
}

package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.Given;

public class CommonButtonAddSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Klik tombol Tambahkan")
    public void clickButtonTambahkan() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPage.bukaSubmenuUnit();
        Thread.sleep(1000);
        unitPageAddUnit.clickButtonTambahkan();
    }
}

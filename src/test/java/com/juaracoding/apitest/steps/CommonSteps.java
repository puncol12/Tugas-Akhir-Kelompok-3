package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps {

    WebDriver driver;
    LoginPage loginPage;
    UnitPage unitPage;

    @Given("Login dengan user valid")
    public void userLoginDenganKredensialValid() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage = new LoginPage(driver);
        unitPage = new UnitPage(driver);

        loginPage.login("admin@hadir.com", "MagangSQA_JC@123");
    }

    @When("Klik menu Management")
    public void userKlikMenuManagement() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage.bukaMenuManagement();
    }

    @And("Klik submenu Unit")
    public void userKlikSubmenuUnit() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage.bukaSubmenuUnit();
    }

}

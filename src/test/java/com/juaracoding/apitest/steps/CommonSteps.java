package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitSettingPage;
import com.juaracoding.apitest.pages.UserPage;
import com.juaracoding.apitest.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps {

    WebDriver driver;
    LoginPage loginPage;
    UnitPage unitPage;
    UnitSettingPage unitSettingPage;
    UserPage userPage;

    public CommonSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magang.dikahadir.com/authentication/login");
        
        loginPage = new LoginPage(driver);
        unitPage = new UnitPage(driver);
        unitSettingPage = new UnitSettingPage(driver); 
        userPage  = new UserPage(driver);       
    }

    @Given("Login dengan user valid")
    public void userLoginDenganKredensialValid() throws InterruptedException {
        String username = ConfigReader.getProperty("username");
        loginPage.login("admin@hadir.com", "MagangSQA_JC@123");
    }

    @When("Klik menu Management")
    public void userKlikMenuManagement() throws InterruptedException {
        unitPage.bukaMenuManagement();
        Thread.sleep(500);
    }

    @And("Klik submenu Unit")
    public void userKlikSubmenuUnit() throws InterruptedException {
        unitPage.bukaSubmenuUnit();
        Thread.sleep(500);
    }

    @And("Klik submenu Unit Setting")
    public void userKlikSubmenuUnitSetting() throws InterruptedException {
        unitSettingPage.bukaSubmenuUnitSetting();
        Thread.sleep(500);
    }

    @And("Klik submenu User")
    public void userKlikSubmenuUser() throws InterruptedException {
        userPage.submenuUser();
        Thread.sleep(500);
    }
}

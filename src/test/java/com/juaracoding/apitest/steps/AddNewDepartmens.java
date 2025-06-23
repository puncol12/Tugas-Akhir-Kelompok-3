package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddNewDepartmens {

    WebDriver driver;
    LoginPage loginPage;
    UnitSettingPage unitSettingPage;

    @Given("Login dengan User valid")
    public void userLoginDenganKredensialValid() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage = LoginPage.init(driver);
        unitSettingPage = unitSettingPage.init(driver);

        loginPage.login("admin@hadir.com", "MagangSQA_JC@123");
    }

    @When("Klik menu management")
    public void userKlikMenuManagement() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.bukaMenuManagement();
    }

    @And("Klik submenu Unit Setting")
    public void userKlikSubmenuUnitSetting() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.bukaSubmenuUnitSetting();
    }


    @And("Klik Tombol Tambahkan")
    public void userKlikTombolTambahkan() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.klikTombolTambahkan();
    }
   

     @And("Klik Tombol Drop Down")
    public void userKlikTombolDropDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.klikTombolDropDown();
    }

    @And("User memilih test unit 33")
    public void userMemilihTestUnit33() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.cekAdaTestUnit33();
    }

    @And("Klik Tombol Tambah")
    public void userKlikTombolTambah() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage.klikTombolTambah();
    }
}
    



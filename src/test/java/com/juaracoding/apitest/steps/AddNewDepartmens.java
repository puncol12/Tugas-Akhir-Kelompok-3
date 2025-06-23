package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddNewDepartmens {

    WebDriver driver;
    UnitSettingPage unitSettingPage;

    @Given("Klik submenu Unit Setting")
    public void userKlikSubmenuUnitSetting() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage = new UnitSettingPage(driver);
        unitSettingPage.bukaSubmenuUnitSetting();
    }

    @When("Klik Tombol Tambahkan")
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
        driver.quit();
    }
}
    



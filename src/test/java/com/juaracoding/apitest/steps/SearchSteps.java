package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    WebDriver driver;
    LoginPage loginPage;
    UnitPage unitPage;

    @Given("Login dengan user valid")
    public void userLoginDenganKredensialValid() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage = LoginPage.init(driver);
        unitPage = UnitPage.init(driver);

        loginPage.login("admin@hadir.com", "MagangSQA_JC@123");
        Thread.sleep(1000);
    }

    @When("Klik menu Management")
    public void userKlikMenuManagement() throws InterruptedException {
        unitPage.bukaMenuManagement();
        Thread.sleep(1000);
    }

    @When("Klik submenu Unit")
    public void userKlikSubmenuUnit() throws InterruptedException {
        unitPage.bukaSubmenuUnit();
        Thread.sleep(1000);
    }

    @When("Masukkan nama unit pada kotak Search dengan input {string}")
    public void userMasukkanNamaUnit(String keyword) throws InterruptedException {
        unitPage.searchUnit(keyword);
        Thread.sleep(1000);
    }

    @When("Klik tombol Search")
    public void userKlikTombolSearch() throws InterruptedException {
        unitPage.searchButton();
        Thread.sleep(1000);
    }

    @Then("Data unit yang sesuai dengan pencarian ditampilkan untuk {string}")
    public void hasilPencarianMenampilkanUnitDenganNama(String expectedText) throws InterruptedException {
        boolean isDisplayed = unitPage.isSearchResultDisplayed(expectedText);
        Assert.assertTrue(isDisplayed, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
    }
}

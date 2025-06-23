package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageSearch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageSearch unitPageSearch;

    @Given("Klik submenu Unit")
    public void userKlikSubmenuUnit() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPageSearch = new UnitPageSearch(driver);
        unitPage.bukaSubmenuUnit();
    }

    @When("Masukkan nama unit pada kotak Search dengan input {string}")
    public void userMasukkanNamaUnit(String keyword) throws InterruptedException {
        unitPageSearch.searchUnit(keyword);
        Thread.sleep(1000);
    }

    @And("Klik tombol Search")
    public void userKlikTombolSearch() throws InterruptedException {
        unitPageSearch.searchButton();
        Thread.sleep(1000);
    }

    @Then("Data unit yang sesuai dengan pencarian ditampilkan untuk {string}")
    public void hasilPencarianMenampilkanUnitDenganNama(String keyword) throws InterruptedException {
        boolean isExsist = unitPage.isSearchResultDisplayed(keyword);
        Assert.assertTrue(isExsist, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
    }
}

package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageSearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchResetSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPageSearch unitPageSearch;

    @Given("Klik tombol Reset")
    public void klikTombolReset() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = UnitPage.init(driver);
        unitPageSearch = UnitPageSearch.init(driver);
        unitPageSearch.resetButton();
    }

    @Then("Input pada kotak Search dihapus dan data unit kembali ke kondisi awal")
    public void resetData() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit tidak kembali ke kondisi awal setelah reset");
    }
}

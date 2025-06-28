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

    public SearchResetSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        unitPageSearch = new UnitPageSearch(driver);
    }

    @Given("Klik tombol Reset")
    public void klikTombolReset() throws InterruptedException {
        unitPageSearch.resetButton();
        Thread.sleep(500);
    }

    @Then("Input pada kotak Search dihapus dan data unit kembali ke kondisi awal")
    public void resetData() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit tidak kembali ke kondisi awal setelah reset");
    }
}

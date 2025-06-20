package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NextPageSteps {

    WebDriver driver;
    UnitPage unitPage;

    @Given("Klik go to next page di bagian bawah halaman tambah unit")
    public void clickNextStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = UnitPage.init(driver);

        unitPage.clickNextPage();
        Thread.sleep(2000);
    }

    @Then("Menampilkan data unit halaman selanjutnya")
    public void dataHalamanSelanjutnya() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik next page");
    }
}

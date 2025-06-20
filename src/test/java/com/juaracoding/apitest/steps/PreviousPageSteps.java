package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PreviousPageSteps {

    WebDriver driver;
    UnitPage unitPage;

    @Given("Klik go to previous page di bagian bawah halaman tambah unit")
    public void clickPreviousStep() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = UnitPage.init(driver);

        unitPage.clickPreviousPage();
        Thread.sleep(2000);
    }

    @Then("Menampilkan data unit halaman sebelumnya")
    public void dataHalamanSebelumnya() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik previous page");
    }
}

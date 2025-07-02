package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPagePages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PreviousPageSteps {

    WebDriver driver;
    UnitPage unitPage;
    UnitPagePages unitPagePages;

    public PreviousPageSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        unitPage =new UnitPage(driver);
        unitPagePages = new UnitPagePages(driver);
    }

    @Given("Klik go to previous page di bagian bawah halaman tambah unit")
    public void clickPreviousStep() throws InterruptedException {
        unitPagePages.clickPreviousPage();
        Thread.sleep(500);
    }

    @Then("Menampilkan data unit halaman sebelumnya")
    public void dataHalamanSebelumnya() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik previous page");
    }
}

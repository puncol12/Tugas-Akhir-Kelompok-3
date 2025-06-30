package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPagePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LastPageStepsPosisi {

    WebDriver driver;
    UnitPage unitPage;
    UnitPagePages unitPagePages;

    @Given("Klik go to last page di bagian bawah halaman tambah posisi")
    public void lastPageSteps() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);
        unitPagePages = new UnitPagePages(driver);

        unitPagePages.clickLastPage();
        Thread.sleep(1000);
    }

    @Then("Menampilkan data posisi halaman terakhir")
    public void viewLastPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik last page");
    }
}

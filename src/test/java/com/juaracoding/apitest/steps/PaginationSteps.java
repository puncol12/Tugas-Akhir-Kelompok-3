package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationSteps {

    WebDriver driver;
    UnitPage unitPage;

    public PaginationSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
    }

    @Given("Klik go to first page di bagian bawah halaman tambah unit")
    public void firstPagingSteps() throws InterruptedException {
        unitPage.clickFirstPage();
        Thread.sleep(500);
    }

    @When("Klik go to first page di bagian bawah halaman tambah posisi")
    public void firstPagingStepsPosisi() throws InterruptedException {
        unitPage.clickFirstPage();
        Thread.sleep(1000);
    }

    @And("Klik go to next page di bagian bawah halaman tambah unit")
    public void clickNextStep() throws InterruptedException {
        unitPage.clickNextPage();
        Thread.sleep(500);
    }

    @And("Klik go to next page di bagian bawah halaman tambah posisi")
    public void klik_goto_next_page() throws InterruptedException {
        unitPage.clickNextPage();
        Thread.sleep(1000);
    }

    @And("Klik go to last page di bagian bawah halaman tambah unit")
    public void lastPageSteps() throws InterruptedException {
        unitPage.clickLastPage();
        Thread.sleep(1000);
    }

    @And("Klik go to last page di bagian bawah halaman tambah posisi")
    public void lastPageStepsPosisi() throws InterruptedException {
        unitPage.clickLastPage();
        Thread.sleep(1000);
    }
  
    @And("Klik go to previous page di bagian bawah halaman tambah unit")
    public void clickPreviousStep() throws InterruptedException {
        unitPage.clickPreviousPage();
        Thread.sleep(500);
    }

    @Then("Menampilkan data unit halaman sebelumnya")
    public void dataHalamanSebelumnya() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik previous page");
    }

    @Then("Menampilkan data posisi halaman terakhir")
    public void viewLastPagePosisi() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik last page");
    }

    @Then("Menampilkan data unit halaman terakhir")
    public void viewLastPage() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik last page");
    }

    @Then("Menampilkan data posisi halaman selanjutnya")
    public void tampil_halaman_selanjutnya() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik next page");
    }

    @Then("Menampilkan data unit halaman selanjutnya")
    public void dataHalamanSelanjutnya() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik next page");
    }

    @Then("Menampilkan data posisi halaman pertama")
    public void validasiDataPetamaPosisi() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik first page");
    }

    @Then("Menampilkan data unit halaman pertama")
    public void validasiDataPetama() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak berubah setelah klik first page");
    }
}

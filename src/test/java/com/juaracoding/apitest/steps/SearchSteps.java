package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    WebDriver driver;
    UnitPage unitPage;
    PagePosisi pagePosisi;

    public SearchSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPage = new UnitPage(driver);
        pagePosisi = new PagePosisi(driver);
    }

    @When("Masukkan nama unit pada kotak Search dengan input {string}")
    public void userMasukkanNamaUnit(String keyword) throws InterruptedException {
        unitPage.searchUnit(keyword);
        Thread.sleep(1000);
    }

    @And("Klik tombol Search")
    public void userKlikTombolSearch() throws InterruptedException {
        unitPage.searchButton();
        Thread.sleep(5000);
    }

    @And("Klik tombol Reset")
    public void klikTombolReset() throws InterruptedException {
        unitPage.resetButton();
        Thread.sleep(500);
        driver.navigate().refresh();
    }

    @When("Masukkan nama posisi pada kotak Search dengan input {string}")
    public void input_kata_kunci_posisi(String keyword) throws InterruptedException {
        pagePosisi.searchPosisi(keyword);
        Thread.sleep(1000);
    }

    @And("Klik tombol Search di halaman Posisi")
    public void klik_tombol_search_posisi() throws InterruptedException {
        pagePosisi.searchButtonPosisi();
        Thread.sleep(1000);
    }

    @Then("Data posisi yang sesuai dengan pencarian ditampilkan untuk {string}")
    public void hasil_pencarian_posisi_ditampilkan(String keyword) throws InterruptedException {
        boolean isExist = pagePosisi.isSearchResultDisplayedPosisi(keyword);
        Assert.assertFalse(isExist, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
    }

    @Then("Input pada kotak Search dihapus dan data unit kembali ke kondisi awal")
    public void resetData() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit tidak kembali ke kondisi awal setelah reset");
    }

    @Then("Data unit yang sesuai dengan pencarian ditampilkan untuk {string}")
    public void hasilPencarianMenampilkanUnitDenganNama(String keyword)
            throws InterruptedException {
        boolean isExist = unitPage.isSearchResultDisplayed(keyword);
        Assert.assertTrue(isExist, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
    }
}

package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.time.Duration;

public class SearchStepPosisi {

    WebDriver driver;
    PagePosisi pagePosisi;
    PagePosisiSearch pagePosisiSearch;

    @When("Masukkan nama posisi pada kotak Search dengan input {string}")
    public void input_kata_kunci_posisi(String keyword) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pagePosisi = new PagePosisi(driver);
        pagePosisiSearch = new PagePosisiSearch(driver);
        pagePosisiSearch.searchPosisi(keyword);
        Thread.sleep(1000);
    }

    @And("Klik tombol Search di halaman Posisi")
    public void klik_tombol_search_posisi() throws InterruptedException {
        pagePosisiSearch.searchButtonPosisi();
        Thread.sleep(1000);
    }

    @Then("Data posisi yang sesuai dengan pencarian ditampilkan untuk {string}")
    public void hasil_pencarian_posisi_ditampilkan(String keyword) throws InterruptedException {
        boolean isExist = pagePosisi.isSearchResultDisplayedPosisi(keyword);
        Assert.assertFalse(isExist, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
    }
}
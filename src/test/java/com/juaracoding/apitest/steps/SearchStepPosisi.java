package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchStepPosisi {

    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);


    @When("Masukkan kata kunci {string} pada kotak Search")
    public void input_kata_kunci_pada_search(String keyword) throws InterruptedException {
        posisiPage.searchPosisi(keyword);
        Thread.sleep(1000);
        System.out.println("search keyword");
    }

    @And("Klik tombol Search pada menu Posisi")
    public void klik_tombol_search_posisi() throws InterruptedException {
        posisiPage.searchButton();
        Thread.sleep(1000);
        System.out.println("search klik");
    }

    @Then("Data posisi yang sesuai dengan kata kunci {string} ditampilkan")
    public void data_posisi_yang_sesuai_dengan_keyword_ditampilkan(String keyword) throws InterruptedException {
        boolean isExsist = posisiPage.isSearchResultDisplayed(keyword);
        Assert.assertTrue(isExsist, "Hasil pencarian tidak ditemukan");
        Thread.sleep(1000);
        System.out.println("keyword success");
    }
}

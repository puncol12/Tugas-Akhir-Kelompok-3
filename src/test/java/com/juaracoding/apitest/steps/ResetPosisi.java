package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ResetPosisi {

    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

    @When("Klik tombol Reset pada kotak Search di menu Posisi")
    public void klik_tombol_reset_posisi() {
        posisiPage.klikTombolResetSearch();
        System.out.println("Klik tombol reset pencarian posisi");
    }

    @Then("Data posisi ditampilkan seluruhnya")
    public void resetData() {
        Assert.assertTrue(posisiPage.isDataDitampilkanSemua());
        System.out.println("menampilkan semua data");
    }
}

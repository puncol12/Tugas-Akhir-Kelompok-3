package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageSearch;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UserMenuActionSteps {

    WebDriver driver;
    UnitPage unitPage;
    UserPage userPage;
    UnitPageSearch unitPageSearch;
    
    public UserMenuActionSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        userPage = new UserPage(driver);
        unitPageSearch = new UnitPageSearch(driver);
    }

    @And("Pilih Pencarian Nama")
    public void pencarianByNama() throws InterruptedException {
        userPage.btnPencarianPilihan();
        userPage.btnPencarianNama();
        Thread.sleep(500);
    }

    @And("Masukan Pencarian {string}")
    public void inputPencarian(String keyword) throws InterruptedException {
        unitPageSearch.searchUnit(keyword);
        Thread.sleep(500);
    }

    @And("Pilih Pencarian NIK")
    public void pencarianByNik() throws InterruptedException {
        userPage.btnPencarianPilihan();
        userPage.btnPencarianNik();
        Thread.sleep(500);
    }

    @Then("Menampilkan data yang dicari berdasarkan Status yang dipilih")
    public void dataSesuai() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit tidak kembali ke kondisi awal setelah reset");
    }
}

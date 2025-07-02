package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShowPageSteps {

    WebDriver driver;
    UnitPage unitPage;
    int jumlahDipilih;

    public ShowPageSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
    }

    @Given("Pilih jumlah data {int} yang ingin ditampilkan per halaman di field Show Page")
    public void pilihJumlahData(int jumlah) {
        jumlahDipilih = jumlah;
        unitPage.selectShowPage(jumlahDipilih);
    }

    @Then("Data unit ditampilkan sesuai dengan jumlah {int} yang dipilih di Show Page")
    public void dataUnitSesuaiJumlah(int jumlah) {
        int jumlahTampil = unitPage.getJumlahData();
        Assert.assertTrue(jumlahTampil <= jumlahDipilih, "Data yang ditampilkan (" + jumlahTampil
                + ") melebihi jumlah yang dipilih (" + jumlahDipilih + ")");
    }
}

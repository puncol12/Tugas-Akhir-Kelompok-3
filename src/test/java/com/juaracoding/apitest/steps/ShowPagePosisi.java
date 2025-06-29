package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class ShowPagePosisi {
    WebDriver driver;
    UnitPage unitPage;
    int jumlahDipilih;

    @Given("Pilih jumlah data {int} yang ingin ditampilkan per halaman di field Show Page Posisi")
    public void pilihJumlahData(int jumlah) {
        jumlahDipilih = jumlah;
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPage = new UnitPage(driver);

        unitPage.selectShowPage(jumlahDipilih);
    }

    @Then("Data posisi ditampilkan sesuai dengan jumlah {int} yang dipilih di Show Page")
    public void dataPosisiSesuaiJumlah(int jumlah) {
        int jumlahTampil = unitPage.getJumlahData();
        Assert.assertTrue(jumlahTampil <= jumlahDipilih, "Data yang ditampilkan (" + jumlahTampil + ") melebihi jumlah yang dipilih (" + jumlahDipilih + ")");
        driver.quit();
    }
}

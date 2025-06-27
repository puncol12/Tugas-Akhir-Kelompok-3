package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class ShowPagePosisi {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);
    int jumlahDipilih;

    @Given("Pilih jumlah data {int} yang ingin ditampilkan per halaman di field Show Page di posisi")
    public void pilih_jumlah_data(int jumlah){
        jumlahDipilih = jumlah;
        posisiPage.selectShowPage(jumlah);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Pilih jumlah data per halaman: " + jumlah);
    }
    @Then("Data posisi ditampilkan sesuai dengan jumlah {int} yang dipilih di Show Page Posisi")
    public void dataPosisiSesuaiJumlah(int jumlah) {
            int jumlahTampil = posisiPage.getJumlahData();
            Assert.assertTrue(jumlahTampil <= jumlah, "Data yang ditampilkan (" + jumlahTampil + ") melebihi jumlah yang dipilih (" + jumlah + ")");
        }
    }

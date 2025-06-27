package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PreviousPagePosisi {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

    @Given("Klik go to previous page di bagian bawah halaman tambah posisi")
    public void klik_goto_previous_page(){
        posisiPage.klikPreviousPage();
        System.out.println("Klik tombol previous page");
    }

    @Then("Menampilkan data posisi halaman sebelumnya")
    public void tampil_halaman_sebelumnya(){
        Assert.assertTrue(posisiPage.isHalamanSebelumnyaTampil(), "Halaman sebelumnya tidak muncul");
        System.out.println("Data posisi halaman sebelumnya berhasil ditampilkan");
    }
    }

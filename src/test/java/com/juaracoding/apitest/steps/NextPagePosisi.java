package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NextPagePosisi {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

    @Given("Klik go to next page di bagian bawah halaman tambah posisi")
    public void klik_goto_next_page(){
        posisiPage.klikNextPage();
        System.out.println("klik tombol next page");
    }
    @Then("Menampilkan data posisi halaman selanjutnya")
    public void tampil_halaman_selanjutnya(){
        Assert.assertTrue(posisiPage.isHalamanSelanjutnyaTampil(), "Halaman selanjutnya tidak muncul");
        System.out.println("Data posisi halaman selanjutnya berhasil ditampilkan");
    }

}

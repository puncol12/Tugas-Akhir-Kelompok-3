package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubMenuPosisi {

    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

//    @Given("Admin berada di halaman Management bagian Posisi")
//    public void admin_berada_di_halaman_management_bagian_posisi() throws InterruptedException {
//        posisiPage.bukaMenuManagement();
//        posisiPage.bukaSubmenuPosisi();
//        System.out.println("menu posisi ditampilkan");
//        Thread.sleep(1000);
//    }
//
//    @When("Klik menu Manajemen")
//    public void klik_menu_manajemen() throws InterruptedException {
//        posisiPage.bukaMenuManagement();
//        Thread.sleep(1000);
//    }

    @Given("Klik submenu Posisi")
    public void klik_submenu_posisi() throws InterruptedException {
        posisiPage.bukaSubmenuPosisi();
        Thread.sleep(1000);
    }

    @Then("Daftar Posisi ditampilkan")
    public void daftar_posisi_ditampilkan() throws InterruptedException {
       //posisiPage = PagePosisi.init(driver);
        Assert.assertTrue(
                posisiPage.isPosisiPageDisplayed(),
                "Halaman Posisi tidak berhasil ditampilkan"
        );
        Thread.sleep(1000);
    }
}
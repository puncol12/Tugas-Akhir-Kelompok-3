package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EditPosisi {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

    //Positif Case
    @Given("Klik tombol titik 3 pada salah satu data posisi")
    public void klik_tombol_titik_3() throws InterruptedException {
        posisiPage.klikTombolTitik3();
        Thread.sleep(1000);
    }

    @When("Klik tombol Edit")
    public void klik_tombol_edit() {
        posisiPage.klikEditPosisi();
    }

    @And("Mengubah field Nama Posisi menjadi {string}")
    public void edit_field_posisi(String namaBaru) {
        posisiPage.ubahNamaPosisi(namaBaru);
    }

    @And("Klik tombol Simpan Edit")
    public void klik_tombol_simpan_edit() {
        posisiPage.klikSimpan();
    }

    @Then("Data posisi berhasil diperbaharui")
    public void data_posisi_berhasil_diperbaharui() {
        Assert.assertTrue(posisiPage.isUpdateBerhasil());
        System.out.println("Data posisi berhasil diperbaharui");
    }
}

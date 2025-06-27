package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TambahPosisiStep {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

//    @When("Klik tombol Tambah")
//    public void klik_tombol_tambah() {
//        posisiPage.klikTambahPosisi();
//    }

//    @Given("Form tambah posisi ditampilkan")
//    public void form_tambah_posisi() {
//        Assert.assertTrue(PagePosisi.isFormTambahPosisiMuncul());
//    }

    @When("Mengisi field Nama Posisi dengan {string}")
    public void input_field_posisi(String nama) throws InterruptedException {
        posisiPage.inputNamaPosisi(nama);
        Thread.sleep(1000);
    }

    @And("Mengisi field Department dengan {string}")
    public void input_field_department(String dept) {
        posisiPage.inputDepartment(dept);
    }

    @And("Mengosongkan field Department")
    public void mengosongkan_department() {

    }

    @And("Klik tombol Simpan")
    public void klik_simpan_tambah() {
        posisiPage.klikSimpanTambah();
    }

    @Then("Data posisi baru berhasil ditambahkan")
    public void data_posisi_baru_berhasil_ditambahkan() {
        Assert.assertTrue(posisiPage.isPosisiBerhasilDitambahkan());
    }

}
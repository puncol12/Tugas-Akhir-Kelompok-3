//package com.juaracoding.apitest.steps;
//
//import com.juaracoding.apitest.DriverSingleton;
//import com.juaracoding.apitest.pages.PagePosisi;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//public class EditPosisiNegative {
//    WebDriver driver = DriverSingleton.createOrGetDriver();
//    PagePosisi posisiPage = PagePosisi.init(driver);
//
////    @Given("Klik tombol titik 3 pada salah satu data posisi")
////    public void klik_tombol_titik_3() throws InterruptedException{
////        posisiPage.klikTombolTitik3();
////        Thread.sleep(1000);
////    }
//
//    @Given("Klik tombol Edit")
//    public void klik_tombol_edit() {
//        posisiPage.klikEditPosisi();
//    }
//    @And("Mengosongkan field Nama Posisi pada menu edit")
//    public void blank_field_posisi_edit() {
//        posisiPage.kosongkanNamaPosisiSaatEdit();
//        System.out.println("Mengosongkan field Nama Posisi");
//    }
//    @And("Klik tombol Simpan Edit")
//    public void klik_tombol_simpan_edit() {
//        posisiPage.klikSimpan();
//    }
//
//    @Then("Tampil pesan error {string} edit")
//    public void tampil_pesan_error(String expectedMsg) {
//        String actual = posisiPage.getErrorMessage();
//        Assert.assertTrue(actual.contains(expectedMsg), "Pesan error tidak sesuai");
//        System.out.println("Pesan error: " + actual);
//    }
//
////    @And("Klik tombol Batal Edit")
////    public void klik_tombol_batal_edit() {
////        posisiPage.klikBatal();
////        System.out.println("Klik tombol Batal");
////    }
////
////    @Then("Data posisi tidak berubah")
////    public void data_posisi_tidak_berubah() {
////        Assert.assertTrue(posisiPage.isDataTidakBerubah());
////        System.out.println("Data posisi tidak berubah");
////    }
//}

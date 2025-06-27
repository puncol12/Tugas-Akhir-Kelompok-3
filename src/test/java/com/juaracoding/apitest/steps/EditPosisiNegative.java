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
//    @And("Mengosongkan field Nama Posisi pada menu edit")
//    public void blank_field_posisi_edit() {
//        posisiPage.kosongkanNamaPosisiSaatEdit();
//        System.out.println("Mengosongkan field Nama Posisi");

//@Then("Tampil pesan error Nama Posisi wajib diisi pada menu tambah")
//public void tampil_pesan_error_menu_tambah() {
//    //Assert.assertTrue(posisiPage.getErrorMessageTambah().contains(expectedMsg));
//    String actualMsg = posisiPage.getErrorMessageTambah();
//    Assert.assertEquals(actualMsg, "Please fill out this field.");
//    driver.navigate().refresh();
//}
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

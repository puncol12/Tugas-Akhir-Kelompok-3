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
//public class DeletePosisi {
//    WebDriver driver = DriverSingleton.createOrGetDriver();
//    PagePosisi posisiPage = PagePosisi.init(driver);
//
////    @Given("Klik tombol titik 3 pada salah satu data posisi")
////    public void klik_tombol_titik_3() {
////        posisiPage.klikTombolTitik3();
////        System.out.println("Klik tombol titik 3");
////    }
//
//    @When("Klik tombol Delete")
//    public void klik_tombol_delete() throws InterruptedException{
////        posisiPage.klikTombolDelete();
////        System.out.println("delete");
//        Thread.sleep(1000);
//    }
//
//    @And("Muncul konfirmasi hapus posisi atau tidak")
//    public void konfirmasi_Hapus_posisi() throws InterruptedException {
//        posisiPage.halamanKonfirmasiHapus();
//        Thread.sleep(1000);
//    }
//
//    @Then("Data posisi berhasil dihapus")
//    public void data_posisi_berhasil_dihapus(){
//        System.out.println("data berhasil dihapus");
//    }
//    @And("Konfirmasi Hapus dengan memilih Tidak")
//    public void konfirmasi_Hapus_tidak() throws InterruptedException {
//        posisiPage.tombolTidak();
//        Thread.sleep(1000);
//    }
//
//    @Then("Data posisi tidak terhapus")
//    public void Data_posisi_tidak_terhapus(){
//        Thread.sleep(1000);
//        boolean isDataRestored = posisiPage.isDataRestored();
//        Assert.assertTrue(isDataRestored, "Data tetap kembali ke semula");
//    }
//}

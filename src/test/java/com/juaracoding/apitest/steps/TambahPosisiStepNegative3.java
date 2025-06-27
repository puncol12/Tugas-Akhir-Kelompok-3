package com.juaracoding.apitest.steps;

import io.cucumber.java.en.When;//package com.juaracoding.apitest.steps;
//
//import com.juaracoding.apitest.DriverSingleton;
//import com.juaracoding.apitest.pages.PagePosisi;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//public class TambahPosisiStepNegative2 {
//    WebDriver driver = DriverSingleton.createOrGetDriver();
//    PagePosisi posisiPage = PagePosisi.init(driver);
//
//@Given("Mengisi field Nama Posisi dengan {string}")
//public void input_field_posisi(String nama) throws InterruptedException {
//    posisiPage.inputNamaPosisi(nama);
//    Thread.sleep(1000);
//}
//@When("Mengosongkan field Nama Posisi")
//public void blank_field_posisi() {
//    posisiPage.kosongkanNamaPosisi();
//}
////    @And("Mengosongkan field Department")
////    public void blank_field_dept() {
////        posisiPage.kosongkanDepartment();
////    }
//
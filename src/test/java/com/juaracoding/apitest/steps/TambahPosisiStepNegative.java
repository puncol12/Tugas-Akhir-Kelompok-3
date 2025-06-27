package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TambahPosisiStepNegative {
    WebDriver driver = DriverSingleton.createOrGetDriver();
    PagePosisi posisiPage = PagePosisi.init(driver);

    @When("Mengosongkan field Nama Posisi")
    public void blank_field_posisi() {
        posisiPage.kosongkanNamaPosisi();
    }

    @And("Mengisi Field Department dengan {string}")
    public void input_field_department(String Dept) {
        posisiPage.inputDepartment(Dept);
    }
//    @And("Mengosongkan field Department")
//    public void blank_field_dept() {
//        posisiPage.kosongkanDepartment();
//    }

    @Then("Tampil pesan error {string} pada menu tambah")
    public void tampil_pesan_error_menu_tambah(String expectedMsg) {
        //Assert.assertTrue(posisiPage.getErrorMessageTambah().contains(expectedMsg));
        String actualMsg = posisiPage.getErrorMessageTambah();
        Assert.assertFalse(actualMsg.contains(expectedMsg), "Nama Posisi  Tetap terisikan!");
    }
}
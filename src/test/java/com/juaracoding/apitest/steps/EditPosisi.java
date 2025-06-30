package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class EditPosisi {
    WebDriver driver;
    PagePosisi pagePosisi;
    UnitPageAddUnit unitPageAddUnit;
    UnitPage unitPage;


    @When("Klik tombol Edit Posisi")
    public void klik_tombol_edit() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pagePosisi = new PagePosisi(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPage = new UnitPage(driver);

        pagePosisi.klikEditPosisi();
        Thread.sleep(1000);
    }

    @And("Mengubah field Nama Posisi menjadi {string}")
    public void edit_field_posisi(String namaBaru) {
        unitPageAddUnit.inputNama(namaBaru);
    }

    @And("Klik tombol Simpan Edit")
    public void klik_tombol_simpan_edit() throws InterruptedException {
        pagePosisi.klikSimpan();
        Thread.sleep(1000);
    }

    @And("Klik tombol Batal Edit")
    public void klik_tombol_batal_edit() throws InterruptedException {
        pagePosisi.klikBatal();
        Thread.sleep(1000);
    }

    @Then("Data posisi berhasil diperbaharui")
    public void data_posisi_berhasil_diperbaharui() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi tidak berhasil diperbaharui");
    }

    @Then("Data posisi tidak berubah")
    public void data_posisi_tidak_berubah() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi berhasil diperbaharui");
    }

    @Then("Tampil pesan error Nama Posisi wajib diisi edit")
    public void tampil_pesan_error_menu_edit() throws InterruptedException {
        Thread.sleep(1000);
        String actualMsg = pagePosisi.getErrorMessageTambah();
        Assert.assertEquals(actualMsg, "Please fill out this field.");
        unitPageAddUnit.clickButtonBatalTambah();
        driver.navigate().refresh();
    }
}

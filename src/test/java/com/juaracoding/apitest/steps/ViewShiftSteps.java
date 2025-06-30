package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewShiftSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    UnitPageUnitShift unitPageUnitShift;

    public ViewShiftSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageUnitShift = new UnitPageUnitShift(driver);
    }

    @When("Klik tombol titik 3 pada salah satu shift view")
    public void tombol3() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
        unitPageUnitShift.buttonShiftAction();
    }

    @When("Klik tombol View")
    public void viewSteps() throws InterruptedException {
        unitPageUnitShift.isViewShift();
        Thread.sleep(1000);
    }

    @And("Pilih nama shift {string}")
    public void pilihNamaShift(String namaShift) throws InterruptedException {
        unitPageAddUnit.pilihUnitShiftDetail(namaShift);
        Thread.sleep(1000);
    }

    @And("Klik tombol Tambah view")
    public void clickButtonTambah() throws InterruptedException {
        unitPageAddUnit.clickButtonTambah();
        Thread.sleep(500);
    }

    @Then("Menampilkan informasi shift")
    public void validasiDataView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Berhasil menambahkan detail shift")
    public void validasiTambahView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isAddViewSucces();
        Assert.assertTrue(isExsist, "Unit Shift Detail baru tidak berhasil ditambahkan");
    }
}

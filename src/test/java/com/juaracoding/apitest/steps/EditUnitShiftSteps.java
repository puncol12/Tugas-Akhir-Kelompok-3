package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUnitShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;

    @When("Klik tombol Edit")
    public void klikButtonEdit() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageUnitShift = new UnitPageUnitShift(driver);
        unitPage = new UnitPage(driver);
        unitPageAddUnit = new UnitPageAddUnit(driver);

        unitPageUnitShift.isEditShift();
        Thread.sleep(1000);
    }

    @When("Klik Simpan")
    public void klikSimpanEdit() throws InterruptedException {
        unitPageUnitShift.isButtonSave();
        Thread.sleep(500);
    }

    @And("Klik Batal")
    public void klikBatalEdit() throws InterruptedException {
        unitPageUnitShift.isButtonCancel();
        Thread.sleep(500);
    }

    @Then("Berhasil mengedit nama shift")
    public void validasiDataEdit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit Shift tidak berhasil teredit");
    }

    @Then("Notifikasi Error muncul dan menampilkan pesan {string}")
    public void notifRequiredInputShiftName(String notif) throws InterruptedException {
        String actualError = unitPageAddUnit.isRequiredName();
        Assert.assertEquals(actualError, notif);
        unitPageAddUnit.clickButtonBatalTambah();
        Thread.sleep(1000);
    }

    @Then("Nama shift tidak berubah")
    public void validasiBatalHapus() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }
}

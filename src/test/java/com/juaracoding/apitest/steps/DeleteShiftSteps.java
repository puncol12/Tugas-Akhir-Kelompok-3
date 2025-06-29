package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteShiftSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    public DeleteShiftSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPageUnitShift = new UnitPageUnitShift(driver);
    }

    @When("Klik tombol Delete")
    public void klikTombolDelete() throws InterruptedException {
        unitPageUnitShift.isDeletedShift();
        Thread.sleep(1000);
    }

    @When("Klik Ya")
    public void klikTombolYa() throws InterruptedException {
        unitPageUnitShift.isAccDeleteShift();
        Thread.sleep(1000);
    }

    @When("Klik Hapus Edit View")
    public void klikTomboSimpan() throws InterruptedException {
        unitPageUnitShift.isDeleteShiftView();
        Thread.sleep(1000);
    }

    @Then("Shift berhasil dihapus")
    public void isSuccesDeleted() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDeleteShiftSucces();
        Assert.assertTrue(isExsist, "Unit Shift tidak berhasil dihapus");
    }

    @Then("Detail Shift berhasil dihapus")
    public void isSuccesDeletedView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }

    @Then("Data unit berhasil dihapus")
    public void isSuccesDeletedUnit() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }

    @Then("Data unit batal dihapus")
    public void isCancelDeletedUnit() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }
}

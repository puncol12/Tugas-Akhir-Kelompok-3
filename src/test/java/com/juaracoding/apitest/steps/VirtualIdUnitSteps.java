package com.juaracoding.apitest.steps;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VirtualIdUnitSteps {

    WebDriver driver;
    UnitPageUnitShift unitPageUnitShift;

    public VirtualIdUnitSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPageUnitShift = new UnitPageUnitShift(driver);
    }

    @When("Klik tombol Atur Virtual ID")
    public void virtualId() throws InterruptedException {
        unitPageUnitShift.isVirtualId();
        Thread.sleep(500);
    }

    @And("Upload file foto yang berukuran kurang dari 2 MB")
    public void uploadFoto() throws InterruptedException {
        String filepath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
                "images", "LOGO PURI.png").toString();
        unitPageUnitShift.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Upload file foto yang berukuran lebih dari 2 MB")
    public void uploadFotoUp2mb() throws InterruptedException {
        String filepath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
                "images", "JERSEY PURI 2.png").toString();
        unitPageUnitShift.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Kosongkan file foto")
    public void uploadFileKosong() throws InterruptedException {
        String filepath =
                Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "images", "")
                        .toString();
        unitPageUnitShift.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Pilih Warna Footer {string}")
    public void colorPicker(String colorCode) throws InterruptedException {
        unitPageUnitShift.buttonColorPicker();
        Thread.sleep(500);
        unitPageUnitShift.selectColor(colorCode);
        Thread.sleep(500);
        unitPageUnitShift.closeColorPicker();
    }

    @And("Klik tombol Atur")
    public void tombolAtur() throws InterruptedException {
        unitPageUnitShift.isButtonAtur();
        Thread.sleep(500);
    }

    @Then("Virtual ID berhasil diatur")
    public void virtualBerhasil() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isAddVirtualIdSucces();
        Assert.assertTrue(isExsist, "Virtual ID tidak berhasil ditambahkan");
    }
  
    @Then("Validasi jika gambar lebih dari 2MB")
    public void validasiVirtual() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertFalse(isExsist, "Tidak ada validasi jika gambar lebh dari 2mb !!!");
    }
    
    @Then("Validasi jika gambar lebih kosong")
    public void validasiVirtualEmpty() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isAddVirtualIdValidation();
        Assert.assertTrue(isExsist, "Virtual ID tidak berhasil ditambahkan");
    }

    @Then("Virtual ID batal diatur")
    public void virtualBatal() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPageUnitShift.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Virtual ID berhasil diatur");
        driver.quit();
    }
}

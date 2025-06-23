package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewUnitSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    @Given("Isi Nama Unit {string}")
    public void inputNameUnit(String nama) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnit.inputNamaUnit(nama);
        Thread.sleep(1000);
    }

    @When("Centang checkbox Lokasi Absen Tetap")
    public void checkTheCheckbok() throws InterruptedException {
        unitPageAddUnit.centangLokasiAbsen();
        Thread.sleep(1000);
    }

    @And("Pilih Unit Kalender {string}")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPageAddUnit.pilihUnitKalender(Kalender);
        Thread.sleep(1000);
    }

    @And("Pilih Aturan Cuti {string}")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPageAddUnit.pilihAturanCuti(Aturan);
        Thread.sleep(1000);
    }

    @And("Cari Overtime Reason {string}")
    public void selectOvertimeReason(String reason) throws InterruptedException {
        unitPageAddUnit.inputOvertimeReason(reason);
        Thread.sleep(1000);
    }

    @And("Isi Maksimal hari pengajuan {string}")
    public void selectPengajuan(String pengajuan) throws InterruptedException {
        unitPageAddUnit.inputMaksHariPengajuan(pengajuan);
        Thread.sleep(1000);
    }

    @And("Pilih bukti lembur {string}")
    public void selectButkiLembur(String lembur) throws InterruptedException {
        unitPageAddUnit.pilihBuktiLembur(lembur);
        Thread.sleep(1000);
    }

    @And("Klik tombol Tambah")
    public void clickButtonTambah() throws InterruptedException {
        unitPageAddUnit.clickButtonTambah();
        Thread.sleep(500);
    }

    @Then("Unit baru berhasil ditambahkan")
    public void unitNewSuccesAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitPageAddUnit.isUnitSuccesAdded();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }
}

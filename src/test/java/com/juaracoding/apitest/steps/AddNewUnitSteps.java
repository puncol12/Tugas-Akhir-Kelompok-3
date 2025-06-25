package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddNewUnitSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;
    
    @Given("Cari Overtime Reason {string}")
    public void selectOvertimeReason(String reason) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitPageAddUnit = new UnitPageAddUnit(driver);
        unitPageAddUnit.inputOvertimeReason(reason);
        Thread.sleep(1000);
    }

    @When("Isi Maksimal hari pengajuan {string}")
    public void selectPengajuan(String pengajuan) throws InterruptedException {
        unitPageAddUnit.inputMaksHariPengajuan(pengajuan);
        Thread.sleep(1000);
    }

    @And("Pilih bukti lembur {string}")
    public void selectButkiLembur(String lembur) throws InterruptedException {
        unitPageAddUnit.pilihBuktiLembur(lembur);
        Thread.sleep(1000);
    }
}

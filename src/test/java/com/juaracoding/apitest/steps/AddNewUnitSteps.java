package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPageAddUnit;

import io.cucumber.java.en.And;

public class AddNewUnitSteps {

    WebDriver driver;
    UnitPageAddUnit unitPageAddUnit;

    public AddNewUnitSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        unitPageAddUnit = new UnitPageAddUnit(driver);
    }
    
    @And("Cari Overtime Reason {string}")
    public void selectOvertimeReason(String reason) throws InterruptedException {
        unitPageAddUnit.inputOvertimeReason(reason);
        Thread.sleep(500);
    }

    @And("Isi Maksimal hari pengajuan {string}")
    public void selectPengajuan(String pengajuan) throws InterruptedException {
        unitPageAddUnit.inputMaksHariPengajuan(pengajuan);
        Thread.sleep(500);
    }

    @And("Pilih bukti lembur {string}")
    public void selectButkiLembur(String lembur) throws InterruptedException {
        unitPageAddUnit.pilihBuktiLembur(lembur);
        Thread.sleep(500);
    }
}

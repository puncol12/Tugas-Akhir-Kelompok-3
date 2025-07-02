package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnitSettingSteps {

    WebDriver driver;
    UnitSettingPage unitSettingPage;
    UnitPage unitPage;

    public UnitSettingSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        unitSettingPage = new UnitSettingPage(driver);
    }

    @Given("User memilih {string}")
    public void userMemilihDepartment(String departmentName) throws InterruptedException {
        unitSettingPage.pilihDepartment(departmentName);
        Thread.sleep(1000);
    }

    @When("Klik ikon Hapus Data pada baris mana pun")
    public void userKlikTombolDelete() throws InterruptedException {
        unitSettingPage.iconDeleteDepartemens();
        Thread.sleep(1000);
    }

    @And("Muncul pop-up Apakah anda ingin menghapus departments yang ingin di hapus")
    public void munculPopupDelete() throws InterruptedException {
        unitSettingPage.isDialogDeleteDisplay();
        Thread.sleep(1000);
    }

    @And("Klik Tombol Tidak")
    public void userKlikTombolTidak() throws InterruptedException {
        unitSettingPage.klikTombolTidak();
        Thread.sleep(1000);
    }

    @And("Klik Tombol Ya")
    public void userKlikTombolYa() throws InterruptedException {
        unitSettingPage.klikTombolYa();
        Thread.sleep(1000);
    }

    @And("Klik toggle button pada kolum selfie Off {string}")
    public void userKlikTombolSelfieOff(String toggleDepartmentName) throws InterruptedException {
        unitSettingPage.clickForToggleDepartment(toggleDepartmentName);
        Thread.sleep(1000);
    }

    @And("Muncul pop-up Sukses dan klik tombol OK untuk ON")
    public void munculPopupSuksesOn() throws InterruptedException {
        unitSettingPage.isDialogSelfieDisplay();
    }

    @And("Klik toggle button pada kolum selfie On {string}")
    public void userKlikTombolOn(String toggleDepartmentName) throws InterruptedException {
        unitSettingPage.clickForToggleDepartment(toggleDepartmentName);
        Thread.sleep(1000);
    }

    @And("Muncul pop-up Sukses dan klik tombol OK untuk OFF") 
    public void munculPopupSuksesOff() throws InterruptedException {
        unitSettingPage.isDialogSelfieDisplay();
    }

    @Then("Validasi tanggal update untuk defect report OFF {string}")
    public void validasiTanggalDefectReportOff(String selfieDepartmentName) throws Exception {
        boolean isDateUpdated = unitSettingPage.validateDateUpdated(selfieDepartmentName);
        
        if (!isDateUpdated) {
            System.out.println("=== DEFECT REPORT ===");
            System.out.println("Category: ERROR");
            System.out.println("Type: Date Auto-Update Failure");
            System.out.println("Department: " + selfieDepartmentName);
            System.out.println("Action: Toggle OFF");
            System.out.println("Expected: Date should update automatically to current date");
            System.out.println("Actual: Date not updated, requires manual refresh");
            System.out.println("Status: DEFECT CONFIRMED");
            Assert.fail("DEFECT: Date not auto-updated after toggle OFF action for department: " + selfieDepartmentName);
        } else {
            System.out.println("PASS: Date updated correctly for department: " + selfieDepartmentName);
        }
    }

    @Then("Validasi tanggal update untuk defect report ON {string}")
    public void validasiTanggalDefectReportOn(String selfieDepartmentName) throws Exception {
        boolean isDateUpdated = unitSettingPage.validateDateUpdated(selfieDepartmentName);

        if (!isDateUpdated) {
            System.out.println("=== DEFECT REPORT ===");
            System.out.println("Category: ERROR");
            System.out.println("Type: Date Auto-Update Failure");
            System.out.println("Department: " + selfieDepartmentName);
            System.out.println("Action: Toggle ON");
            System.out.println("Expected: Date should update automatically to current date");
            System.out.println("Actual: Date not updated, requires manual refresh");
            System.out.println("Status: DEFECT CONFIRMED");

            Assert.fail("DEFECT: Date not auto-updated after toggle ON action for department: "
                    + selfieDepartmentName);
        } else {
            System.out.println(
                    "PASS: Date updated correctly for department: " + selfieDepartmentName);
        }
    }

    @Then("muncul notifikasi {string}")
    public void dataTetapSepertiAwal(String notifikasiDelete) throws InterruptedException {
        Thread.sleep(1000);
        boolean isDataRestored = unitPage.isDataRestored();
        Assert.assertTrue(isDataRestored, "Data tidak terhapus");
    }

    @Then("Data tetap ada di dalam tabel")
    public void dataTetapSepertiAwal() throws InterruptedException {
        Thread.sleep(1000);
        boolean isDataRestored = unitPage.isDataRestored();
        Assert.assertTrue(isDataRestored, "Data tidak kembali seperti awal setelah cancel delete");
    }

    @Then("Data tetap seperti awal {string}")
    public void unitSettingCancelUpdate(String notifSucces) throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Departemens tidak muncul");
    }

    @Then("Muncul notifikasi {string}")
    public void unitNewSuccesAdd(String notifSucces) throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Departemens tidak muncul");
    }

    @Then("Muncul Notifikasi {string}")
    public void unitSetteng_Duplicate(String pesanNotifikasi) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        boolean isExsist = unitSettingPage.failAddDuplicateDepartemens();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }
}

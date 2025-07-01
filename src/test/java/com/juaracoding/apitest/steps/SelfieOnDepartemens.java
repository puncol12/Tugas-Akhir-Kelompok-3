package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitSettingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SelfieOnDepartemens {

    WebDriver driver;
    UnitSettingPage unitSettingPage;

    @Given("Klik toggle button pada kolum selfie On {string}")
    public void userKlikTombolOn(String toggleDepartmentName) throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage = new UnitSettingPage(driver);
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
}
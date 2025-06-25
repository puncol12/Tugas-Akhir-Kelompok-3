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

public class CancelDeleteDepartemensSteps {

    WebDriver driver;
    UnitSettingPage unitSettingPage;
    UnitPage unitPage;

    @Given("Klik ikon Hapus Data pada baris mana pun")
    public void userKlikTombolDelete() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage = new UnitSettingPage(driver);
        unitPage = new UnitPage(driver);
        unitSettingPage.iconDeleteDepartemens();
        Thread.sleep(1000);
    }

    @When("Muncul pop-up Apakah anda ingin menghapus departments yang ingin di hapus")
    public void munculPopupDelete() {
        //unitSettingPage.isDialogDeleteDisplay();
    }    
    
    @And("Klik Tombol Tidak")
    public void userKlikTombolTidak() throws InterruptedException {
    unitSettingPage.klikTombolTidak();
    Thread.sleep(1000);
    }

    @Then("Data tetap ada di dalam tabel")
    public void dataTetapSepertiAwal() throws InterruptedException {
        Thread.sleep(1000);
        boolean isDataRestored = unitPage.isDataRestored();
        Assert.assertTrue(isDataRestored, "Data tidak kembali seperti awal setelah cancel delete");
    }

}

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

public class SuccesDeleteDepartemens {

     WebDriver driver;
    UnitSettingPage unitSettingPage;
    UnitPage unitPage;

    @Given("Klik ikon Hapus Data pada baris")
    public void userKlikTombolDelete() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        unitSettingPage = new UnitSettingPage(driver);
        unitPage = new UnitPage(driver);
        unitSettingPage.iconDeleteDepartemens();
        Thread.sleep(1000);
    }

    @When("Muncul pop-up apakah anda ingin menghapus departments yang ingin di hapus")
    public void munculPopupDelete() throws InterruptedException {
        unitSettingPage.isDialogDeleteDisplay();
        Thread.sleep(1000);
    }    
    
    @And("Klik Tombol Ya")
    public void userKlikTombolYa() throws InterruptedException {
    unitSettingPage.klikTombolYa();
    Thread.sleep(1000);
    }

    @Then("muncul notifikasi {string}")
    public void dataTetapSepertiAwal(String notifikasiDelete) throws InterruptedException {
        Thread.sleep(1000);
        boolean isDataRestored = unitPage.isDataRestored();
        Assert.assertTrue(isDataRestored, "Data tidak terhapus");
    }

}

package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class SubMenuPosisi {

    WebDriver driver;
    PagePosisi pagePosisi;
    UnitPage unitPage;

    @And("Klik submenu Posisi")
    public void klikSubmenuPosisi() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pagePosisi = new PagePosisi(driver);
        unitPage = new UnitPage(driver);

        pagePosisi.bukaSubmenuPosisi();
    }

    @Then("Daftar Posisi ditampilkan")
    public void tampilanDataPosisi() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data Posisi tidak muncul");
    }
}
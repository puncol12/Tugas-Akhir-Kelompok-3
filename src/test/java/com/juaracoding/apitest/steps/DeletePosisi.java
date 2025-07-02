package com.juaracoding.apitest.steps;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class DeletePosisi {
    WebDriver driver;
    PagePosisi pagePosisi;
    UnitPage unitPage;

    @When("Klik tombol Delete Posisi")
    public void Klik_Tombol_Delete() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pagePosisi = new PagePosisi(driver);
        unitPage = new UnitPage(driver);

        pagePosisi.klikTombolDelete();
        Thread.sleep(1000);
    }

    @And("Muncul konfirmasi hapus posisi atau tidak")
    public void konfirmasi_Hapus_posisi() throws InterruptedException {
        pagePosisi.halamanKonfirmasiHapus();
        Thread.sleep(1000);
    }

    @And("Klik tombol Ya")
    public void klik_Tombol_Ya() throws InterruptedException {
        pagePosisi.konfirmasiHapusYa();
        Thread.sleep(1000);
    }

    @And("Klik tombol Tidak")
    public void klik_Tombol_Tidak() throws InterruptedException {
        pagePosisi.konfirmasiHapusTidak();
        Thread.sleep(1000);
    }

    @Then("Data posisi berhasil dihapus")
    public void data_Posisi_Berhasil_Dihapus() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi tidak berhasil dihapus");
    }

    @Then("Data posisi tidak terhapus")
    public void data_Posisi_Tidak_Dihapus() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data posisi berhasil dihapus");
    }
}

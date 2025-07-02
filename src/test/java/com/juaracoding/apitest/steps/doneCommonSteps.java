package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitSettingPage;
import com.juaracoding.apitest.pages.UserPage;
import com.juaracoding.apitest.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class doneCommonSteps {

    WebDriver driver;
    LoginPage loginPage;
    UnitPage unitPage;
    UserPage userPage;
    PagePosisi pagePosisi;
    UnitSettingPage unitSettingPage;

    public doneCommonSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magang.dikahadir.com/authentication/login");

        loginPage = new LoginPage(driver);
        unitPage = new UnitPage(driver);
        userPage = new UserPage(driver);
        pagePosisi = new PagePosisi(driver);
        unitSettingPage = new UnitSettingPage(driver);
    }

    @Given("Login dengan user valid")
    public void userLoginDenganKredensialValid() throws InterruptedException {
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");
        loginPage.login(email, password);
    }

    @When("Klik menu Management")
    public void userKlikMenuManagement() throws InterruptedException {
        unitPage.bukaMenuManagement();
        Thread.sleep(500);
    }

    @And("Klik submenu Unit")
    public void userKlikSubmenuUnit() throws InterruptedException {
        unitPage.bukaSubmenuUnit();
        Thread.sleep(500);
    }

    @And("Klik submenu Unit Setting")
    public void userKlikSubmenuUnitSetting() throws InterruptedException {
        unitSettingPage.bukaSubmenuUnitSetting();
        Thread.sleep(500);
    }

    @And("Klik submenu User")
    public void userKlikSubmenuUser() throws InterruptedException {
        userPage.submenuUser();
        Thread.sleep(500);
    }

    @And("Klik tombol titik 3 pada salah satu shift")
    public void shiftActionStep() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        unitPage.buttonShiftAction();
    }

    @And("Klik tombol titik 3 pada salah satu data posisi")
    public void klik_tombol_titik_3() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        pagePosisi.klikTombolTitik3();
    }

    @And("Klik tombol titik 3 pada salah satu unit")
    public void unitActionStep() throws InterruptedException {
        driver.navigate().refresh();
        unitPage.bukaAction();
        Thread.sleep(500);
    }

    @And("Klik tombol Tambahkan")
    public void clickButtonTambahkan() throws InterruptedException {
        unitPage.clickButtonTambahkan();
        Thread.sleep(500);
    }

    @And("Isi Nama Unit {string}")
    public void inputNameUnit(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Centang checkbox Lokasi Absen Tetap")
    public void checkTheCheckbok() throws InterruptedException {
        unitPage.centangLokasiAbsen();
        Thread.sleep(500);
    }

    @And("Pilih Unit Kalender {string}")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPage.pilihUnitKalender(Kalender);
        Thread.sleep(500);
    }

    @And("Pilih Aturan Cuti {string}")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPage.pilihAturanCuti(Aturan);
        Thread.sleep(500);
    }

    @And("Klik tombol Tambah")
    public void clickButtonTambah() throws InterruptedException {
        unitPage.clickButtonTambah();
        Thread.sleep(500);
    }

    @And("Klik tombol Batal")
    public void clickButtonBatal() throws InterruptedException {
        unitPage.clickButtonBatalTambah();
        Thread.sleep(500);
    }

    @And("Klik Tombol Drop Down")
    public void userKlikTombolDropDown() throws InterruptedException {
        unitSettingPage.klikTombolDropDown();
        Thread.sleep(500);
    }

    @And("Masukkan nama shift {string}")
    public void inputNameShift(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(1000);
    }

    @Then("Unit baru berhasil ditambahkan")
    public void unitNewSuccesAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isUnitSuccesAdded();
        Assert.assertTrue(isExsist, "Unit baru tidak berhasil ditambahkan");
    }

    @Then("Notifikasi error muncul")
    public void unitNewFailAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isUnitSuccesAdded();
        Assert.assertFalse(isExsist,
                "Unit baru justru berhasil ditambahkan, padahal seharusnya gagal.");
    }
}

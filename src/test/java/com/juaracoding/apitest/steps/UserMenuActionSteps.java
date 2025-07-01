package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageSearch;
import com.juaracoding.apitest.pages.UserPage;
import com.juaracoding.apitest.utils.ExportHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UserMenuActionSteps {

    WebDriver driver;
    UnitPage unitPage;
    UserPage userPage;
    UnitPageSearch unitPageSearch;

    String keywordSearch = "";

    public UserMenuActionSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        userPage = new UserPage(driver);
        unitPageSearch = new UnitPageSearch(driver);
    }

    @And("Pilih Pencarian Nama")
    public void pencarianByNama() throws InterruptedException {
        userPage.btnPencarianPilihan();
        userPage.btnPencarianNama();
        Thread.sleep(1000);
    }

    @And("Masukan Pencarian {string}")
    public void inputPencarian(String keyword) throws InterruptedException {
        unitPageSearch.searchUnit(keyword);
        keywordSearch = keyword;
        Thread.sleep(1000);
    }

    @And("Pilih Pencarian NIK")
    public void pencarianByNik() throws InterruptedException {
        userPage.btnPencarianPilihan();
        userPage.btnPencarianNik();
        Thread.sleep(1000);
    }

    @And("Klik Export")
    public void clickExport() throws InterruptedException {
        userPage.btnExport();
        Thread.sleep(1000);
    }

    @And("Klik Filter")
    public void clickFilter() throws InterruptedException {
        userPage.btnFilter();
        Thread.sleep(1000);
    }

    @And("Pilih unit {string}")
    public void filterUnit1(String Unit) throws InterruptedException {
        userPage.filterUnit(Unit);
        Thread.sleep(2000);
    }

    @And("Pilih Job Level {string}")
    public void filterJob(String Job) throws InterruptedException {
        userPage.filterJobLevel(Job);
        Thread.sleep(2000);
    }

    @And("Pilih Tipe Karyawan {string}")
    public void filterKarya(String karyawan) throws InterruptedException {
        userPage.filterKaryawan(karyawan);
        Thread.sleep(2000);
    }

    @And("Pilih Posisi Kerja {string}")
    public void filterPosisi(String posisi) throws InterruptedException {
        userPage.filterPosisi(posisi);
        Thread.sleep(2000);
    }

    @And("Pilih Lokasi Kerja {string}")
    public void filterLokasi(String lokasi) throws InterruptedException {
        userPage.filterLokasiKerja(lokasi);
        Thread.sleep(2000);
    }

    @And("Pilih Status {string}")
    public void filterStatus1(String status) throws InterruptedException {
        userPage.filterStatus(status);
        Thread.sleep(2000);
    }

    @And("Klik Terapkan")
    public void clickTerapkan() throws InterruptedException {
        userPage.btnTerapkan();
        Thread.sleep(5000);
    }

    @And("Klik Export pakai kombinasi API Defult")
    public void exportDenganApiLangsung() throws InterruptedException {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String fileName = "export-users-defulft-" + timestamp + ".xlsx";
        Thread.sleep(1000);

        ExportHelper.downloadExportFile(downloadPath, fileName, null, null);
    }

    @And("Klik Export pakai kombinasi API Nama")
    public void exportDenganApiNama() throws InterruptedException {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String fileName = "export-users-" + keywordSearch + "-" + timestamp + ".xlsx";
        Thread.sleep(1000);

        ExportHelper.downloadExportFile(downloadPath, fileName, keywordSearch, null);
    }

    @And("Klik Export pakai kombinasi API NIK")
    public void exportDenganApiNik() throws InterruptedException {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String fileName = "export-users-" + keywordSearch + "-" + timestamp + ".xlsx";
        Thread.sleep(1000);

        ExportHelper.downloadExportFile(downloadPath, fileName, null, keywordSearch);
    }

    @Then("Menampilkan data yang dicari berdasarkan Status yang dipilih")
    public void dataSesuai() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data User tidak ditemukan");
    }

    @Then("Menampilkan data yang dicari")
    public void dataFilterSesuai() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data User tidak ditemukan");
        driver.navigate().refresh();
    }
}

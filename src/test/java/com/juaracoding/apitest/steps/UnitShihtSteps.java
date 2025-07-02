package com.juaracoding.apitest.steps;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UnitPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnitShihtSteps {

    WebDriver driver;
    UnitPage unitPage;

    public UnitShihtSteps() {
        driver = DriverSingleton.driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
    }

    @When("Klik tombol Edit")
    public void klikButtonEdit() throws InterruptedException {
        unitPage.isEditShift();
        Thread.sleep(500);
    }

    @And("Klik Simpan")
    public void klikSimpanEdit() throws InterruptedException {
        unitPage.isButtonSave();
        Thread.sleep(500);
    }

    @And("Klik Batal")
    public void klikBatalEdit() throws InterruptedException {
        unitPage.isButtonCancel();
        Thread.sleep(500);
    }

    @And("Kosongkan checkbox Lokasi Absen Tetap")
    public void emptyCheckbox() throws InterruptedException {
        Thread.sleep(500);
    }

    @And("Cari Overtime Reason {string}")
    public void selectOvertimeReason(String reason) throws InterruptedException {
        unitPage.inputOvertimeReason(reason);
        Thread.sleep(500);
    }

    @And("Isi Maksimal hari pengajuan {string}")
    public void selectPengajuan(String pengajuan) throws InterruptedException {
        unitPage.inputMaksHariPengajuan(pengajuan);
        Thread.sleep(500);
    }

    @And("Pilih bukti lembur {string}")
    public void selectButkiLembur(String lembur) throws InterruptedException {
        unitPage.pilihBuktiLembur(lembur);
        Thread.sleep(500);
    }

    @And("Kosongkan Unit Kalender")
    public void calendarEmpty() throws InterruptedException {
        Thread.sleep(500);
    }

    @And("Klik tombol Shift")
    public void clickShiftStep() throws InterruptedException {
        unitPage.action01();
        Thread.sleep(1000);
    }

    @And("Klik tombol titik 3 pada salah satu shift view")
    public void tombol3() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
        unitPage.buttonShiftAction();
    }

    @And("Klik tombol View")
    public void viewSteps() throws InterruptedException {
        unitPage.isViewShift();
        Thread.sleep(1000);
    }

    @And("Pilih nama shift {string}")
    public void pilihNamaShift(String namaShift) throws InterruptedException {
        unitPage.pilihUnitShiftDetail(namaShift);
        Thread.sleep(1000);
    }

    @And("Klik tombol Tambah view")
    public void clickButtonTambah() throws InterruptedException {
        unitPage.clickButtonTambah();
        Thread.sleep(500);
    }


    @And("Klik tombol Atur Virtual ID")
    public void virtualId() throws InterruptedException {
        unitPage.isVirtualId();
        Thread.sleep(500);
    }

    @And("Upload file foto yang berukuran kurang dari 2 MB")
    public void uploadFoto() throws InterruptedException {
        String filepath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
                "images", "LOGO PURI.png").toString();
        unitPage.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Upload file foto yang berukuran lebih dari 2 MB")
    public void uploadFotoUp2mb() throws InterruptedException {
        String filepath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
                "images", "JERSEY PURI 2.png").toString();
        unitPage.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Kosongkan file foto")
    public void uploadFileKosong() throws InterruptedException {
        String filepath =
                Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "images", "")
                        .toString();
        unitPage.inputUploadFoto(filepath);
        Thread.sleep(500);
    }

    @And("Pilih Warna Footer {string}")
    public void colorPicker(String colorCode) throws InterruptedException {
        unitPage.buttonColorPicker();
        Thread.sleep(500);
        unitPage.selectColor(colorCode);
        Thread.sleep(500);
        unitPage.closeColorPicker();
    }

    @And("Klik tombol Atur")
    public void tombolAtur() throws InterruptedException {
        unitPage.isButtonAtur();
        Thread.sleep(500);
    }

    @And("Klik tombol Delete")
    public void klikTombolDelete() throws InterruptedException {
        unitPage.isDeletedShift();
        Thread.sleep(1000);
    }

    @And("Klik Ya")
    public void klikTombolYa() throws InterruptedException {
        unitPage.isAccDeleteShift();
        Thread.sleep(1000);
    }

    @And("Klik Hapus Edit View")
    public void klikTomboSimpan() throws InterruptedException {
        unitPage.isDeleteShiftView();
        Thread.sleep(1000);
    }

    @And("Klik tombol Delete1")
    public void klikTombolDelete1() throws InterruptedException {
        unitPage.isDeletedShift();
        Thread.sleep(1000);
    }

    @And("Klik Tidak")
    public void deleteKlikTidak() throws InterruptedException {
        unitPage.isCancelDeleteShift();
        Thread.sleep(1000);
    }

    @And("Klik Batal Edit View")
    public void viewDeleteKlikTidak() throws InterruptedException {
        unitPage.isCancelDeleteShift();
        Thread.sleep(1000);
    }

    @And("Kosongkan nama shift {string}")
    public void inputShiftNameEmpty(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Kosongkan Aturan Cuti")
    public void leaveRulesEmpty() throws InterruptedException {
        Thread.sleep(500);
    }

    @And("Kosongkan Nama Unit {string}")
    public void inputNameEmpty(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Isi Nama Unit {string} untuk batal")
    public void inputNameUnit(String nama) throws InterruptedException {
        unitPage.inputNama(nama);
        Thread.sleep(500);
    }

    @And("Centang checkbox Lokasi Absen Tetap untuk batal")
    public void checkTheCheckbok() throws InterruptedException {
        unitPage.centangLokasiAbsen();
        Thread.sleep(500);
    }

    @And("Pilih Unit Kalender {string} untuk batal")
    public void selectUnitCalender(String Kalender) throws InterruptedException {
        unitPage.pilihUnitKalender(Kalender);
        Thread.sleep(500);
    }

    @And("Pilih Aturan Cuti {string} untuk batal")
    public void selectLeaveRules(String Aturan) throws InterruptedException {
        unitPage.pilihAturanCuti(Aturan);
        Thread.sleep(500);
    }

    @Then("Unit baru batal ditambahkan")
    public void unitNewCancelAdd() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Form tidak ditutup, pembatalan gagal");
    }

    @Then("Batal menambahkan shift")
    public void unitNewShiftCancelAdd() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Form tidak ditutup, pembatalan gagal");
    }

    @Then("Notifikasi error muncul menampilkan pesan {string}")
    public void notifRequiredInputName(String notif) throws InterruptedException {
        String actualError = unitPage.isRequiredName();
        Assert.assertEquals(actualError, notif);
        Thread.sleep(1000);
        unitPage.clickButtonBatalTambah();
    }

    @Then("Notifikasi Error muncul")
    public void unitNewSuccesAdd() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isUnitSuccesAdded();
        Assert.assertFalse(isExsist,
                "Unit baru justru berhasil ditambahkan, padahal seharusnya gagal.");
    }

    @Then("Shift batal dihapus")
    public void validasiBatalHapusShift() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Shift batal dihapus view")
    public void validasiBatalHapusViewd() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Shift berhasil dihapus")
    public void isSuccesDeleted() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDeleteShiftSucces();
        Assert.assertTrue(isExsist, "Unit Shift tidak berhasil dihapus");
    }

    @Then("Detail Shift berhasil dihapus")
    public void isSuccesDeletedView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }

    @Then("Data unit berhasil dihapus")
    public void isSuccesDeletedUnit() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }

    @Then("Data unit batal dihapus")
    public void isCancelDeletedUnit() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak terhapus");
    }

    @Then("Virtual ID berhasil diatur")
    public void virtualBerhasil() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isAddVirtualIdSucces();
        Assert.assertTrue(isExsist, "Virtual ID tidak berhasil ditambahkan");
    }

    @Then("Validasi jika gambar lebih dari 2MB")
    public void validasiVirtual() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertFalse(isExsist, "Tidak ada validasi jika gambar lebh dari 2mb !!!");
    }

    @Then("Validasi jika gambar lebih kosong")
    public void validasiVirtualEmpty() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isAddVirtualIdValidation();
        Assert.assertTrue(isExsist, "Virtual ID tidak berhasil ditambahkan");
    }

    @Then("Virtual ID batal diatur")
    public void virtualBatal() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Virtual ID berhasil diatur");
    }


    @Then("Menampilkan informasi shift")
    public void validasiDataView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Berhasil menambahkan detail shift")
    public void validasiTambahView() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isAddViewSucces();
        Assert.assertTrue(isExsist, "Unit Shift Detail baru tidak berhasil ditambahkan");
    }

    @Then("Berhasil mengedit nama shift")
    public void validasiDataEdit() {
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit Shift tidak berhasil teredit");
    }

    @Then("Data unit berhasil diedit  atau berubah")
    public void validasiDataEditUnit() {
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data unit Shift tidak berhasil teredit");
    }

    @Then("Notifikasi Error muncul dan menampilkan pesan {string}")
    public void notifRequiredInputShiftName(String notif) throws InterruptedException {
        String actualError = unitPage.isRequiredName();
        Assert.assertEquals(actualError, notif);
        unitPage.clickButtonBatalTambah();
        Thread.sleep(500);
    }

    @Then("Nama shift tidak berubah")
    public void validasiBatalHapus() throws InterruptedException {
        Thread.sleep(500);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Masuk ke menu shift")
    public void validasiDataShift() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataShiftRestored();
        Assert.assertTrue(isExsist, "Data halaman tidak ditemukan");
    }

    @Then("Berhasil menambahkan shift")
    public void isShiftSuccesAdded() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isShiftSuccesAdded();
        Assert.assertTrue(isExsist, "Unit Shift baru tidak berhasil ditambahkan");
    }
}

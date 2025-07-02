package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

    WebDriver driver;
    UnitPage unitPage;
    UserPage userPage;
    PagePosisi pagePosisi;

    public UserSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        unitPage = new UnitPage(driver);
        userPage = new UserPage(driver);
        pagePosisi = new PagePosisi(driver);
    }

    @Given("Klik Tombol Acvite yang aktif")
    public void klikTombolActiveProjectAktif() throws InterruptedException {
        userPage.clickToggleUser();
        Thread.sleep(1000);
    }

    @When("Klik Tombol Status Active yang tidak aktif")
    public void klikTombolActive_UserTidakAktif() throws InterruptedException {
        userPage.clickToggleUser();
        Thread.sleep(1000);
    }

    @And("Pilih Pencarian Nama")
    public void pencarianByNama() throws InterruptedException {
        userPage.btnPencarianPilihan();
        userPage.btnPencarianNama();
        Thread.sleep(1000);
    }

    @And("Masukan Pencarian {string}")
    public void inputPencarian(String keyword) throws InterruptedException {
        unitPage.searchUnit(keyword);
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


    @And("Masukkan data untuk pencarian {string}")
    public void masukkanDataUntukPencarian(String data) throws InterruptedException {
        userPage.inputSearchData(data);
        Thread.sleep(500);
        userPage.btnSearch();
        Thread.sleep(5000);
    }

    @And("Klik Tombol User Project yang tidak aktif")
    public void klikTombolUserProjectTidakAktif() throws InterruptedException {
        userPage.clickToggleUserProject();
        Thread.sleep(1000);
    }

    @And("Klik Tombol User Project yang aktif")
    public void klikTombolUserProjectAktif() throws InterruptedException {
        userPage.clickToggleUserProject();
        Thread.sleep(1000);
    }

    @And("Klik tombol Lihat Sisa Cuti")
    public void lihat_sisa_cuti() {
        userPage.lihatSisaCuti();
    }

    @And("Klik icon Hapus")
    public void delete_Image() throws InterruptedException {
        userPage.hapusGambar();
        Thread.sleep(2000);
    }

    @And("Isi NIK {string}")
    public void input_NIK(String nik) throws InterruptedException {
        userPage.inputNik(nik);
        Thread.sleep(500);
    }

    @And("Isi Nama Karyawan {string}")
    public void input_Nama(String name) throws InterruptedException {
        userPage.inputNama(name);
        Thread.sleep(500);
    }

    @And("Isi Email {string}")
    public void input_Email(String email) throws InterruptedException {
        userPage.inputEmail(email);
        Thread.sleep(500);
    }

    @And("Pilih Devisi {string}")
    public void input_Divisi(String divisi) throws InterruptedException {
        userPage.inputDivisi(divisi);
        Thread.sleep(500);
    }

    @And("Pilih Unit {string}")
    public void input_Unit(String unit) throws InterruptedException {
        userPage.inputUnit(unit);
        Thread.sleep(500);
    }

    @And("Pilih Tipe Kontrak {string}")
    public void input_Kontrak(String tipeKontrak) throws InterruptedException {
        userPage.inputKontrak(tipeKontrak);
        Thread.sleep(500);
    }

    @And("Pilih Edit Posisi Kerja {string}")
    public void input_Posisi(String posisi) throws InterruptedException {
        userPage.inputPosisi(posisi);
        Thread.sleep(500);
    }

    @And("Pilih Jabatan {string}")
    public void input_Jabatan(String jabtan) throws InterruptedException {
        userPage.inputJabatan(jabtan);
        Thread.sleep(500);
    }

    @And("Pilih Edit Lokasi Kerja {string}")
    public void input_Edit_Lokasi_Kerja(String lokasi) throws InterruptedException {
        userPage.inputLokasiKerja(lokasi);
        Thread.sleep(500);
    }

    @And("Pilih Tipe Shift {string}")
    public void input_Tipe_Shift(String shift) throws InterruptedException {
        userPage.inputShift(shift);
        Thread.sleep(500);
    }

    @And("Pilih Jadwal Kerja {string}")
    public void input_Jadwal_Kerja(String jadwal) throws InterruptedException {
        userPage.inputJadwal(jadwal);
        Thread.sleep(500);
    }

    @And("Pilih Selfie {string}")
    public void input_Selfie(String selfie) throws InterruptedException {
        userPage.inputSelfie(selfie);
        Thread.sleep(500);
    }

    @And("Isi Jumlah Cuti {int}")
    public void input_Jumlah_Cuti(int cuti) throws InterruptedException {
        userPage.inputJumlahCuti(cuti);
        Thread.sleep(500);
    }

    @And("Klik Submit")
    public void click_Submit() throws InterruptedException {
        userPage.buttonSubmit();
        Thread.sleep(1000);
    }

    @And("Klik Submit Edit")
    public void click_Submit_Edit() throws InterruptedException {
        userPage.buttonSubmit();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }

    @And("Klik tombol Tutup")
    public void click_Tutup() {
        userPage.buttonTutup();
    }

    @Then("Data Berhasil diubah dan aktifkan tracking dan projek akan menyala")
    public void validasi_Edit_User() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = unitPage.isDataRestored();
        Assert.assertTrue(isExsist, "Data User tidak berhasil di Edit");
    }

    @Then("Foto tidak Terupload")
    public void validasi_foto() throws InterruptedException {
        Thread.sleep(1000);
        boolean isExsist = userPage.isValidateImage();
        Assert.assertFalse(isExsist, "Foto tidak terupload, harusnya ada validasi");
    }

    @Then("Tampil pesan error wajib diisi")
    public void validasi_Input_Edit() throws InterruptedException {
        Thread.sleep(1000);
        String actualMsg = pagePosisi.getErrorMessageTambahNik();
        Assert.assertEquals(actualMsg, "Please fill out this field.");
    }

    @Then("Menampilkan Sisa Cuti")
    public void modal_active() {
        boolean isExist = userPage.isModalActive();
        Assert.assertTrue(isExist, "Modal tidak Terbuaka");
    }

    @Then("Muncul Notifikasi project dinonaktifkan")
    public void munculNotifikasiProjectDinonaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationActiveProjectNonActive =
                userPage.isNotificationActiveProjectNonActive();
        Assert.assertTrue(isNotificationActiveProjectNonActive,
                "Notifikasi project dinonaktifkan tidak muncul");
    }

    @Then("Muncul Notifikasi project diaktifkan")
    public void munculNotifikasiProjectDiaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationDisplayedProjectActive =
                userPage.isNotificationDisplayedProjectActive();
        Assert.assertTrue(isNotificationDisplayedProjectActive,
                "Notifikasi project diaktifkan tidak muncul");
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

    @Then("Muncul Notifikasi user dinonaktifkan")
    public void munculNotifikasiUserDinonaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationActiveNonActive = userPage.isNotificationActiveNonActive();
        Assert.assertTrue(isNotificationActiveNonActive,
                "Notifikasi user dinonaktifkan tidak muncul");
    }

    @Then("Muncul Notifikasi user diaktifkan")
    public void munculNotifikasiUserDiaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationDisplayedActive = userPage.isNotificationDisplayedActive();
        Assert.assertTrue(isNotificationDisplayedActive, "Notifikasi user diaktifkan tidak muncul");
    }
}

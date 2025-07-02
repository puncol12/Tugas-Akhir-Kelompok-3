package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.apitest.utils.BrowserUtility;

public class UserPage {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[contains(., 'User')])[1]")
    WebElement submenuUser;

    @FindBy(xpath = "//div[@role='combobox' and contains(.,'Nama')]")
    WebElement buttonPilihanPencarian;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Nik']")
    WebElement buttonPencarianNik;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Nama']")
    WebElement buttonPencarianNama;

    @FindBy(xpath = "//button[normalize-space(text())='Export']")
    WebElement buttonExport;

    @FindBy(xpath = "//button[normalize-space(text())='Terapkan']")
    WebElement buttonTerapkan;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-grid-lg-1')]//button[.//* [contains(@class,'feather-filter')]]")
    WebElement buttonFilter;

    @FindBy(xpath = "//div[@id='mui-component-select-job_departement_id' and @role='combobox']")
    WebElement dropdownFilterUnit;

    @FindBy(xpath = "//div[@id='mui-component-select-job_level_id' and @role='combobox']")
    WebElement dropdownFilterJobLevel;

    @FindBy(xpath = "//div[@id='mui-component-select-employee_type_id' and @role='combobox']")
    WebElement dropdownFilterTipeKaryawan;

    @FindBy(xpath = "//div[@id='mui-component-select-job_position_id' and @role='combobox']")
    WebElement dropdownFilterPosisiKerja;

    @FindBy(xpath = "//div[@id='mui-component-select-location_point_id' and @role='combobox']")
    WebElement dropdownFilterLokasiKerja;

    @FindBy(xpath = "//div[@id='demo-select-small' and @role='combobox']")
    WebElement dropdownFilterStatus;

    @FindBy(xpath = "//button[@aria-label='Hapus']")
    WebElement iconHapus;

    @FindBy(xpath = "//input[@id='nik']")
    WebElement inputNik;

    @FindBy(xpath = "//input[@id='fullname']")
    WebElement inputFullname;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='divisi' and @role='combobox']")
    WebElement dropdownDivisi;

    @FindBy(xpath = "//input[@id='unit' and @role='combobox']")
    WebElement dropdownUnit;

    @FindBy(xpath = "//input[@id='tipe-kontrak' and @role='combobox']")
    WebElement dropdownTypeKontrak;

    @FindBy(xpath = "//input[@id='posisi-kerja' and @role='combobox']")
    WebElement dropdownPosisiKerja;

    @FindBy(xpath = "//input[@id='jabatan' and @role='combobox']")
    WebElement dropdownJabatan;

    @FindBy(xpath = "//input[@id='atasan' and @role='combobox']")
    WebElement dropdownAtasan;

    @FindBy(xpath = "//input[@id='atasan-v3' and @role='combobox']")
    WebElement dropdownAtasanV3;

    @FindBy(xpath = "//input[@id='lokasi-kerja' and @role='combobox']")
    WebElement dropdownLoksaiKerja;

    @FindBy(xpath = "//div[@id='tipe-shift' and @role='combobox']")
    WebElement dropdownTypeShift;

    @FindBy(xpath = "//input[@id='jadwal-kerja' and @role='combobox']")
    WebElement dropdownJadwal;

    @FindBy(xpath = "//div[@id='required_selfie' and @role='combobox']")
    WebElement dropdownSelfie;

    @FindBy(xpath = "//input[@id='jumlah-cuti' and @type='number']")
    WebElement inputJumlahCuti;
    // Tambahan
    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//input[@id='search']")
    WebElement inputSearch;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement buttonSearch;

    // XPath Toggle User Project
    @FindBy(xpath = "(//span[contains(@class, 'MuiSwitch-root')])[2]")
    WebElement toggleUserProject;

    // Xpath Toggle Active
    @FindBy(xpath = "(//span[contains(@class, 'MuiSwitch-root')])[1]")
    WebElement toggleActive;

    // Xpath Notification
    @FindBy(xpath = "//div[normalize-space(text())='Project diaktifkan']")
    WebElement projectActiveMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Project dinonaktifkan']")
    WebElement projectNonActiveMessage;

    @FindBy(xpath = "//div[normalize-space(text())='User diaktifkan']")
    WebElement activeMessage;

    @FindBy(xpath = "//div[normalize-space(text())='User dinonaktifkan']")
    WebElement nonActiveMessage;

    @FindBy(xpath = "//button[normalize-space(text())='Submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[normalize-space(text())='Foto tidak boleh kosong']")
    WebElement notifValidasiFoto;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Lihat Sisa Cuti']")
    WebElement btnLihatCuti;

    @FindBy(xpath = "//div[@role='dialog' and @aria-describedby='alert-dialog-slide-description']")
    WebElement modalSisaCuti;

    @FindBy(xpath = "//button[normalize-space(text())='Tutup']")
    WebElement btnTutup;

    public void submenuUser() {
        wait.until(ExpectedConditions.elementToBeClickable(submenuUser)).click();
    }

    public void btnPencarianNama() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPencarianNama)).click();
    }

    public void btnPencarianNik() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPencarianNik)).click();
    }

    public void btnPencarianPilihan() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPilihanPencarian)).click();
    }

    public void btnFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonFilter)).click();
    }

    public void btnTerapkan() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonTerapkan)).click();
    }

    public void btnExport() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonExport)).click();
    }

    // Tambahan
    public void btnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit)).click();
    }

    public void inputSearchData(String data) {
        wait.until(ExpectedConditions.visibilityOf(inputSearch)).clear();
        inputSearch.sendKeys(data);
    }

    public void btnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
    }

    // Method toggle User Project - Satu method untuk aktif/nonaktif
    public void clickToggleUserProject() {
        wait.until(ExpectedConditions.elementToBeClickable(toggleUserProject)).click();
    }

    public void clickToggleUser() {
        wait.until(ExpectedConditions.elementToBeClickable(toggleActive)).click();
    }

    // Method Notification
    public boolean isNotificationDisplayedProjectActive() {
        return wait.until(ExpectedConditions.visibilityOf(projectActiveMessage)).isDisplayed();
    }

    public boolean isNotificationActiveProjectNonActive() {
        return wait.until(ExpectedConditions.visibilityOf(projectNonActiveMessage)).isDisplayed();
    }

    public boolean isNotificationDisplayedActive() {
        return wait.until(ExpectedConditions.visibilityOf(activeMessage)).isDisplayed();
    }

    public boolean isNotificationActiveNonActive() {
        return wait.until(ExpectedConditions.visibilityOf(nonActiveMessage)).isDisplayed();
    }

    public void hapusGambar() {
        wait.until(ExpectedConditions.elementToBeClickable(iconHapus)).click();
    }

    public void inputNik(String nik) {
        if (BrowserUtility.clearValueName(inputNik, driver)) {
            inputNik.sendKeys(nik);
        }
    }

    public void inputNama(String nama) {
        if (BrowserUtility.clearValueName(inputFullname, driver)) {
            inputFullname.sendKeys(nama);
        }
    }

    public void inputEmail(String email) {
        if (BrowserUtility.clearValueName(inputEmail, driver)) {
            inputEmail.sendKeys(email);
        }
    }

    public void inputDivisi(String divisi) {
        if (BrowserUtility.clearValueName(dropdownDivisi, driver)) {
            dropdownDivisi.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + divisi + "']")));
            opsi.click();
        }
    }

    public void inputUnit(String unit) {
        if (BrowserUtility.clearValueName(dropdownUnit, driver)) {
            dropdownUnit.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + unit + "']")));
            opsi.click();
        }
    }

    public void inputKontrak(String kontrak) {
        if (BrowserUtility.clearValueName(dropdownTypeKontrak, driver)) {
            dropdownTypeKontrak.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + kontrak + "']")));
            opsi.click();
        }
    }

    public void inputPosisi(String posisi) {
        if (BrowserUtility.clearValueName(dropdownPosisiKerja, driver)) {
            dropdownPosisiKerja.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + posisi + "']")));
            opsi.click();
        }
    }

    public void inputJabatan(String jabatan) {
        if (BrowserUtility.clearValueName(dropdownJabatan, driver)) {
            dropdownJabatan.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + jabatan + "']")));
            opsi.click();
        }
    }

    public void inputAtasan(String atasan) {
        if (BrowserUtility.clearValueName(dropdownAtasan, driver)) {
            dropdownAtasan.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + atasan + "']")));
            opsi.click();
        }
    }

    public void inputAtasanV3(String atasanV3) {
        if (BrowserUtility.clearValueName(dropdownAtasanV3, driver)) {
            dropdownAtasanV3.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + atasanV3 + "']")));
            opsi.click();
        }
    }

    public void inputLokasiKerja(String LokasiKerja) {
        if (BrowserUtility.clearValueName(dropdownLoksaiKerja, driver)) {
            dropdownLoksaiKerja.click();
            WebElement opsi = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[normalize-space()='" + LokasiKerja + "']")));
            opsi.click();
        }
    }

    public void inputShift(String shift) {
        if (BrowserUtility.clearValueName(dropdownTypeShift, driver)) {
            dropdownTypeShift.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + shift + "']")));
            opsi.click();
        }
    }

    public void inputJadwal(String jadwal) {
        if (BrowserUtility.clearValueName(dropdownJadwal, driver)) {
            dropdownJadwal.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + jadwal + "']")));
            opsi.click();
        }
    }

    public void inputSelfie(String selfie) {
        if (BrowserUtility.clearValueName(dropdownSelfie, driver)) {
            dropdownSelfie.click();
            WebElement opsi = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//li[normalize-space()='" + selfie + "']")));
            opsi.click();
        }
    }

    public void inputJumlahCuti(int cuti) {
        if (BrowserUtility.clearValueName(inputJumlahCuti, driver)) {
            inputJumlahCuti.sendKeys(String.valueOf(cuti));
        }
    }

    public void filterUnit(String namaUnit) {
        dropdownFilterUnit.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaUnit + "']")));
        opsi.click();
    }

    public void filterJobLevel(String namaJobLevel) {
        dropdownFilterJobLevel.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaJobLevel + "']")));
        opsi.click();
    }

    public void filterKaryawan(String namaKaryawan) {
        dropdownFilterTipeKaryawan.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaKaryawan + "']")));
        opsi.click();
    }

    public void filterPosisi(String namaPosisi) {
        dropdownFilterPosisiKerja.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaPosisi + "']")));
        opsi.click();
    }

    public void filterLokasiKerja(String namaLokasi) {
        dropdownFilterLokasiKerja.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaLokasi + "']")));
        opsi.click();
    }

    public void filterStatus(String status) {
        dropdownFilterStatus.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + status + "']")));
        opsi.click();
    }

    public void buttonSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
    }

    public boolean isValidateImage() {
        return wait.until(ExpectedConditions.visibilityOf(notifValidasiFoto)).isDisplayed();
    }

    public void lihatSisaCuti() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLihatCuti)).click();
    }

    public boolean isModalActive() {
        return wait.until(ExpectedConditions.visibilityOf(modalSisaCuti)).isDisplayed();
    }

    public void buttonTutup() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTutup)).click();
    }
}

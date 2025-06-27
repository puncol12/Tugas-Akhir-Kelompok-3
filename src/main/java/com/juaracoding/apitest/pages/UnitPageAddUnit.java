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

public class UnitPageAddUnit {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public UnitPageAddUnit(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space(text())='Tambahkan']")
    WebElement btnTambahkan;

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxLokasiAbsen;

    @FindBy(xpath = "//input[@id='calendar']")
    WebElement dropdownCalendar;

    @FindBy(xpath = "//input[@id='unitLeave']")
    WebElement dropdownAturanCuti;

    @FindBy(xpath = "//input[@id='ot_reason']")
    WebElement inputOvertimeReason;

    @FindBy(xpath = "//input[@id='max_day_ot']")
    WebElement inputMaksHariPengajuan;

    @FindBy(xpath = "//div[@id='ot_upload']")
    WebElement dropdownUploadBuktiLembur;

    @FindBy(xpath = "//button[normalize-space(text())='Tambah']")
    WebElement btnTambah;

    @FindBy(xpath = "//button[normalize-space(text())='Batal']")
    WebElement btnBatalTambah;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Unit']")
    WebElement notifBerhasil;

    @FindBy(xpath = "//p[@id='name-helper-text']")
    WebElement notifRequiredName;

    public void clickButtonTambahkan() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTambahkan)).click();
    }

    public void inputNama(String nama) {
        if (BrowserUtility.clearValueName(inputName, driver)) {
            inputName.sendKeys(nama);
        }
    }

    public void centangLokasiAbsen() {
        if (!checkboxLokasiAbsen.isSelected()) {
            checkboxLokasiAbsen.click();
        }
    }

    public void pilihUnitKalender(String namaKalender) {
        dropdownCalendar.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaKalender + "']")));
        opsi.click();
    }

    public void pilihAturanCuti(String namaAturan) {
        dropdownAturanCuti.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaAturan + "']")));
        opsi.click();
    }

    public void inputOvertimeReason(String reason) {
        wait.until(ExpectedConditions.visibilityOf(inputOvertimeReason)).clear();
        inputOvertimeReason.sendKeys(reason);
    }

    public void inputMaksHariPengajuan(String hari) {
        wait.until(ExpectedConditions.visibilityOf(inputMaksHariPengajuan)).clear();
        inputMaksHariPengajuan.sendKeys(hari);
    }

    public void pilihBuktiLembur(String opsiValue) {
        dropdownUploadBuktiLembur.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + opsiValue + "']")));
        opsi.click();
    }

    public void clickButtonTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTambah)).click();
    }

    public void clickButtonBatalTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBatalTambah)).click();
    }

    public boolean isUnitSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public String isRequiredName() {
        return wait.until(ExpectedConditions.visibilityOf(notifRequiredName)).getText();
    }
}

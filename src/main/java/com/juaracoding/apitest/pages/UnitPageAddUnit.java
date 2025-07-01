package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(xpath = "//button[contains(text(), 'Tambahkan') or contains(text(), 'Add')]")
    WebElement btnTambahkan;

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxLokasiAbsen;

    @FindBy(xpath = "//input[@id='calendar']")
    WebElement dropdownCalendar;

    @FindBy(xpath = "//input[@id='shifting_id']")
    WebElement dropdownShiftView;

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
        try {
            System.out.println("Looking for Tambahkan button...");
            WebElement tambahButton = wait.until(
                ExpectedConditions.elementToBeClickable(btnTambahkan)
            );
            tambahButton.click();
            System.out.println("Tambahkan button clicked successfully");
        } catch (TimeoutException e) {
            System.out.println("Primary Tambahkan button not found, trying alternatives");
            
            String[] alternativeXpaths = {
                "//button[contains(text(), 'Add')]",
                "//button[contains(@class, 'add')]",
                "//button[@type='button'][contains(., 'Tambah')]"
            };
            
            for (String xpath : alternativeXpaths) {
                try {
                    WebElement altButton = driver.findElement(By.xpath(xpath));
                    if (altButton.isDisplayed() && altButton.isEnabled()) {
                        altButton.click();
                        System.out.println("Alternative Tambahkan button clicked: " + xpath);
                        return;
                    }
                } catch (Exception ex) {
                    continue;
                }
            }
            
            throw new RuntimeException("Cannot find Tambahkan button with any strategy", e);
        }
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
        if (BrowserUtility.clearValueName(dropdownCalendar, driver)) {
            dropdownCalendar.clear();
        }

        dropdownCalendar.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaKalender + "']")));
        opsi.click();
    }

    public void pilihUnitShiftDetail(String namaShift) {
        try {
            System.out.println("Selecting shift detail: " + namaShift);
            
            String xpath = "//li[@role='option' and text()='" + namaShift + "']";
            
            WebElement shiftElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
            );
            
            shiftElement.click();
            System.out.println("Shift detail selected: " + namaShift);
            
        } catch (TimeoutException e) {
            System.out.println("Primary xpath failed, trying alternative for: " + namaShift);
            
            String altXpath = "//li[contains(text(), '" + namaShift + "')]";
            try {
                WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(altXpath))
                );
                element.click();
                System.out.println("Alternative xpath successful for: " + namaShift);
            } catch (Exception ex) {
                throw new RuntimeException("Cannot select shift detail: " + namaShift, ex);
            }
        }
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
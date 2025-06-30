package com.juaracoding.apitest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.apitest.utils.BrowserUtility;

public class UnitPageUnitShift {

    public final WebDriver driver;
    WebDriverWait wait;

    public UnitPageUnitShift(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Shift Type']")
    WebElement notifBerhasil;

    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    WebElement btnShiftAction;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='View']")
    WebElement btnActionViewShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Delete']")
    WebElement btnActionDeleteShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Edit']")
    WebElement btnActionEditShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Atur Virtual ID']")
    WebElement btnActionVirtual;

    @FindBy(xpath = "//label[@role='button' and contains(.,'Pilih Foto')]")
    WebElement btnUploadFoto;

    @FindBy(xpath = "//div[@aria-labelledby='alert-dialog-slide-title']")
    WebElement klikAlertDialog;

    @FindBy(xpath = "//button[@data-testid='colorpicker-button']")
    WebElement btnColorPicker;

    @FindBy(xpath = "//input[@aria-label='color-HEX']")
    WebElement inputColorHex;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Simpan')]")
    WebElement btnSimpan;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Batal')]")
    WebElement btnBatal;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Atur')]")
    WebElement btnAtur;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Ya')]")
    WebElement btnDeleteYa;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Tidak')]")
    WebElement btnDeleteTidak;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Hapus')]")
    WebElement btnHapus;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Delete Type Shift']")
    WebElement notifDeleteBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Type Detail Shift']")
    WebElement notifTambahViewBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Mengatur Virtual ID']")
    WebElement notifVirtualIdBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Edit Unit']")
    WebElement notifEditBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Foto tidak boleh kosong']")
    WebElement notifValidasiVirtual;

    @FindBy(xpath = "//div[@aria-hidden='true' and contains(@style,'z-index: -1')]")
    WebElement closeColorPicker;

    public boolean isShiftSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public void isButtonSave() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSimpan)).click();
    }

    public void isButtonCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBatal)).click();
    }

    public void isButtonAtur() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAtur)).click();
    }

    public void buttonShiftAction() {
        wait.until(ExpectedConditions.elementToBeClickable(btnShiftAction)).click();
    }

    public void isDeletedShift() {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(btnActionDeleteShift));
        element.click();
    }

    public void isAccDeleteShift() {
        WebElement btnYa = wait.until(ExpectedConditions.elementToBeClickable(btnDeleteYa));
        btnYa.click();
    }

    public void isCancelDeleteShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeleteTidak)).click();
    }

    public void isDeleteShiftView() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHapus)).click();
    }

    public void isEditShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionEditShift)).click();
    }

    public void isVirtualId() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionVirtual)).click();
    }

    // public void inputUploudFoto(String filepath) {
    //     wait.until(ExpectedConditions.visibilityOf(inputUploadFoto)).sendKeys(filepath);
    // }

    public void inputUploadFoto(String filepath) {
        WebElement uploadInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        uploadInput.sendKeys(filepath);
    }

    public void buttonColorPicker() {
        wait.until(ExpectedConditions.elementToBeClickable(btnColorPicker)).click();
    }

    public void buttonUploadFoto() {
        wait.until(ExpectedConditions.elementToBeClickable(btnUploadFoto)).click();
    }

    public void alertDiaolog() {
        wait.until(ExpectedConditions.elementToBeClickable(klikAlertDialog)).click();
    }

    public void selectColor(String colorCode) {
        if (BrowserUtility.clearValueName(inputColorHex, driver)) {
            inputColorHex.sendKeys(colorCode);
        }
        // wait.until(ExpectedConditions.visibilityOf(inputColorHex)).clear();
        // inputColorHex.sendKeys(colorCode);
        // String xpath = "//button[@aria-label='color-" + colorCode + "']";
        // WebElement colorButton =
        //         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        // colorButton.click();
    }

    public void closeColorPicker() {
        wait.until(ExpectedConditions.elementToBeClickable(closeColorPicker)).click();
    }

    public void isViewShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionViewShift)).click();
    }

    public boolean isDeleteShiftSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifDeleteBerhasil)).isDisplayed();
    }

    public boolean isAddViewSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifTambahViewBerhasil)).isDisplayed();
    }

    public boolean isAddVirtualIdSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifVirtualIdBerhasil)).isDisplayed();
    }

    public boolean isAddVirtualIdValidation() {
        return wait.until(ExpectedConditions.visibilityOf(notifValidasiVirtual)).isDisplayed();
    }

    public boolean isEditUnitSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifEditBerhasil)).isDisplayed();
    }

    public boolean isDataShiftRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-head')]"));
        return !rows.isEmpty();
    }
}

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

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Simpan')]")
    WebElement btnSimpan;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Batal')]")
    WebElement btnBatal;

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

    public boolean isShiftSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public void isButtonSave() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSimpan)).click();
    }

    public void isButtonCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBatal)).click();
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

    public void isViewShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionViewShift)).click();
    }

    public boolean isDeleteShiftSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifDeleteBerhasil)).isDisplayed();
    }

    public boolean isAddViewSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifTambahViewBerhasil)).isDisplayed();
    }

    public boolean isDataShiftRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-head')]"));
        return !rows.isEmpty();
    }
}

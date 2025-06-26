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
    
    @FindBy(xpath = "(//li[@role='menuitem'])[3]")
    WebElement btnActionDeleteShift;
   
    @FindBy(xpath = "(//li[@role='menuitem'])[2]")
    WebElement btnActionEditShift;
    
    @FindBy(xpath = "//button[@type='submit' and contains(.,'Ya')]")
    WebElement btnDeleteYa;
    
    @FindBy(xpath = "//button[@type='button' and contains(.,'Tidak')]")
    WebElement btnDeleteTidak;
    
    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Delete Type Shift']")
    WebElement notifDeleteBerhasil;

    public boolean isShiftSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public void buttonShiftAction() {
        wait.until(ExpectedConditions.elementToBeClickable(btnShiftAction)).click();
    }

    public void isDeletedShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionDeleteShift)).click();
    }

    public void isAccDeleteShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeleteYa)).click();
    }

    public void isCancelDeleteShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeleteTidak)).click();
    }

    public void isEditShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionEditShift)).click();
    }

    public boolean isDeleteShiftSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifDeleteBerhasil)).isDisplayed();
    }

    public boolean isDataShiftRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-head')]"));
        return !rows.isEmpty();
    }
}

package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePosisiSearch {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public PagePosisiSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchFieldPosisi;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSearchPosisi;

    @FindBy(xpath = "//*[contains(@class,'reset')]")
    WebElement buttonResetPosisi;

    public void searchPosisi(String keyword) {
        closePopupIfVisible();
        waitForBackdropToDisappear();
        wait.until(ExpectedConditions.visibilityOf(searchFieldPosisi));
        searchFieldPosisi.clear();
        searchFieldPosisi.sendKeys(keyword);
    }

    public void searchButtonPosisi() {
        closePopupIfVisible();
        waitForBackdropToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearchPosisi)).click();
    }

    public void resetButtonPosisi() {
        closePopupIfVisible();
        waitForBackdropToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(buttonResetPosisi)).click();
    }

    public void waitForBackdropToDisappear() {
        try {
            By backdrop = By.xpath("//div[contains(@class, 'MuiBackdrop-root')]");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));
        } catch (Exception e) {
            System.out.println("Backdrop hilang atau tidak ditemukan.");
        }
    }

    public void closePopupIfVisible() {
        try {
            WebElement backdrop = driver.findElement(By.xpath("//div[contains(@class, 'MuiBackdrop-root')]"));
            if (backdrop.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backdrop);
                wait.until(ExpectedConditions.invisibilityOf(backdrop));
                System.out.println("Backdrop berhasil ditutup.");
            }
        } catch (Exception e) {
            System.out.println("Backdrop tidak aktif.");
        }
    }

}

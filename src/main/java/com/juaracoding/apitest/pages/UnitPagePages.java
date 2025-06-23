package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnitPagePages {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public UnitPagePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static UnitPagePages init(WebDriver driver) {
        UnitPagePages unitPagePages = new UnitPagePages(driver);
        PageFactory.initElements(driver, unitPagePages);
        return unitPagePages;
    }

    // button next page
    @FindBy(xpath = "//button[contains(@aria-label, 'next')]")
    WebElement btnNextPage;

    //button previous page
    @FindBy(xpath = "//button[contains(@aria-label, 'previous')]")
    WebElement btnPreviousPage;

    //button last page
    @FindBy(xpath = "//button[contains(@aria-label, 'last')]")
    WebElement btnLastPage;

    // button first page
    @FindBy(xpath = "//button[contains(@aria-label, 'first')]")
    WebElement btnFirstPage;

    public void clickNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNextPage)).click();
    }

    public void clickPreviousPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnPreviousPage)).click();
    }

    public void clickLastPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLastPage)).click();
    }

    public void clickFirstPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnFirstPage)).click();
    }
}

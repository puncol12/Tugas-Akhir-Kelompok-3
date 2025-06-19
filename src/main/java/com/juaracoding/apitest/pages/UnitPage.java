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

public class UnitPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UnitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static UnitPage init(WebDriver driver) {
        UnitPage unitPage = new UnitPage(driver);
        PageFactory.initElements(driver, unitPage);
        return unitPage;
    }

    // Menu Manajemen
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[4]")
    WebElement menuManagement;

    // Submenu Unit
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[4]/div/div[2]/div/div/div/div[5]")
    WebElement subMenuUnit;

    // Input search
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSearch;

    public void bukaMenuManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(menuManagement)).click();
    }

    public void bukaSubmenuUnit() {
        wait.until(ExpectedConditions.elementToBeClickable(subMenuUnit)).click();
    }

    public void searchUnit(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void searchButton() {
        buttonSearch.click();
    }

    public boolean isSearchResultDisplayed(String expectedText) {
        // try {
        // By resultLocator = By.xpath("//td[contains(text(),'" + expectedText + "')]");
        // wait.until(ExpectedConditions.presenceOfElementLocated(resultLocator));
        // return driver.findElement(resultLocator).isDisplayed();
        // } catch (TimeoutException | NoSuchElementException e) {
        // return false;
        // }

        List<WebElement> resultRows = driver.findElements(By.xpath("//table//tbody//tr"));
        for (WebElement row : resultRows) {
            if (row.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

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
    @FindBy(xpath = "(//div[contains(@class, 'sidebar__item')])[4]")
    WebElement menuManagement;

    // Submenu Unit
    @FindBy(xpath = "(//p[contains(., 'Unit')])[1]")
    WebElement subMenuUnit;

    // Input search
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSearch;

    public void bukaMenuManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(menuManagement)).click();
    }

    public WebElement getMenuManagement() {
        return menuManagement;
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

    public boolean isSearchResultDisplayed(String keyword) {
        List<WebElement> result = driver.findElements(By.xpath("//tr[position() = 1 or position() = 2]/td[1][contains(.,"+ keyword +")]"));
        return !result.isEmpty();
    }
}


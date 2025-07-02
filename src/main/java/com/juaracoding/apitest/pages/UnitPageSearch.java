package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnitPageSearch {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public UnitPageSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Input search
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;

    // button search
    @FindBy(xpath = "//button[@type='submit' and contains(.,'Search')]")
    WebElement buttonSearch;

    // button reset search
    @FindBy(xpath = "//button[@type='button' and contains(.,'Reset')]")
    WebElement buttonReset;

    public void searchUnit(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void searchButton() {
        buttonSearch.click();
    }

    public void resetButton() {
        buttonReset.click();
    }
}

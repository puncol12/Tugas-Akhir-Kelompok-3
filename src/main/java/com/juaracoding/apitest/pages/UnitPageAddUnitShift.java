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

public class UnitPageAddUnitShift {

    public final WebDriver driver;
    WebDriverWait wait;

    public UnitPageAddUnitShift(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Shift Type']")
    WebElement notifBerhasil;

    public boolean isShiftSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public boolean isDataShiftRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-head')]"));
        return !rows.isEmpty();
    }
}

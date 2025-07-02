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
    public final WebDriver driver;
    public final WebDriverWait wait;

    public UnitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Menu Manajemen
    @FindBy(xpath = "(//div[contains(@class, 'sidebar__item')])[4]")
    WebElement menuManagement;

    // Submenu Unit
    @FindBy(xpath = "(//p[contains(., 'Unit')])[1]")
    WebElement subMenuUnit;

    // Show Page combobox
    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement showPageDropdown;

    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    WebElement btnAction;

    @FindBy(xpath = "(//li[@role='menuitem'])[1]")
    WebElement btnAction01;

    public void bukaMenuManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(menuManagement)).click();
    }

    public WebElement getMenuManagement() {
        return menuManagement;
    }

    public void bukaSubmenuUnit() {
        wait.until(ExpectedConditions.elementToBeClickable(subMenuUnit)).click();
    }

    public void bukaAction() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAction)).click();
    }

    public void action01() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAction01)).click();
    }

    public void selectShowPage(int jumlah) {
        wait.until(ExpectedConditions.elementToBeClickable(showPageDropdown)).click();
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space(text())='" + jumlah + "']")));
        option.click();
        wait.until((WebDriver d) -> getJumlahData() <= jumlah);
    }

    public int getJumlahData() {
        List<WebElement> rowsData = driver.findElements(By.xpath("//table/tbody/tr[td]"));
        return rowsData.size();
    }

    public boolean isSearchResultDisplayed(String keyword) {
        List<WebElement> result = driver.findElements(By.xpath(
                "//tr[position() = 1 or position() = 2]/td[1][contains(.," + keyword + ")]"));
        return !result.isEmpty();
    }

    public boolean isDataRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[position() >= 1 or position() <= 10]/td[1]"));
        return !rows.isEmpty();
    }
}
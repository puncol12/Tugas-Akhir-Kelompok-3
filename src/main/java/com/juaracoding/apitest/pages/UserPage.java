package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[contains(., 'User')])[1]")
    WebElement submenuUser;

    @FindBy(xpath = "//div[@role='combobox' and contains(.,'Nama')]")
    WebElement buttonPilihanPencarian;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Nik']")
    WebElement buttonPencarianNik;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Nama']")
    WebElement buttonPencarianNama;

    public void submenuUser() {
        wait.until(ExpectedConditions.elementToBeClickable(submenuUser)).click();
    }

    public void btnPencarianNama() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPencarianNama)).click();
    }

    public void btnPencarianNik() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPencarianNik)).click();
    }

    public void btnPencarianPilihan() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPilihanPencarian)).click();
    }


}

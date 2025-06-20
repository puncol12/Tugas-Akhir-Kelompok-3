package com.juaracoding.apitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static LoginPage init(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

    // email field
    @FindBy(id = "email")
    WebElement emailField;

    // password field
    @FindBy(id = "password")
    WebElement passwordField;

    //button login
    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonLogin;

    public void login(String email, String password) throws InterruptedException {
        emailField.sendKeys(email);
        Thread.sleep(1000);
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        buttonLogin.click();
    }
}

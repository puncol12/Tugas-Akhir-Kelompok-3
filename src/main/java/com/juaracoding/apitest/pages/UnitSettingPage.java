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

public class UnitSettingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UnitSettingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static UnitSettingPage init(WebDriver driver) {
        UnitSettingPage unitSettingPage = new UnitSettingPage(driver);
        PageFactory.initElements(driver, unitSettingPage);
        return unitSettingPage;
    }

    // Menu Manajemen
    @FindBy(xpath = "(//div[contains(@class, 'sidebar__item')])[4]")
    WebElement menuManagement;

    // Submenu Unit Setting
    @FindBy(xpath = "(//p[contains(., 'Unit Setting')])[1]")
    WebElement bukaSubmenuUnitSetting;

    //Klik Tambahkan
    @FindBy (xpath= "//button[normalize-space()='Tambahkan']")
    WebElement klikTombolTambahkan;

     //Klik Drop Down
    @FindBy(xpath = "//div[contains(@class, 'MuiOutlinedInput-root')]")
    WebElement klikTombolDropDown;
    
    //Klik departmens sesuai text
    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> allOptions;

    //Klik Tambahkan
    @FindBy (xpath= "//button[normalize-space()='Tambah']")
    WebElement klikTombolTambah;
    
  
    
    public void bukaMenuManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(menuManagement)).click();
    }

    public WebElement getMenuManagement() {
        return menuManagement;
    }

    public void bukaSubmenuUnitSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(bukaSubmenuUnitSetting)).click();
    }
    
    public void klikTombolTambahkan() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolTambahkan)).click();
    }

    public void klikTombolDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolDropDown)).click();
    }

    public boolean cekAdaTestUnit33() {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@role='option']")));
    
    for (WebElement option : allOptions) {
        String text = option.getText().trim();
        System.out.println("Checking: '" + text + "'");
        
        if (text.equals("test unit 33")) {
            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
            System.out.println("BERHASIL DIKLIK!");
            return true;
        }
    }
    return false;
}

    public void klikTombolTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolTambah)).click();
    }


}





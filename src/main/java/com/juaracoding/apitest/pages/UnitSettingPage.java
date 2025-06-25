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

    public final WebDriver driver;
    WebDriverWait wait;

    public UnitSettingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//*[@id='alert-slide-description']//div[contains(@class, 'MuiSelect-select')]")
    WebElement klikTombolDropDown;
    
    //Klik departmens sesuai text
    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> allOptions;

    //Klik Tambah
    @FindBy (xpath= "//button[normalize-space()='Tambah']")
    WebElement klikTombolTambah;

    //Klik Batal
    @FindBy (xpath= "//button[normalize-space()='Batal']")
    WebElement klikTombolBatal;

    //Klik Delete pada halaman Unit Setting 
    // public String getDynamicDeleteXPath(String departmentName) {
    // return "//tr[td[1][normalize-space(text())='" + departmentName + "']]/td[last()]//button";
    // }
    // public String getDynamicDeleteXPath(String departmentName) {
    // return "//tr[td[1][normalize-space(text())='" + departmentName + "']]//button[contains(@class, 'MuiIconButton-root')]";
    // }
    //(//button[contains(@class, 'MuiIconButton-root') and contains(@class, 'MuiButtonBase-root') and @type='button'])[1]
    //Klik Ya
     @FindBy (xpath= "(//button[contains(@class, 'MuiIconButton-root') and contains(@class, 'MuiButtonBase-root') and @type='button'])[1]")
    WebElement klikTombolDelete;

    @FindBy (xpath= "//button[normalize-space()='Ya']")
    WebElement klikTombolYa;

     //Klik Tidak
    @FindBy (xpath= "//button[normalize-space()='Tidak']")
    WebElement klikTombolTidak;

    //Notifikasi Berhasil Menambahkan Departemens
    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message')]")
    WebElement notifikasiBerhasil;

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

    public boolean pilihDepartment(String departmentName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@role='option']")));
        
        for (WebElement option : allOptions) {
            String text = option.getText().trim();
            
            if (text.equals(departmentName)) {
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                return true;
            }
        }
        
        return false;
    }

    public void klikTombolTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolTambah)).click();
    }

    public void klikTombolBatal() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolBatal)).click();
    }

    // NEW METHOD untuk validasi kembali ke halaman utama
    public boolean isBackToUnitSettingMainPage() {
        try {
            WebElement tambahkanButton = wait.until(ExpectedConditions.visibilityOf(klikTombolTambahkan));
            return tambahkanButton.isDisplayed();
            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean succesAddDepartemens() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(notifikasiBerhasil));
            String notificationText = element.getText();
            
            if (notificationText.equals("Berhasil Menambahkan Departemens")) {
                return true;
            }
            
            return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean failAddDuplicateDepartemens() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(notifikasiBerhasil));
            String notificationText = element.getText();
            
            if (notificationText.equals("Gagal Menambahkan Departemens")) {
                return true;
            }
            
            return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public void successDeleteDepartemens() {

    wait.until(ExpectedConditions.elementToBeClickable(klikTombolDelete)).click();
    // try {
    //     WebElement element = wait.until(ExpectedConditions.visibilityOf(notifikasiBerhasil));
    //     String notificationText = element.getText();
        
    //     if (notificationText.equals("Berhasil Delete Departemens")) { 
    //         return true;
    //     }
        
    //     return false;
        
    // } catch (Exception e) {
    //     return false;
    // }
}

    // public void clickDeleteButton(String departmentName) {
    // String xpath = getDynamicDeleteXPath(departmentName);
    // WebElement deleteButton = driver.findElement(By.xpath(xpath));
    // deleteButton.click();
    // }

    public void klikTombolYa() {
    wait.until(ExpectedConditions.elementToBeClickable(klikTombolYa)).click();
    }

    public void klikTombolTidak() {
    wait.until(ExpectedConditions.elementToBeClickable(klikTombolTidak)).click();
    }

}
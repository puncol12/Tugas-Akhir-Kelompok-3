package com.juaracoding.apitest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    
    @FindBy(xpath = "(//div[contains(@class, 'sidebar__item')])[4]")
    WebElement menuManagement;

    @FindBy(xpath = "(//p[contains(., 'Unit Setting')])[1]")
    WebElement bukaSubmenuUnitSetting;

    @FindBy (xpath= "//button[normalize-space()='Tambahkan']")
    WebElement klikTombolTambahkan;


    @FindBy(xpath = "//*[@id='alert-slide-description']//div[contains(@class, 'MuiSelect-select')]")
    WebElement klikTombolDropDown;
    

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> allOptions;

 
    @FindBy (xpath= "//button[normalize-space()='Tambah']")
    WebElement klikTombolTambah;


    @FindBy (xpath= "//button[normalize-space()='Batal']")
    WebElement klikTombolBatal;

 
    @FindBy (xpath= "(//button[contains(@class, 'MuiIconButton-root') and contains(@class, 'MuiButtonBase-root') and @type='button'])[3]")
    WebElement klikTombolDelete;

    @FindBy (xpath= "//h2[@id='alert-dialog-slide-title']")
    WebElement dialogDelete;


    @FindBy (xpath= "//button[normalize-space()='Ya']")
    WebElement klikTombolYa;

    @FindBy (xpath= "//button[normalize-space()='Tidak']")
    WebElement klikTombolTidak;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Departemens']")
    WebElement notifikasiBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Gagal Menambahkan Departemens']")
    WebElement notifikasiGagal;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Delete Departemens']")
    WebElement notifikasiDelete;

    
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

    public boolean clickForToggleDepartment(String toggleDepartmentName) {
    try {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'MuiSwitch-switchBase')]")));
        
        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody//tr"));
        
        for (WebElement row : tableRows) {
            String rowText = row.getText().trim();
            
            if (rowText.contains(toggleDepartmentName)) {
                WebElement toggleButton = row.findElement(By.xpath(".//span[contains(@class, 'MuiSwitch-switchBase')]"));
                wait.until(ExpectedConditions.elementToBeClickable(toggleButton)).click();
                return true;
            }
        }
        
        return false;
        
    } catch (Exception e) {
        System.err.println("Error clicking toggle: " + e.getMessage());
        return false;
    }
}
    
public boolean validateDateUpdated(String selfieDepartmentName) {
    try {
        String dynamicXPath = "//tbody/tr[contains(., '" + selfieDepartmentName + "')]/td[4]/h6";
        
        WebElement updateDateElement = driver.findElement(By.xpath(dynamicXPath));
        String updateDate = updateDateElement.getText().trim();
        String expectedDate = "27 Jun 2025";
        
        System.out.println("Department: " + selfieDepartmentName);
        System.out.println("Current update date: " + updateDate);
        System.out.println("Expected update date: " + expectedDate);
        
        return updateDate.equals(expectedDate);
        
    } catch (Exception e) {
        System.err.println("Error validating date: " + e.getMessage());
        System.err.println("Failed XPath: //tbody/tr[contains(., '" + selfieDepartmentName + "')]/td[4]/h6");
        return false;
    }
}

    public void klikTombolTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolTambah)).click();
    }

    public void klikTombolBatal() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolBatal)).click();
    }

    public boolean succesAddDepartemens() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(notifikasiBerhasil)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean succesDeleteDepartemens() {
            return wait.until(ExpectedConditions.visibilityOf(notifikasiDelete)).isDisplayed();
    }

    public boolean failAddDuplicateDepartemens() {
        
        boolean isNotificationVisible = wait.until(ExpectedConditions.visibilityOf(notifikasiGagal)).isDisplayed();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        return isNotificationVisible;
}

    public void iconDeleteDepartemens() {
    wait.until(ExpectedConditions.elementToBeClickable(klikTombolDelete)).click();

}

    public void isDialogDeleteDisplay() {
        wait.until(ExpectedConditions.visibilityOf(dialogDelete)).isDisplayed();

    }
   

public void isDialogSelfieDisplay() throws InterruptedException {
    Thread.sleep(3000);
    Alert alert = driver.switchTo().alert();
    alert.accept();
}

    public void klikTombolYa() {
    wait.until(ExpectedConditions.elementToBeClickable(klikTombolYa)).click();
    }

    public void klikTombolTidak() {
    wait.until(ExpectedConditions.elementToBeClickable(klikTombolTidak)).click();
    }


}
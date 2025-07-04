package com.juaracoding.apitest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.apitest.utils.BrowserUtility;

public class PagePosisi {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PagePosisi(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Submenu Posisi
    @FindBy(xpath = "(//p[contains(., 'Posisi')])[1]")
    WebElement subMenuPosisi;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Edit']")
    WebElement btnEditPosisi;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Delete']")
    WebElement btnDeletePosisi;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Simpan')]")
    WebElement simpanButton;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Batal')]")
    WebElement batalButton;

    @FindBy(xpath = "//*[@id='alert-slide-description']//div[contains(@class, 'MuiSelect-select')]")
    WebElement dropdownDept;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Ya')]")
    WebElement tombolYa;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Tidak')]")
    WebElement tombolTidak;

    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    WebElement tombolTitik3;

    @FindBy(xpath = "//h2[@id='alert-dialog-slide-title']")
    WebElement halamanHapus;

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchFieldPosisi;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSearchPosisi;

    public void searchPosisi(String keyword) {
        closePopupIfVisible();
        waitForBackdropToDisappear();
        wait.until(ExpectedConditions.visibilityOf(searchFieldPosisi));
        searchFieldPosisi.clear();
        searchFieldPosisi.sendKeys(keyword);
    }

    public void searchButtonPosisi() {
        closePopupIfVisible();
        waitForBackdropToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearchPosisi)).click();
    }

    public void waitForBackdropToDisappear() {
        try {
            By backdrop = By.xpath("//div[contains(@class, 'MuiBackdrop-root')]");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));
        } catch (Exception e) {
            System.out.println("Backdrop hilang atau tidak ditemukan.");
        }
    }

    public void closePopupIfVisible() {
        try {
            WebElement backdrop =
                    driver.findElement(By.xpath("//div[contains(@class, 'MuiBackdrop-root')]"));
            if (backdrop.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backdrop);
                wait.until(ExpectedConditions.invisibilityOf(backdrop));
                System.out.println("Backdrop berhasil ditutup.");
            }
        } catch (Exception e) {
            System.out.println("Backdrop tidak aktif.");
        }
    }

    public void bukaSubmenuPosisi() {
        wait.until(ExpectedConditions.elementToBeClickable(subMenuPosisi)).click();
    }

    public boolean isSearchResultDisplayedPosisi(String keyword) {
        List<WebElement> result = driver
                .findElements(By.xpath("//table/tbody/tr/td[contains(text(),'" + keyword + "')]"));
        return !result.isEmpty();
    }

    public void klikTombolTitik3() {
        wait.until(ExpectedConditions.elementToBeClickable(tombolTitik3)).click();
    }

    public void klikSimpan() {
        wait.until(ExpectedConditions.elementToBeClickable(simpanButton)).click();
    }

    public void klikBatal() {
        wait.until(ExpectedConditions.elementToBeClickable(batalButton)).click();
    }

    public void inputDepartment(String dept) {
        dropdownDept.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + dept + "']")));
        opsi.click();
    }

    public String getErrorMessageTambah() {
        WebElement namaField = driver.findElement(By.id("name"));
        return BrowserUtility.getValidationMessage(driver, namaField);
    }

    public String getErrorMessageTambahNik() {
        WebElement namaField = driver.findElement(By.id("nik"));
        return BrowserUtility.getValidationMessage(driver, namaField);
    }

    public void klikEditPosisi() {
        wait.until(ExpectedConditions.elementToBeClickable(btnEditPosisi)).click();
    }

    public void halamanKonfirmasiHapus() {
        wait.until(ExpectedConditions.visibilityOf(halamanHapus)).isDisplayed();
    }

    public void klikTombolDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeletePosisi)).click();
    }

    public void konfirmasiHapusYa() {
        wait.until(ExpectedConditions.elementToBeClickable(tombolYa)).click();
    }

    public void konfirmasiHapusTidak() {
        wait.until(ExpectedConditions.elementToBeClickable(tombolTidak)).click();
    }
}


package com.juaracoding.apitest.pages;

import com.juaracoding.apitest.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(xpath = "//button[normalize-space(text())='Tambahkan']")
    WebElement buttonTambahkan;

    // Input search
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSearch;

    @FindBy(xpath = "//*[contains(@class,'reset')]")
    WebElement buttonReset;

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement showPageDropdown;

    @FindBy(xpath = "//button[contains(@aria-label, 'next')]")
    WebElement btnNextPage;

    @FindBy(xpath = "//button[contains(@aria-label, 'previous')]")
    WebElement btnPreviousPage;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Edit']")
    WebElement btnEditPosisi;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Delete']")
    WebElement btnDeletePosisi;

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputNamaPosisi;

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

    @FindBy(xpath = "//button[contains(@aria-label, 'Delete')]")
    WebElement klikTombolDelete;

    @FindBy(xpath = "//h2[@id='alert-dialog-slide-title']")
    WebElement halamanHapus;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Posisi']")
    WebElement notifBerhasilPosisi;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Edit Posisi']")
    WebElement notifBerhasilEditPosisi;


    public void bukaSubmenuPosisi() {
        wait.until(ExpectedConditions.elementToBeClickable(subMenuPosisi)).click();
    }

    public void searchPosisi(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void searchButton() {
        buttonSearch.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table/tbody/tr"), 0));
    }

    public boolean isSearchResultDisplayedPosisi(String keyword) {
        List<WebElement> result = driver.findElements(By.xpath(
                "//table/tbody/tr/td[contains(text(),'" + keyword + "')]"));
        return !result.isEmpty();
    }

    //menu edit
    public void klikTombolTitik3() {
        wait.until(ExpectedConditions.elementToBeClickable(tombolTitik3)).click();
    }

    public void klikSimpan() {
        //klik tombol simpan edit
        wait.until(ExpectedConditions.elementToBeClickable(simpanButton)).click();
    }

    public void klikBatal() {
        //klik tombol batal edit
        wait.until(ExpectedConditions.elementToBeClickable(batalButton)).click();
    }

    public boolean isUpdateBerhasil() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasilEditPosisi)).isDisplayed();
    }

    public void inputDepartment(String dept) {
        dropdownDept.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + dept + "']")));
        opsi.click();

    }


    public boolean isPosisiBerhasilDitambahkan() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasilPosisi)).isDisplayed();
    }


    public void kosongkanDepartment() {
        WebElement deptField = driver.findElement(By.id("alert-slide-description"));
        deptField.clear();
    }

    public String getErrorMessageTambah() {
        WebElement namaField = driver.findElement(By.id("name"));
        return BrowserUtility.getValidationMessage(driver, namaField);
    }

    public void klikEditPosisi() {
        wait.until(ExpectedConditions.elementToBeClickable(btnEditPosisi)).click();
    }

    //menu delete
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


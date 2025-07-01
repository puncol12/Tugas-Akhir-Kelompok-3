package com.juaracoding.apitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[normalize-space(text())='Export']")
    WebElement buttonExport;

    @FindBy(xpath = "//button[normalize-space(text())='Terapkan']")
    WebElement buttonTerapkan;

    @FindBy(xpath = "//div[contains(@class,'MuiGrid-grid-lg-1')]//button[.//* [contains(@class,'feather-filter')]]")
    WebElement buttonFilter;

    @FindBy(xpath = "//div[@id='mui-component-select-job_departement_id' and @role='combobox']")
    WebElement dropdownFilterUnit;

    @FindBy(xpath = "//div[@id='mui-component-select-job_level_id' and @role='combobox']")
    WebElement dropdownFilterJobLevel;

    @FindBy(xpath = "//div[@id='mui-component-select-employee_type_id' and @role='combobox']")
    WebElement dropdownFilterTipeKaryawan;

    @FindBy(xpath = "//div[@id='mui-component-select-job_position_id' and @role='combobox']")
    WebElement dropdownFilterPosisiKerja;

    @FindBy(xpath = "//div[@id='mui-component-select-location_point_id' and @role='combobox']")
    WebElement dropdownFilterLokasiKerja;

    @FindBy(xpath = "//div[@id='demo-select-small' and @role='combobox']")
    WebElement dropdownFilterStatus;

    //Tambahan 
    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//input[@id='search']")
    WebElement inputSearch;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement buttonSearch;


    // XPath Toggle User Project
    @FindBy(xpath = "(//span[contains(@class, 'MuiSwitch-root')])[2]")
    WebElement toggleUserProject;

    // Xpath Toggle Active
    @FindBy(xpath = "(//span[contains(@class, 'MuiSwitch-root')])[1]")
    WebElement toggleActive;

    // Xpath Notification
    @FindBy(xpath = "//div[normalize-space(text())='Project diaktifkan']")
    WebElement projectActiveMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Project dinonaktifkan']")
    WebElement projectNonActiveMessage;

    @FindBy(xpath = "//div[normalize-space(text())='User diaktifkan']")
    WebElement activeMessage;

    @FindBy(xpath = "//div[normalize-space(text())='User dinonaktifkan']")
    WebElement nonActiveMessage;


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

    public void btnFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonFilter)).click();
    }

    public void btnTerapkan() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonTerapkan)).click();
    }

    public void btnExport() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonExport)).click();
    }
    
    // Tambahan
    public void btnSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit)).click();
    }

    public void inputSearchData(String data) {
        wait.until(ExpectedConditions.visibilityOf(inputSearch)).clear();
        inputSearch.sendKeys(data);
    }

    public void btnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
    }

    // Method toggle User Project - Satu method untuk aktif/nonaktif
    public void clickToggleUserProject() {
        wait.until(ExpectedConditions.elementToBeClickable(toggleUserProject)).click();
    }

    public void clickToggleUser() {
        wait.until(ExpectedConditions.elementToBeClickable(toggleActive)).click();
    }

    // Method Notification
    public boolean isNotificationDisplayedProjectActive() {
        return wait.until(ExpectedConditions.visibilityOf(projectActiveMessage)).isDisplayed();
    }

    public boolean isNotificationActiveProjectNonActive() {
        return wait.until(ExpectedConditions.visibilityOf(projectNonActiveMessage)).isDisplayed();
    }

    public boolean isNotificationDisplayedActive() {
        return wait.until(ExpectedConditions.visibilityOf(activeMessage)).isDisplayed();
    }

    public boolean isNotificationActiveNonActive() {
        return wait.until(ExpectedConditions.visibilityOf(nonActiveMessage)).isDisplayed();
    }

    public void filterUnit(String namaUnit) {
        dropdownFilterUnit.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaUnit + "']")));
        opsi.click();
    }

    public void filterJobLevel(String namaJobLevel) {
        dropdownFilterJobLevel.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaJobLevel + "']")));
        opsi.click();
    }

    public void filterKaryawan(String namaKaryawan) {
        dropdownFilterTipeKaryawan.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaKaryawan + "']")));
        opsi.click();
    }

    public void filterPosisi(String namaPosisi) {
        dropdownFilterPosisiKerja.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaPosisi + "']")));
        opsi.click();
    }

    public void filterLokasiKerja(String namaLokasi) {
        dropdownFilterLokasiKerja.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaLokasi + "']")));
        opsi.click();
    }

    public void filterStatus(String status) {
        dropdownFilterStatus.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + status + "']")));
        opsi.click();
    }
}
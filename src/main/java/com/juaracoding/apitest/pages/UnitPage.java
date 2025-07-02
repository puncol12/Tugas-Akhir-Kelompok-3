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

import com.juaracoding.apitest.utils.BrowserUtility;

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

    @FindBy(xpath = "//button[normalize-space(text())='Tambahkan']")
    WebElement btnTambahkan;

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxLokasiAbsen;

    @FindBy(xpath = "//input[@id='calendar']")
    WebElement dropdownCalendar;

    @FindBy(xpath = "//input[@id='shifting_id' and @role='combobox']")
    WebElement dropdownShiftView;

    @FindBy(xpath = "//input[@id='unitLeave']")
    WebElement dropdownAturanCuti;

    @FindBy(xpath = "//input[@id='ot_reason']")
    WebElement inputOvertimeReason;

    @FindBy(xpath = "//input[@id='max_day_ot']")
    WebElement inputMaksHariPengajuan;

    @FindBy(xpath = "//div[@id='ot_upload']")
    WebElement dropdownUploadBuktiLembur;

    @FindBy(xpath = "//button[normalize-space(text())='Tambah']")
    WebElement btnTambah;

    @FindBy(xpath = "//button[normalize-space(text())='Batal']")
    WebElement btnBatalTambah;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Unit']")
    WebElement notifBerhasil;

    @FindBy(xpath = "//p[@id='name-helper-text']")
    WebElement notifRequiredName;

    // button next page
    @FindBy(xpath = "//button[contains(@aria-label, 'next')]")
    WebElement btnNextPage;

    // button previous page
    @FindBy(xpath = "//button[contains(@aria-label, 'previous')]")
    WebElement btnPreviousPage;

    // button last page
    @FindBy(xpath = "//button[contains(@aria-label, 'last')]")
    WebElement btnLastPage;

    // button first page
    @FindBy(xpath = "//button[contains(@aria-label, 'first')]")
    WebElement btnFirstPage;

    public void clickNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNextPage)).click();
    }

    public void clickPreviousPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnPreviousPage)).click();
    }

    public void clickLastPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLastPage)).click();
    }

    public void clickFirstPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnFirstPage)).click();
    }

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


    public void clickButtonTambahkan() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTambahkan)).click();
    }

    public void inputNama(String nama) {
        if (BrowserUtility.clearValueName(inputName, driver)) {
            inputName.sendKeys(nama);
        }
    }

    public void centangLokasiAbsen() {
        if (!checkboxLokasiAbsen.isSelected()) {
            checkboxLokasiAbsen.click();
        }
    }

    public void pilihUnitKalender(String namaKalender) {
        if (BrowserUtility.clearValueName(dropdownCalendar, driver)) {
            dropdownCalendar.clear();
        }

        dropdownCalendar.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaKalender + "']")));
        opsi.click();
    }

    public void pilihUnitShiftDetail(String namaShift) {
        dropdownShiftView.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaShift + "']")));
        opsi.click();
    }

    public void pilihAturanCuti(String namaAturan) {
        dropdownAturanCuti.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + namaAturan + "']")));
        opsi.click();
    }

    public void inputOvertimeReason(String reason) {
        wait.until(ExpectedConditions.visibilityOf(inputOvertimeReason)).clear();
        inputOvertimeReason.sendKeys(reason);
    }

    public void inputMaksHariPengajuan(String hari) {
        wait.until(ExpectedConditions.visibilityOf(inputMaksHariPengajuan)).clear();
        inputMaksHariPengajuan.sendKeys(hari);
    }

    public void pilihBuktiLembur(String opsiValue) {
        dropdownUploadBuktiLembur.click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + opsiValue + "']")));
        opsi.click();
    }

    public void clickButtonTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTambah)).click();
    }

    public void clickButtonBatalTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBatalTambah)).click();
    }

    public boolean isUnitSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasil)).isDisplayed();
    }

    public String isRequiredName() {
        return wait.until(ExpectedConditions.visibilityOf(notifRequiredName)).getText();
    }
}

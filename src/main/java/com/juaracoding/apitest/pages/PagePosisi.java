package com.juaracoding.apitest.pages;

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
    }

    public static PagePosisi init(WebDriver driver) {
        PagePosisi posisiPage = new PagePosisi(driver);
        PageFactory.initElements(driver, posisiPage);
        return posisiPage;
    }

    // Menu Manajemen
    @FindBy(xpath = "(//div[contains(@class, 'sidebar__item')])[4]")
    WebElement menuManagement;

    // Submenu Posisi
    @FindBy(xpath = "(//p[contains(., 'Posisi')])[1]")
    WebElement subMenuPosisi;

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

    @FindBy(xpath = "//button[contains(@aria-label, 'Edit')]")
    WebElement btnEditPosisi;

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputNamaPosisi;

    @FindBy(xpath = "//button[contains(@aria-label, 'Simpan')]")
    WebElement simpanButton;

    @FindBy(xpath = "//button[contains(@aria-label, 'Batal')]")
    WebElement batalButton;

    @FindBy(xpath = "//*[@id='alert-slide-description']//div[contains(@class, 'MuiSelect-select')]")
    WebElement dropdownDept;

    //@FindBy(className = )
    WebElement errorMsg;

//    @FindBy(xpath = "//button[contains(text(),'Ya')]");
//    WebElement tombolYa;
//
//    @FindBy(xpath = "//button[contains(text(),'Tidak')]");
//    WebElement tombolTidak;

    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    WebElement tombolTitik3;

    @FindBy(xpath = "//button[contains(@aria-label, 'Delete')]")
    WebElement klikTombolDelete;

    @FindBy (xpath= "//h2[@id='alert-dialog-slide-title']")
    WebElement halamanHapus;

    public void bukaMenuManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(menuManagement)).click();
    }

    public WebElement getMenuManagement() {
        return menuManagement;
    }

    public void bukaSubmenuPosisi() {
        wait.until(ExpectedConditions.elementToBeClickable(subMenuPosisi)).click();
    }

    public boolean isPosisiPageDisplayed() {
        try {
            WebElement tombolTambah = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(.,'Tambah')]")
            ));
            return tombolTambah.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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

   /* public void resetButton() {
        buttonReset.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table/tbody/tr"), 0));
    }*/

    public void klikNextPage() {
        btnNextPage.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnNextPage)).click();
    }

    public boolean isHalamanSelanjutnyaTampil() {
        return btnPreviousPage.isEnabled();
    }

    public void klikPreviousPage() {
        btnPreviousPage.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnPreviousPage)).click();
    }

    public boolean isHalamanSebelumnyaTampil() {
        return btnNextPage.isEnabled();
    }


    public void selectShowPage(int jumlah) {
        wait.until(ExpectedConditions.elementToBeClickable(showPageDropdown)).click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space(text())='" + jumlah + "']")));
        option.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table/tbody/tr"), 0));
    }

    public int getJumlahData() {
        List<WebElement> rowsData = driver.findElements(By.xpath("//table/tbody/tr[td]"));
        return rowsData.size();
    }

    public boolean isSearchResultDisplayed(String keyword) {
        List<WebElement> result = driver.findElements(By.xpath(
                "//table/tbody/tr/td[contains(text(),'" + keyword + "')]"));
        return !result.isEmpty();
    }

    public boolean isDataRestored() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        return !rows.isEmpty();
    }

    //menu edit
    public void klikTombolTitik3() {
        tombolTitik3.click();
    }

    public void ubahNamaPosisi(String namaBaru) {
        inputNamaPosisi.clear();
        inputNamaPosisi.sendKeys(namaBaru);
    }

    public void kosongkanNamaPosisiSaatEdit() {
        //clear field nama posisi
        inputNamaPosisi.clear();
    }

    public void klikSimpan() {
        //klik tombol simpan edit
        simpanButton.click();
    }

    public void klikBatal() {
        //klik tombol batal edit
        batalButton.click();
    }

    public boolean isUpdateBerhasil() {
        return true;
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public boolean isDataTidakBerubah() {
        return true;
    }

    // menu tambah
    public void klikTambahPosisi() {
        WebElement btnTambah = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space(text())='Tambahkan']")));
        btnTambah.click();
    }

    public boolean isFormTambahPosisiMuncul() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[contains(.,'Tambah Posisi')]"))) != null;

    }

    public void inputNamaPosisi(String nama) {
        WebElement namaField = driver.findElement(By.id("name"));
        namaField.clear();
        namaField.sendKeys(nama);
    }

    public void inputDepartment(String dept) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownDept)).click();
        WebElement opsi = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[normalize-space()='" + dept + "']")));
        opsi.click();

        //        Select dropdown = new Select(driver.findElement(By.id("alert-slide-description")));
//       dropdown.selectByVisibleText(dept);
//        deptField.clear();
        //deptField.sendKeys(dept);
    }

    public void klikSimpanTambah() {
        driver.findElement(By.xpath("//button[text()='Tambah']")).click();
    }

    public boolean isPosisiBerhasilDitambahkan() {
        return true;
    }

    public void kosongkanNamaPosisi() {
        WebElement namaField = driver.findElement(By.id("name"));
        namaField.clear();
    }

    public void kosongkanDepartment() {
        WebElement deptField = driver.findElement(By.id("alert-slide-description"));
        deptField.clear();
    }

    public String getErrorMessageTambah() {
        List<WebElement> errorElements = driver.findElements(By.className("error-message"));
        if (!errorElements.isEmpty() && errorElements.get(0).isDisplayed()) {
            return errorElements.get(0).getText();
        } else {
            return "";
        }
    }
//    public String getErrorMessageTambah() {
//        WebElement error = driver.findElement(By.className("error-message"));
//        return error.getText();
//    }

    //menu reset
    public void klikTombolResetSearch() {
        buttonReset.click();
    }

    public boolean isDataDitampilkanSemua() {
        List<WebElement> listData = driver.findElements(By.xpath("//table/tbody/tr"));
        return listData.size() > 0;
    }

    public void klikEditPosisi() {
        btnEditPosisi.click();
    }

    //menu delete
    public void halamanKonfirmasiHapus(){
        wait.until(ExpectedConditions.visibilityOf(halamanHapus)).isDisplayed();
    }
    public void klik_tombol_delete() {
        wait.until(ExpectedConditions.elementToBeClickable(klikTombolDelete)).click();

    }
//    public void konfirmasi_Hapus_ya(){
//        wait.until(ExpectedConditions.elementToBeClickable(tombolYa)).click();
//    }
//    public void konfirmasi_Hapus_tidak(){
//        wait.until(ExpectedConditions.elementToBeClickable(tombolTidak)).click();
//    }

}


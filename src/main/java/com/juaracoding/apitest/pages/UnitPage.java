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

    // Input search
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;

    // button search
    @FindBy(xpath = "//button[@type='submit' and contains(.,'Search')]")
    WebElement buttonSearch;

    // button reset search
    @FindBy(xpath = "//button[@type='button' and contains(.,'Reset')]")
    WebElement buttonReset;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Shift Type']")
    WebElement notifBerhasilShiftType;

    @FindBy(xpath = "(//button[@aria-label='action'])[1]")
    WebElement btnShiftAction;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='View']")
    WebElement btnActionViewShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Delete']")
    WebElement btnActionDeleteShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Edit']")
    WebElement btnActionEditShift;

    @FindBy(xpath = "//div[contains(@style, 'opacity: 1')]/ul/li[text()='Atur Virtual ID']")
    WebElement btnActionVirtual;

    @FindBy(xpath = "//label[@role='button' and contains(.,'Pilih Foto')]")
    WebElement btnUploadFoto;

    @FindBy(xpath = "//div[@aria-labelledby='alert-dialog-slide-title']")
    WebElement klikAlertDialog;

    @FindBy(xpath = "//button[@data-testid='colorpicker-button']")
    WebElement btnColorPicker;

    @FindBy(xpath = "//input[@aria-label='color-HEX']")
    WebElement inputColorHex;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Simpan')]")
    WebElement btnSimpan;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Batal')]")
    WebElement btnBatal;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Atur')]")
    WebElement btnAtur;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Ya')]")
    WebElement btnDeleteYa;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Tidak')]")
    WebElement btnDeleteTidak;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Hapus')]")
    WebElement btnHapus;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Delete Type Shift']")
    WebElement notifDeleteBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Type Detail Shift']")
    WebElement notifTambahViewBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Mengatur Virtual ID']")
    WebElement notifVirtualIdBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Edit Unit']")
    WebElement notifEditBerhasil;

    @FindBy(xpath = "//div[normalize-space(text())='Foto tidak boleh kosong']")
    WebElement notifValidasiVirtual;

    @FindBy(xpath = "//div[@aria-hidden='true' and contains(@style,'z-index: -1')]")
    WebElement closeColorPicker;

    public boolean isShiftSuccesAdded() {
        return wait.until(ExpectedConditions.visibilityOf(notifBerhasilShiftType)).isDisplayed();
    }

    public void isButtonSave() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSimpan)).click();
    }

    public void isButtonCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBatal)).click();
    }

    public void isButtonAtur() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAtur)).click();
    }

    public void buttonShiftAction() {
        wait.until(ExpectedConditions.elementToBeClickable(btnShiftAction)).click();
    }

    public void isDeletedShift() {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(btnActionDeleteShift));
        element.click();
    }

    public void isAccDeleteShift() {
        WebElement btnYa = wait.until(ExpectedConditions.elementToBeClickable(btnDeleteYa));
        btnYa.click();
    }

    public void isCancelDeleteShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDeleteTidak)).click();
    }

    public void isDeleteShiftView() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHapus)).click();
    }

    public void isEditShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionEditShift)).click();
    }

    public void isVirtualId() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionVirtual)).click();
    }

    public void inputUploadFoto(String filepath) {
        WebElement uploadInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        uploadInput.sendKeys(filepath);
    }

    public void buttonColorPicker() {
        wait.until(ExpectedConditions.elementToBeClickable(btnColorPicker)).click();
    }

    public void buttonUploadFoto() {
        wait.until(ExpectedConditions.elementToBeClickable(btnUploadFoto)).click();
    }

    public void alertDiaolog() {
        wait.until(ExpectedConditions.elementToBeClickable(klikAlertDialog)).click();
    }

    public void selectColor(String colorCode) {
        if (BrowserUtility.clearValueName(inputColorHex, driver)) {
            inputColorHex.sendKeys(colorCode);
        }
    }

    public void closeColorPicker() {
        wait.until(ExpectedConditions.elementToBeClickable(closeColorPicker)).click();
    }

    public void isViewShift() {
        wait.until(ExpectedConditions.elementToBeClickable(btnActionViewShift)).click();
    }

    public boolean isDeleteShiftSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifDeleteBerhasil)).isDisplayed();
    }

    public boolean isAddViewSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifTambahViewBerhasil)).isDisplayed();
    }

    public boolean isAddVirtualIdSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifVirtualIdBerhasil)).isDisplayed();
    }

    public boolean isAddVirtualIdValidation() {
        return wait.until(ExpectedConditions.visibilityOf(notifValidasiVirtual)).isDisplayed();
    }

    public boolean isEditUnitSucces() {
        return wait.until(ExpectedConditions.visibilityOf(notifEditBerhasil)).isDisplayed();
    }

    public boolean isDataShiftRestored() {
        List<WebElement> rows =
                driver.findElements(By.xpath("//tr[contains(@class, 'MuiTableRow-head')]"));
        return !rows.isEmpty();
    }

    public void searchUnit(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void searchButton() {
        buttonSearch.click();
    }

    public void resetButton() {
        buttonReset.click();
    }

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

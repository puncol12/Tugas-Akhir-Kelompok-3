// package com.juaracoding.apitest.steps;

// import java.time.Duration;

// import org.openqa.selenium.WebDriver;
// import org.testng.Assert;

// import com.juaracoding.apitest.DriverSingleton;
// import com.juaracoding.apitest.pages.UnitSettingPage;

// import io.cucumber.java.en.And;
// import io.cucumber.java.en.When;
// import io.cucumber.java.en.Then;

// public class UnitSettingSteps {

//     WebDriver driver;
//     UnitSettingPage unitSettingPage;
    
//     // ===== COMMON SETUP METHOD (DRY PRINCIPLE) =====
//     private void initializeDriver() {
//         if (driver == null) {
//             driver = DriverSingleton.createOrGetDriver();
//             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//             unitSettingPage = new UnitSettingPage(driver);
//         }
//     }
    
//     // ===== NAVIGATION STEPS =====
//     @When("Klik submenu Unit Setting")
//     public void userKlikSubmenuUnitSetting() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.bukaSubmenuUnitSetting();
//     }

//     @When("Klik Tombol Tambahkan")
//     public void userKlikTombolTambahkan() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolTambahkan();
//     }

//     @And("Klik Tombol Drop Down")
//     public void userKlikTombolDropDown() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolDropDown();
//     }

//     @And("User memilih {string}")
//     public void userMemilihDepartment(String departmentName) throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.pilihDepartment(departmentName);
//     }

//     // ===== ACTION STEPS =====
//     @And("Klik Tombol Tambah")
//     public void userKlikTombolTambah() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolTambah();
//     }

//     @And("Klik Tombol Batal")
//     public void userKlikTombolBatal() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolBatal();
//     }

//     // ===== DELETE ACTION STEPS =====
//     @And("Klik Tombol Delete untuk {string}")
//     public void userKlikTombolDelete(String departmentName) throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.successDeleteDepartemens();
//         Thread.sleep(1000); 
//     }

//     @And("Klik Tombol Ya")
//     public void userKlikTombolYa() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolYa();
//         Thread.sleep(1000); // Wait for action completion
//     }

//     @And("Klik Tombol Tidak")
//     public void userKlikTombolTidak() throws InterruptedException {
//         initializeDriver();
//         unitSettingPage.klikTombolTidak();
//         Thread.sleep(1000); // Wait for dialog close
//     }

//     // ===== VALIDATION STEPS =====
//    @Then("Muncul notifikasi {string}")
//     public void munculNotifikasi(String expectedNotification) throws InterruptedException {
//     initializeDriver();
    
//     boolean isNotifikasiSesuai = false;
    
//     if (expectedNotification.equals("Berhasil Menambahkan Departemens")) {
//         isNotifikasiSesuai = unitSettingPage.succesAddDepartemens();
        
//     } else if (expectedNotification.equals("Gagal Menambahkan Departemens")) {
//         isNotifikasiSesuai = unitSettingPage.failAddDuplicateDepartemens();
        
//     } else if (expectedNotification.equals("Berhasil Delete Departemens")) { 
//         isNotifikasiSesuai = unitSettingPage.successDeleteDepartemens();
//     }
    
//     Assert.assertTrue(isNotifikasiSesuai, 
//         "Notifikasi '" + expectedNotification + "' tidak muncul");
// }

//     @Then("Data tetap seperti awal")
//     public void dataTetapSepertiAwal() throws InterruptedException {
//         initializeDriver();
        
//         boolean isBackToMainPage = unitSettingPage.isBackToUnitSettingMainPage();
        
//         Assert.assertTrue(isBackToMainPage, "Tidak kembali ke halaman utama Unit Setting");
//     }
// }
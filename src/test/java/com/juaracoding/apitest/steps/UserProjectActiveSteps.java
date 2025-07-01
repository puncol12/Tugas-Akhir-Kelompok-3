package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProjectActiveSteps {

    WebDriver driver;
    UserPage userPage;

    public UserProjectActiveSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        userPage = new UserPage(driver);
    }

    @And("Masukkan data untuk pencarian {string}")
    public void masukkanDataUntukPencarian(String data) throws InterruptedException {
        userPage.inputSearchData(data);
        Thread.sleep(500);
        userPage.btnSearch();
        Thread.sleep(2000);
    }

    @When("Klik Tombol User Project yang tidak aktif")
    public void klikTombolUserProjectTidakAktif() throws InterruptedException {
    userPage.clickToggleUserProject();
    Thread.sleep(1000);
}

    @Then("Muncul Notifikasi project diaktifkan")
    public void munculNotifikasiProjectDiaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationDisplayedProjectActive = userPage.isNotificationDisplayedProjectActive();
        Assert.assertTrue(isNotificationDisplayedProjectActive, "Notifikasi project diaktifkan tidak muncul");
    }
}
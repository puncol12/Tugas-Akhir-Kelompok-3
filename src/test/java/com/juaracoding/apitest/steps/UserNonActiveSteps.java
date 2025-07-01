package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserNonActiveSteps {
    
    WebDriver driver;
    UserPage userPage;

    public UserNonActiveSteps(){

        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        userPage = new UserPage(driver);
    }

    // @Given("Cari User dengan data {string}")
    // public void cariUserDenganData(String data) throws InterruptedException {
    //     userPage.inputSearchData(data);
    //     Thread.sleep(500);
    //     userPage.btnSearch();
    //     Thread.sleep(2000);
    // }

    @Given("Klik Tombol Acvite yang aktif")
    public void klikTombolUserProjectAktif() throws InterruptedException {
    //userPage.clickToggleUserProject();
    Thread.sleep(1000);
}

    @Then("Muncul Notifikasi user dinonaktifkan")
    public void munculNotifikasiProjectDinonaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationActiveNonActive = userPage.isNotificationActiveNonActive();
        Assert.assertTrue(isNotificationActiveNonActive, "Notifikasi user dinonaktifkan tidak muncul");
    }

}

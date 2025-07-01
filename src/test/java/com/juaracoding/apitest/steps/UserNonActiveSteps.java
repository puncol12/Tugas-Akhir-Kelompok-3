package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UserNonActiveSteps {
    
    WebDriver driver;
    UserPage userPage;

    public UserNonActiveSteps(){

        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        userPage = new UserPage(driver);
    }


    @Given("Klik Tombol Acvite yang aktif")
    public void klikTombolUserProjectAktif() throws InterruptedException {
    userPage.clickToggleUser();
    Thread.sleep(1000);
}

    @Then("Muncul Notifikasi user dinonaktifkan")
    public void munculNotifikasiProjectDinonaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationActiveNonActive = userPage.isNotificationActiveNonActive();
        Assert.assertTrue(isNotificationActiveNonActive, "Notifikasi user dinonaktifkan tidak muncul");
    }

}

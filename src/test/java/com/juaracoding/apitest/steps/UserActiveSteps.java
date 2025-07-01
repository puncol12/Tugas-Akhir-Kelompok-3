package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserActiveSteps {
    
    WebDriver driver;
    UserPage userPage;

    public UserActiveSteps(){
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userPage = new UserPage(driver);
    }

    @When("Klik Tombol Status Active yang tidak aktif")
    public void klikTombolUserProjectTidakAktif() throws InterruptedException {
    //userPage.clickToggleUserProject();
    Thread.sleep(1000);
}

    @Then("Muncul Notifikasi user diaktifkan")
    public void munculNotifikasiProjectDiaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationDisplayedActive = userPage.isNotificationDisplayedActive();
        Assert.assertTrue(isNotificationDisplayedActive, "Notifikasi user diaktifkan tidak muncul");
    }

}

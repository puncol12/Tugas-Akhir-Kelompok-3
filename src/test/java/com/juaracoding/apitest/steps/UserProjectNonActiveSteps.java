package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.UserPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProjectNonActiveSteps {

    WebDriver driver;
    UserPage userPage;

    public UserProjectNonActiveSteps() {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        userPage = new UserPage(driver);
    }


    @When("Klik Tombol User Project yang aktif")
    public void klikTombolUserProjectAktif() throws InterruptedException {
    userPage.clickToggleUserProject();
    Thread.sleep(1000);
}

    @Then("Muncul Notifikasi project dinonaktifkan")
    public void munculNotifikasiProjectDinonaktifkan() throws InterruptedException {
        Thread.sleep(1000);
        boolean isNotificationActiveProjectNonActive = userPage.isNotificationActiveProjectNonActive();
        Assert.assertTrue(isNotificationActiveProjectNonActive, "Notifikasi project dinonaktifkan tidak muncul");
    }
}
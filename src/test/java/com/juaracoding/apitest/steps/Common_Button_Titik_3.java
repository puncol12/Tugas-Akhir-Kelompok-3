package com.juaracoding.apitest.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.PagePosisi;

import io.cucumber.java.en.Given;

public class Common_Button_Titik_3 {

    WebDriver driver;
    PagePosisi pagePosisi;

    @Given("Klik tombol titik 3 pada salah satu data posisi")
    public void klik_tombol_titik_3() throws InterruptedException {
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pagePosisi = new PagePosisi(driver);

        Thread.sleep(1000);
        driver.navigate().refresh();
        pagePosisi.klikTombolTitik3();
    }
}

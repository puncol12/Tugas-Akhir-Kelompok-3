package com.juaracoding.apitest.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void saveScreenshot(WebDriver driver, String filePath) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        destFile.getParentFile().mkdirs(); // Buat folder kalau belum ada
        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            System.err.println("Gagal menyimpan screenshot: " + e.getMessage());
        }

    }
}

package com.juaracoding.apitest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserManager {
  public static WebDriver build() {

    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false); // nonaktifkan credential service
    prefs.put("profile.password_manager_enabled", false); // nonaktifkan password manager
    prefs.put("profile.default_content_setting_values.notifications", 2); // matikan notifikasi
    prefs.put("download.prompt_for_download", false); // Nonaktifkan pop-up konfirmasi download
    prefs.put("download.directory_upgrade", true); // Upgrade direktori download jika perlu 
    prefs.put("safebrowsing.enabled", false); // mengaktifkan peringatan safe browsing untuk file download
    prefs.put("safebrowsing.disable_download_protection", true);

    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", prefs);
    options.addArguments("--no-sandbox"); // Bypass OS security model
    options.addArguments("--disable-dev-shm-usage"); // Mengatasi masalah resource terbatas
    options.addArguments("--disable-gpu"); // Wajib untuk beberapa OS, terutama jika headless

    // options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-notifications");
    // options.addArguments("--incognito");
    options.addArguments("--start-maximized");

    return new ChromeDriver(options);
  }
}
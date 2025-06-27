package com.juaracoding.apitest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserManager {
  public static WebDriver build() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false); // nonaktifkan credential service
    prefs.put("profile.password_manager_enabled", false); // nonaktifkan password manager
    prefs.put("profile.default_content_setting_values.notifications", 2); // matikan notifikasi

    options.setExperimentalOption("prefs", prefs);

    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-notifications");
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    return new ChromeDriver(options);
  }
}

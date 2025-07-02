package com.juaracoding.apitest.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {

    public static final String ZOOM_70 = "70%";
    public static final String ZOOM_80 = "80%";
    public static final String ZOOM_90 = "90%";

    public static JavascriptExecutor javaScript(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void zoom(WebDriver driver, String percentage) throws Exception {
        JavascriptExecutor js = javaScript(driver);
        String script = "document.body.style.zoom=";

        if (percentage.equals(ZOOM_70)) {
            script = script + "'" + ZOOM_70 + "';";
        } else if (percentage.equals(ZOOM_80)) {
            script = script + "'" + ZOOM_80 + "';";
        } else if (percentage.equals(ZOOM_90)) {
            script = script + "'" + ZOOM_90 + "';";
        } else {
            throw new Exception("Zoom harus sesuai!");
        }
        js.executeScript(script);
    }

    public static void pageScroll(WebDriver driver, Map<String, Number> position) {
        JavascriptExecutor js = javaScript(driver);

        String top = position.containsKey("top") ? "top: " + position.get("top") + ", " : "";
        String bottom =
                position.containsKey("bottom") ? "bottom: " + position.get("bottom") + ", " : "";
        String left = position.containsKey("left") ? "left: " + position.get("left") + ", " : "";
        String right =
                position.containsKey("right") ? "right: " + position.get("right") + ", " : "";

        String script =
                "window.scrollTo({" + top + bottom + left + right + "behavior: 'smooth'" + "});";

        js.executeScript(script);
    }

    public static void pageScrollFullDown(WebDriver driver) {
        JavascriptExecutor js = javaScript(driver);
        js.executeScript(
                "window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
    }

    public static void pageScrollFullDownInterval(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = javaScript(driver);
        long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1500);

            long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }

    public static void pageScrollUp(WebDriver driver, int size) {
        Map<String, Number> pos = new HashMap<>();
        pos.put("top", 0);
        pos.put("left", 0);
        pos.put("bottom", size);
        pos.put("right", 0);
        pageScroll(driver, pos);
    }

    public static void pageScrollDown(WebDriver driver, int size) {
        Map<String, Number> pos = new HashMap<>();
        pos.put("top", size);
        pos.put("left", 0);
        pos.put("bottom", 0);
        pos.put("right", 0);
        pageScroll(driver, pos);
    }

    public static void pageScrollLeft(WebDriver driver, int size) {
        Map<String, Number> pos = new HashMap<>();
        pos.put("top", 0);
        pos.put("left", size);
        pos.put("bottom", 0);
        pos.put("right", 0);
        pageScroll(driver, pos);
    }

    public static void pageScrollRight(WebDriver driver, int size) {
        Map<String, Number> pos = new HashMap<>();
        pos.put("top", 0);
        pos.put("left", 0);
        pos.put("bottom", 0);
        pos.put("right", size);
        pageScroll(driver, pos);
    }

    public static void scrollDownTo(WebElement element, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = javaScript(driver);
        js.executeScript("const rect = arguments[0].getBoundingClientRect();"
                + "window.scrollBy({ top: rect.top - 100, behavior: 'smooth' });", element);
    }

    public static void scrollUpTo(WebElement element, WebDriver driver) {
        JavascriptExecutor js = javaScript(driver);
        js.executeScript(
                "const rect = arguments[0].getBoundingClientRect();"
                        + "window.scrollBy({ top: rect.bottom - 100, behavior: 'smooth' });",
                element);
    }

    public static boolean isFieldRequiredAndEmpty(WebDriver driver, WebElement element) {
        String validationMsg = getValidationMessage(driver, element);
        return validationMsg != null && !validationMsg.isEmpty();
    }

    public static boolean clearValueName(WebElement input, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        input.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        return wait.until(ExpectedConditions.attributeToBe(input, "value", ""));
    }

    public static String getValidationMessage(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", element);
    }
}

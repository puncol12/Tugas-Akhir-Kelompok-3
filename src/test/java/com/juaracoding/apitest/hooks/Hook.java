package com.juaracoding.apitest.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.utils.ConfigReader;
import com.juaracoding.apitest.utils.ScreenshotUtils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before
    public void initialize() {
        ConfigReader.loadProperties("src/test/resources/config.properties");
        DriverSingleton.createOrGetDriver();
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot =
                    ((TakesScreenshot) DriverSingleton.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
            ScreenshotUtils.saveScreenshot(DriverSingleton.driver,
                    "screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png");
        }
    }
}

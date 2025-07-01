package com.juaracoding.apitest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                // "src/test/resources/features"
                "src/test/resources/features/01_User.feature"
                // "src/test/resources/features/02_UnitCRUD.feature"
                // "src/test/resources/features/02_UnitPagination.feature"
                // "src/test/resources/features/02_UnitShiftDetail.feature"
                // "src/test/resources/features/03_UnitSettingCRUD.feature"
                // "src/test/resources/features/03_UnitSettingSelfie.feature"
                // "src/test/resources/features/03_UnitSettingPagination.feature"
                // "src/test/resources/features/04_posisiCRUD.feature"
                // "src/test/resources/features/04_posisiPagination.feature"
        },
        plugin = {
                "pretty:target/pretty.txt", "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/index.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        glue = {
                "com.juaracoding.apitest.hooks",
                "com.juaracoding.apitest.steps",
        })
public class Runner extends AbstractTestNGCucumberTests {

}

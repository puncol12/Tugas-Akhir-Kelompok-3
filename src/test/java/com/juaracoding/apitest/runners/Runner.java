package com.juaracoding.apitest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        // "src/test/resources/features/01_Unit_01.feature"
        //"src/test/resources/features/01_Unit.feature"
        // "src/test/resources/features/01_UnitSettingCRUD.feature"
        "src/test/resources/features/02_UnitSettingSelfie.feature"
        //  "src/test/resources/features/03_UnitSettingPagination.feature"
       // "src/test/resources/features/03_Unit.feature"
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

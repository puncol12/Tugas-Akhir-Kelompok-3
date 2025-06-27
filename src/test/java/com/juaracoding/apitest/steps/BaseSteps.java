package com.juaracoding.apitest.steps;

import org.openqa.selenium.WebDriver;
import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.pages.LoginPage;
import com.juaracoding.apitest.pages.UnitPage;
import com.juaracoding.apitest.pages.UnitPageAddUnit;
import com.juaracoding.apitest.pages.UnitPagePages;
import com.juaracoding.apitest.pages.UnitPageSearch;
import com.juaracoding.apitest.pages.UnitPageUnitShift;

public class BaseSteps {

    WebDriver driver;
    LoginPage loginPage;
    UnitPage unitPage;
    UnitPageAddUnit unitPageAddUnit;
    UnitPagePages unitPagePages;
    UnitPageSearch unitPageSearch;
    UnitPageUnitShift unitPageUnitShift;

    public BaseSteps() {
        this.driver = DriverSingleton.createOrGetDriver();
        
    }
}

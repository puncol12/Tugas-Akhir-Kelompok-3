package com.juaracoding.apitest.hooks;

import com.juaracoding.apitest.DriverSingleton;
import com.juaracoding.apitest.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void initialize() {
        ConfigReader.loadProperties("src/test/resources/config.properties");
        DriverSingleton.createOrGetDriver();
    }

    @After
    public void finalTeardown() {
    }
}

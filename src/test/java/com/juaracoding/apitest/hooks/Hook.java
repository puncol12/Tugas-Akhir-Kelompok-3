package com.juaracoding.apitest.hooks;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {
    @Before
    public void initialize() {
        DriverSingleton.createOrGetDriver();
    }

    @After
    public void finalTeardown() {
        // DriverSingleton.quitDriver();
    }
}

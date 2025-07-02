package com.juaracoding.apitest.listener;

import com.juaracoding.apitest.DriverSingleton;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;

public class TestExecutionListener implements EventListener, Plugin {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunFinished.class, this::afterAllTests);
    }

    private void afterAllTests(TestRunFinished event) {
        System.out.println("===> Semua feature selesai, browser di-quit...");
        DriverSingleton.quitDriver();
    }
}

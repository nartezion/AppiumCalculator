package org.example;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class TestBase {
    @BeforeTest
    public void initDriver() throws MalformedURLException {
        WebDriverRunner.setWebDriver(DesiredAppiumCapabilities.getAndroidDriver());
    }

    @AfterTest
    public void quitDriver() throws MalformedURLException {
        ((AppiumDriver)DesiredAppiumCapabilities.getAndroidDriver()).closeApp();
    }
}

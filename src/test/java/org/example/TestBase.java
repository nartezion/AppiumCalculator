package org.example;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class TestBase {

    public static WebDriver androidDriver;

    @BeforeSuite
    public void initDriver() throws MalformedURLException {
        androidDriver = DesiredAppiumCapabilities.getAndroidDriver();
        WebDriverRunner.setWebDriver(androidDriver);
    }

    @AfterSuite
    public void quitDriver() throws MalformedURLException {
        androidDriver.quit();
    }
}

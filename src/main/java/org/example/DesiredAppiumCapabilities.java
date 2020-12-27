package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DesiredAppiumCapabilities {
    public static WebDriver getAndroidDriver() throws MalformedURLException {
        org.openqa.selenium.remote.DesiredCapabilities capabilities = new org.openqa.selenium.remote.DesiredCapabilities();
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.APP,"D:\\calculator.apk");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}

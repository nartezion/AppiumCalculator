package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    @BeforeClass
    public void initDriver() throws MalformedURLException {
        WebDriverRunner.setWebDriver(DesiredAppiumCapabilities.getAndroidDriver());
    }

    @BeforeMethod
    public void closePrivacyPopUp() {
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")).should(Condition.be(Condition.visible));
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                "FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget." +
                "LinearLayout/android.widget.Button[2]")).click();
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"))
                .waitUntil(Condition.not(Condition.exist),4000L);

    }


    @AfterMethod
    public void closeWebDriver() throws MalformedURLException {
        ((AppiumDriver)DesiredAppiumCapabilities.getAndroidDriver()).resetApp();
    }

    @AfterTest
    public void quitDriver() throws MalformedURLException {
        ((AppiumDriver)DesiredAppiumCapabilities.getAndroidDriver()).quit();
    }
}

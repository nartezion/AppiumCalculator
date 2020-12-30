package org.example;


import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$;


public class MainScreenTest extends TestBase {

    @BeforeMethod
    public void closePrivacyPopUp() throws MalformedURLException {
        try {
            $(By.id("com.miui.calculator:id/message"))
                    .should(Condition.be(Condition.visible));
            $(By.id("android:id/button1")).click();
        } catch(WebDriverException stateEx){
            quitDriver();
            Assert.fail("Pop-up is not closed");
        }
    }

    @AfterMethod
    public void closeWebDriver() {
        ((AppiumDriver)androidDriver).resetApp();
        $(By.id("com.miui.calculator:id/message"))
                .should(Condition.be(Condition.visible));
    }

    @Test
    public void verifyOfSumming()
    {
        $(By.id("com.miui.calculator:id/btn_1_s")).waitUntil(Condition.appear,10000L).click();
        //Clicking 1

        $(By.id("com.miui.calculator:id/btn_plus_s")).click();
        //Clicking +

        $(By.id("com.miui.calculator:id/btn_9_s")).click();
        //Clicking 9

        $(By.id("com.miui.calculator:id/btn_equal_s")).click();
        //Clicking equals

        String result = $(By.id("com.miui.calculator:id/result")).getText().replace("=","").trim();

        Assert.assertEquals(Integer.parseInt(result),10);
    }

    @Test
    public void verifyTopNavigation(){
        $(By.id("com.miui.calculator:id/iv_tab_life")).waitUntil(Condition.appear,10000L).click();

        $(By.id("com.miui.calculator:id/action_bar_overlay_layout")).waitUntil(Condition.visible,4000L);
    }

    @Test
    public void verifyOfSubtracting(){
        $(By.id("com.miui.calculator:id/btn_9_s")).waitUntil(Condition.appear,10000L)
                .waitUntil(Condition.enabled,7000L).click();
        $(By.id("com.miui.calculator:id/btn_minus_s")).click();
        $(By.id("com.miui.calculator:id/btn_1_s")).click();
        $(By.id("com.miui.calculator:id/btn_equal_s")).click();
        String result = $(By.id("com.miui.calculator:id/result")).getText().replace("=","").trim();

        Assert.assertEquals(Integer.parseInt(result),8);
    }

}

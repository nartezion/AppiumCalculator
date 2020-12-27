package org.example;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class MainScreenTest extends TestBase {



    @Test
    public void verifyOfSumming()
    {
        $(By.id("com.miui.calculator:id/btn_1_s")).waitUntil(Condition.enabled,4000L)
                .waitUntil(Condition.visible,4000L).click();
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
        $(By.id("com.miui.calculator:id/iv_tab_life")).waitUntil(Condition.visible,4000l).click();

        $(By.id("com.miui.calculator:id/action_bar_overlay_layout")).waitUntil(Condition.visible,4000L);
    }

}

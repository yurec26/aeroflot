package org.example.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.interactable;

public class WebDriverUtil {

    public static void clearAndFillTheField(SelenideElement field,
                                            String text) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.shouldBe(interactable).sendKeys(text);
        field.pressEnter();
    }
}
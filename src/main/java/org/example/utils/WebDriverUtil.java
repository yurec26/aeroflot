package org.example.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class WebDriverUtil {

    public static void clearAndFillTheField(WebElement field,
                                            String text,
                                            WebDriverWait wait,
                                            Actions action) {
        wait.until(ExpectedConditions.visibilityOf(field));
        clearTheField(field);
        wait.until(d -> Objects
                .requireNonNull(field.getAttribute("value")).isEmpty());
        fillTgeFieldWithText(field, text, action);
    }

    public static void clearTheField(WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }

    public static void fillTgeFieldWithText(WebElement field,
                                            String text,
                                            Actions action) {
        field.sendKeys(text);
        action.sendKeys(Keys.ENTER)
                .build().perform();
    }
}

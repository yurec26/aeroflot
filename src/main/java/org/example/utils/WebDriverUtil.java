package org.example.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.codeborne.selenide.Condition.interactable;
import static org.example.utils.PropertyReader.*;

public class WebDriverUtil {

    public static void setUpDriver() {
        Configuration.browser = getBrowser().toString();
        Configuration.timeout = getTimeout();
        Configuration.headless = getHeadless();
        switch (getBrowser()) {
            case FIREFOX -> Configuration.browserCapabilities = new FirefoxOptions()
                    .addArguments(getUserAgent());
            case EDGE -> Configuration.browserCapabilities = new EdgeOptions()
                    .addArguments(getUserAgent());
            case null, default -> Configuration.browserCapabilities = new ChromeOptions()
                    .addArguments(getUserAgent());
        }
    }

    public static void clearAndFillTheField(SelenideElement field,
                                            String text) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.shouldBe(interactable).sendKeys(text);
        field.pressEnter();
    }
}
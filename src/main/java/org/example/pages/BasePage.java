package org.example.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.example.utils.PropertyReader.getTimeout;
import static org.example.utils.SingletonWebDriver.INSTANCE;

public abstract class BasePage {

    protected final WebDriverWait wait;
    protected final Actions action;

    public BasePage() {
        this.wait = new WebDriverWait(INSTANCE.getDriver(), ofSeconds(getTimeout()));
        this.action = new Actions(INSTANCE.getDriver());
        PageFactory.initElements(INSTANCE.getDriver(), this);
    }
}

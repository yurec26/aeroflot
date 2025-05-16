package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.example.utils.PropertyReader.*;

public enum SingletonWebDriver {
    INSTANCE;

    private WebDriver driver;

    private void initDriver() {
        if (driver == null) {
            switch (getBrowser()) {
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments(getBrowserMode());
                    options.addArguments(getBrowserLang());
                    options.addArguments(getWindowSize());
                    driver = new FirefoxDriver(options);
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments(getBrowserMode());
                    options.addArguments(getBrowserLang());
                    options.addArguments(getWindowSize());
                    driver = new EdgeDriver(options);
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(getBrowserMode());
                    options.addArguments(getBrowserLang());
                    options.addArguments(getWindowSize());
                    driver = new ChromeDriver(options);
                }
            }
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}


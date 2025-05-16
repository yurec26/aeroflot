package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.example.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static org.example.utils.PropertyReader.*;

public abstract class BaseTest {

    protected HomePageSteps homePageSteps;

    @BeforeSuite
    protected void suiteSetUp() {
        Configuration.browser = getBrowser().toString();
        Configuration.timeout = getTimeout();
    }

    @BeforeMethod
    protected void setUp() {
        open(getBaseUtl());
        homePageSteps = new HomePageSteps();
    }
}

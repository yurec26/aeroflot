package org.example;

import org.example.steps.HomePageSteps;
import org.example.utils.WebDriverUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static org.example.utils.PropertyReader.getBaseUtl;

public abstract class BaseTest {

    protected HomePageSteps homePageSteps;

    @BeforeSuite
    protected void suiteSetUp() {
        WebDriverUtil.setUpDriver();
    }

    @BeforeMethod
    protected void setUp() {
        open(getBaseUtl());
        homePageSteps = new HomePageSteps();
    }
}

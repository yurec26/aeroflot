package org.example;

import org.example.steps.HomePageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.example.utils.PropertyReader.getBaseUtl;
import static org.example.utils.SingletonWebDriver.INSTANCE;

public abstract class BaseTest {

    protected HomePageSteps homePageSteps;

    @BeforeMethod
    protected void setUp() {
        INSTANCE.getDriver().get(getBaseUtl());
        homePageSteps = new HomePageSteps();
    }

    @AfterMethod
    protected void tearDown() {
        INSTANCE.quitDriver();
    }
}

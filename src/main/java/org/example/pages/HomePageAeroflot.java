package org.example.pages;

import org.example.utils.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageAeroflot extends BasePage {

    @FindBy(name = "ticket-city-departure-0-booking")
    WebElement fromField;

    @FindBy(name = "ticket-city-arrival-0-booking")
    WebElement toField;

    @FindBy(xpath = "//*[@tabindex='-1']//*[contains(@class,'append')]")
    WebElement unlocodeFromField;

    @FindBy(name = "ticket-date-from-booking")
    WebElement dateToField;

    @FindBy(name = "ticket-date-to-booking")
    WebElement dateBackField;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;


    public HomePageAeroflot() {
        super();
    }

    public void fillDepartureCity(String city) {
        WebDriverUtil.clearAndFillTheField(fromField, city, wait, action);
    }

    public void fillArrivalCity(String city) {
        WebDriverUtil.clearAndFillTheField(toField, city, wait, action);
    }

    public void fillDepartureDate(String date) {
        WebDriverUtil.clearAndFillTheField(dateToField, date, wait, action);
    }

    public void fillBackDate(String date) {
        WebDriverUtil.clearAndFillTheField(dateBackField, date, wait, action);
    }

    public void pressSubmitButton() {
        submitButton.click();
    }


    public String getCityCode() {
        wait.until(ExpectedConditions.visibilityOf(unlocodeFromField));
        return unlocodeFromField.getText();
    }

    public String getDateBackField() {
        return wait.until(ExpectedConditions.visibilityOf(dateToField))
                .getAttribute("value");
    }
}

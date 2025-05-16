package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.example.utils.WebDriverUtil.clearAndFillTheField;

public class HomePageAeroflot extends BasePage {

    private final SelenideElement uniqElement = $("input#code\\&number");
    private final SelenideElement fromField = element(By.name("ticket-city-departure-0-booking"));
    private final SelenideElement toField = element(By.name("ticket-city-arrival-0-booking"));
    private final SelenideElement unlocodeFromField = $x("//*[@tabindex='-1']//*[contains(@class,'append')]");
    private final SelenideElement dateToField = element(By.name("ticket-date-from-booking"));
    private final SelenideElement dateBackField = element(By.name("ticket-date-to-booking"));
    private final SelenideElement submitButton = $x("//*[@type='submit']");
    private final SelenideElement acceptRegionButton = $("button.button.button--wide.js-notification-close");
    private final SelenideElement searchButton = $("a.main-module__header__search");

    public HomePageAeroflot() {
        super();
        uniqElement.shouldBe(visible);
    }

    public void fillDepartureCity(String city) {
        clearAndFillTheField(fromField, city);
    }

    public void fillArrivalCity(String city) {
           clearAndFillTheField(toField, city);
    }

    public void fillDepartureDate(String date) {
         clearAndFillTheField(dateToField, date);
    }

    public void fillBackDate(String date) {
              clearAndFillTheField(dateBackField, date);
    }

    public void pressSubmitButton() {
            submitButton.click();
    }

    public String getCityCode() {
        return unlocodeFromField
                .getText();
    }

    public String getDateToField() {
        return dateToField
                .getAttribute("value");
    }

    public void acceptRegion() {
        if (acceptRegionButton.exists()) {
            acceptRegionButton.click();
        }
    }

    public void clickSearchButton(){
        searchButton.shouldBe(visible).click();
    }
}

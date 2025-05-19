package org.example.element;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;
import static org.example.utils.WebDriverUtil.clearAndFillTheField;

public class TicketSearchPanel {

    private final SelenideElement fromField = element(By.name("ticket-city-departure-0-booking"));
    private final SelenideElement toField = element(By.name("ticket-city-arrival-0-booking"));
    private final SelenideElement unlocodeFromField = $x("//*[@tabindex='-1']//*[contains(@class,'append')]");
    private final SelenideElement dateToField = element(By.name("ticket-date-from-booking"));
    private final SelenideElement dateBackField = element(By.name("ticket-date-to-booking"));
    private final SelenideElement submitButton = $x("//*[@type='submit']");

    public TicketSearchPanel fillDepartureCity(String city) {
        clearAndFillTheField(fromField, city);
        return this;
    }

    public TicketSearchPanel fillArrivalCity(String city) {
        clearAndFillTheField(toField, city);
        return this;
    }

    public TicketSearchPanel fillDepartureDate(String date) {
        clearAndFillTheField(dateToField, date);
        return this;
    }

    public TicketSearchPanel fillBackDate(String date) {
        clearAndFillTheField(dateBackField, date);
        return this;
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
}

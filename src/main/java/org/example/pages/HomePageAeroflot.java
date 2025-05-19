package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.element.TicketSearchPanel;
import org.example.model.Flight;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePageAeroflot {

    private final TicketSearchPanel ticketSearchPanel = new TicketSearchPanel();
    private final SelenideElement uniqElement = $("input#code\\&number");
    private final SelenideElement acceptRegionButton = $("button.button.button--wide.js-notification-close");
    private final SelenideElement searchButton = $("a.main-module__header__search");

    public HomePageAeroflot() {
        uniqElement.shouldBe(visible);
    }

    public void searchFlights(Flight flight) {
        ticketSearchPanel.fillDepartureCity(flight.departureCity())
                .fillArrivalCity(flight.arrivalCity())
                .fillDepartureDate(flight.dateTo())
                .fillBackDate(flight.dateBack())
                .pressSubmitButton();
    }

    public void fillDepartureCity(String city) {
        ticketSearchPanel.fillDepartureCity(city);
    }

    public String getCityCode() {
        return ticketSearchPanel.getCityCode();
    }

    public String getDateToField() {
        return ticketSearchPanel.getDateToField();
    }

    public void acceptRegion() {
        if (acceptRegionButton.exists()) {
            acceptRegionButton.click();
        }
    }

    public void clickSearchButton() {
        searchButton.shouldBe(visible).click();
    }
}

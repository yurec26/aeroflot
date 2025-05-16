package org.example.steps;

import org.example.model.Flight;
import org.example.pages.HomePageAeroflot;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.utils.DateHelper.getTodayAsString;

public class HomePageSteps {

    private final HomePageAeroflot homePage = new HomePageAeroflot();

    public SearchPageSteps searchTheFlights(Flight flight) {
        homePage.fillDepartureCity(flight.departureCity());
        homePage.fillArrivalCity(flight.arrivalCity());
        homePage.fillDepartureDate(flight.dateTo());
        homePage.fillBackDate(flight.dateBack());
        homePage.pressSubmitButton();
        return new SearchPageSteps();
    }

    public void verifyCorrectUnlocode(String city, String expectedUnlocode) {
        homePage.fillDepartureCity(city);
        assertThat(homePage.getCityCode())
                .as("После выбора города отправления код города должен отобразиться корректно")
                .isEqualTo(expectedUnlocode);
    }

    public void verifyDefaultFromDateIsToday() {
        assertThat(homePage.getDateBackField())
                .as("По умолчанию должна стоять сегодняшняя дата")
                .isEqualTo(getTodayAsString());
    }
}

package org.example.steps;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.example.model.Flight;
import org.example.pages.HomePageAeroflot;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.utils.DateHelper.getTodayAsString;

public class HomePageSteps {

    private final HomePageAeroflot homePage = new HomePageAeroflot();

    @Step("Пользователь вводит валидные данные для поиска авиабилета")
    public SearchTicketsPageSteps searchTheFlights(Flight flight) {
        homePage.acceptRegion();
        homePage.searchFlights(flight);
        return new SearchTicketsPageSteps();
    }

    public void verifyCorrectUnlocode(String city, String expectedUnlocode) {
        homePage.fillDepartureCity(city);
        assertThat(homePage.getCityCode())
                .as("После выбора города отправления код города должен отобразиться корректно")
                .isEqualTo(expectedUnlocode);
    }

    public void verifyDefaultFromDateIsToday() {
        assertThat(homePage.getDateToField())
                .as("По умолчанию должна стоять сегодняшняя дата")
                .isEqualTo(getTodayAsString());
    }

    @Step("Пользователь открывает страницу поиска")
    public SearchInfoSteps openSearchInfoPage() {
        homePage.clickSearchButton();
        return new SearchInfoSteps();
    }
}

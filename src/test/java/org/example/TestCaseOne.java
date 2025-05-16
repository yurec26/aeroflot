//that
package org.example;

import org.example.model.Flight;
import org.example.providers.DataProviders;
import org.testng.annotations.Test;

public class TestCaseOne extends BaseTest {

    @Test(testName = "Проверка совпадения города и его международного кода",
            dataProvider = "cities_unlocodes",
            dataProviderClass = DataProviders.class)
    public void testCityUnlocodeIsCorrect(String city, String code) {
        homePageSteps.verifyCorrectUnlocode(city, code);
    }

    @Test(testName = "Проверка даты в поле отправления по умолчанию")
    public void testDefaultFromDate() {
        homePageSteps.verifyDefaultFromDateIsToday();
    }

    @Test(testName = "Проверка поиска билетов и проверка пути и дат на странице результатов",
            dataProvider = "flights",
            dataProviderClass = DataProviders.class)
    public void testSearchResultFlightData(Flight flight) {
        homePageSteps.searchTheFlights(flight)
                .verifyThatResultSearchRoutes(flight)
                .verifyThatResultSearchDates(flight);
    }
}

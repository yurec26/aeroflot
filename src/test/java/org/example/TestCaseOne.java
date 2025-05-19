package org.example;

import io.qameta.allure.*;
import org.example.model.Flight;
import org.example.providers.DataProviders;
import org.testng.annotations.Test;

@Epic("Поиск авиабилетов")
@Feature("Форма поиска авиабилетов с главной страницы")
public class TestCaseOne extends BaseTest {

    @Description("Проверка совпадения города и его международного кода")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "cities_unlocodes",
            dataProviderClass = DataProviders.class)
    public void testCityUnlocodeIsCorrect(String city, String code) {
        homePageSteps.verifyCorrectUnlocode(city, code);
    }

    @Description("Проверка даты в поле отправления по умолчанию")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void testDefaultFromDate() {
        homePageSteps.verifyDefaultFromDateIsToday();
    }

    @Description("Проверка поиска билетов и проверка пути и дат на странице результатов")
    @Story("Пользователь производит поиск билетов с валидными данными")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "flights",
            dataProviderClass = DataProviders.class)
    public void testSearchResultFlightData(Flight flight) {
        homePageSteps.searchTheFlights(flight)
                .verifyThatResultSearchRoutes(flight)
                .verifyThatResultSearchDates(flight);
    }
}

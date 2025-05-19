package org.example.steps;

import org.example.model.Flight;
import org.example.pages.SearchResultPageAeroflot;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class SearchTicketsPageSteps {

    private final SearchResultPageAeroflot searchResultPage = new SearchResultPageAeroflot();

    public SearchTicketsPageSteps verifyThatResultSearchRoutes(Flight testFlight) {
        String actualRouteTo = searchResultPage.getSearchResultFlightHeader().getFirst();
        String actualRouteBack = searchResultPage.getSearchResultFlightHeader().get(1);
        String expectedRouteTo = testFlight.departureCity() + " — " + testFlight.arrivalCity();
        String expectedRouteBack = testFlight.arrivalCity() + " — " + testFlight.departureCity();
        assertSoftly(softly -> {
            softly.assertThat(actualRouteTo)
                    .as("Сформированный путь 'ТУДА' должен совпадать с искомым")
                    .isEqualTo(expectedRouteTo);
            softly.assertThat(actualRouteBack)
                    .as("Сформированный путь 'ОБРАТНО' должен совпадать с искомым")
                    .isEqualTo(expectedRouteBack);
        });
        return this;
    }

    public SearchTicketsPageSteps verifyThatResultSearchDates(Flight testFlight) {
        String actualDateTo = searchResultPage.getPickedDates().getFirst().split(" ")[0];
        String actualDateBack = searchResultPage.getPickedDates().get(1).split(" ")[0];
        String expectedDateTo = testFlight.dateTo().split("[^\\w\\s]+")[0];
        String expectedDateBack = testFlight.dateBack().split("[^\\w\\s]+")[0];
        assertSoftly(softly -> {
            softly.assertThat(actualDateTo)
                    .as("Должна быть выбрана и подсвечена искомая дата 'ТУДА'")
                    .isEqualTo(expectedDateTo);
            softly.assertThat(actualDateBack)
                    .as("Должна быть выбрана и подсвечена искомая дата 'Обратно'")
                    .isEqualTo(expectedDateBack);
        });
        return this;
    }
}

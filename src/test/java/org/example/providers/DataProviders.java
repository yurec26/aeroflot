package org.example.providers;

import org.testng.annotations.DataProvider;

import static org.example.utils.DataReader.*;

public class DataProviders {

    @DataProvider(name = "cities_unlocodes")
    public Object[][] citiesProvider() {
        return getTestCities().stream()
                .map(city -> new Object[]{city.name(), city.unlocode()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "flights")
    public Object[] flightProvider() {
        return getTestFlight().toArray();
    }

    @DataProvider(name = "keyword")
    public Object[] keywordProvider() {
        return getTestKeywords().toArray();
    }
}

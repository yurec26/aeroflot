package org.example.providers;

import org.testng.annotations.DataProvider;

import static org.example.utils.DataReader.getTestCities;
import static org.example.utils.DataReader.getTestFlight;

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
}

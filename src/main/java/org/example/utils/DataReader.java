package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.City;
import org.example.model.Flight;
import org.example.model.Keyword;

import java.io.File;
import java.util.List;

public class DataReader {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String TEST_DATA_CITIES_FILE = "src/main/resources/test_data_cities.json";
    private static final String TEST_DATA_FLIGHT_FILE = "src/main/resources/test_data_flight.json";
    private static final String TEST_DATA_KEYWORDS_FILE = "src/main/resources/test_data_keyword.json";

    public static List<City> getTestCities() {
        return readFile(City.class, TEST_DATA_CITIES_FILE);
    }

    public static List<Flight> getTestFlight() {
        return readFile(Flight.class, TEST_DATA_FLIGHT_FILE);
    }

    public static List<Keyword> getTestKeywords() {
        return readFile(Keyword.class, TEST_DATA_KEYWORDS_FILE);
    }

    public static <C> List<C> readFile(Class<C> type, String filePath) {
        try {
            File file = new File(filePath);
            return MAPPER.readValue(file, MAPPER
                    .getTypeFactory()
                    .constructCollectionType(List.class, type));
        } catch (Exception e) {
            throw new RuntimeException("Unable to locate or parse Json file %s".formatted(filePath));
        }
    }
}




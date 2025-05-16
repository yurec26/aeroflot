package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.City;
import org.example.model.Flight;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataReader {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String TEST_DATA_CITIES_FILE = "src/main/resources/test_data_cities.json";
    private static final String TEST_DATA_FLIGHT_FILE = "src/main/resources/test_data_flight.json";
    private static final String TEST_DATA_KEYWORDS_FILE = "src/main/resources/test_data_keyword.json";

    public static List<City> getTestCities() {
        return readFile(City.class, TEST_DATA_CITIES_FILE);
//        try {
//            File file = new File(TEST_DATA_CITIES_FILE);
//            return MAPPER.readValue(file,
//                    MAPPER.getTypeFactory().constructCollectionType(List.class, City.class));
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to locate file %s".formatted(TEST_DATA_CITIES_FILE));
//        }
    }

    public static List<Flight> getTestFlight() {
        return readFile(Flight.class, TEST_DATA_FLIGHT_FILE);
//        try {
//            File file = new File(TEST_DATA_FLIGHT_FILE);
//            return MAPPER.readValue(file,
//                    MAPPER.getTypeFactory().constructCollectionType(List.class, Flight.class));
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to locate file %s".formatted(TEST_DATA_FLIGHT_FILE));
//        }
    }

    public static List<String> getTestKeywords() {
        return readFile(String.class, TEST_DATA_KEYWORDS_FILE);

//        try {
//            File file = new File(TEST_DATA_KEYWORDS_FILE);
//            return MAPPER.readValue(file,
//                    MAPPER.getTypeFactory().constructCollectionType(List.class, String.class));
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to locate file %s".formatted(TEST_DATA_KEYWORDS_FILE));
//        }
    }

    public  static <C> List<C>  readFile(Class<C> type, String filePath) {
        try {
            File file = new File(filePath);
            return MAPPER.readValue(file,
                    MAPPER.getTypeFactory().constructCollectionType(List.class, type));
        } catch (IOException e) {
            throw new RuntimeException("Unable to locate file %s".formatted(filePath));
        }
    }


}




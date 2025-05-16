package org.example.utils;

import org.example.enam.Browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    public static String getBaseUtl() {
        return getProperty("base_aeroflot_url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }

    public static Integer getTimeout() {
        return Integer.valueOf(getProperty("timeout"));
    }

    public static Boolean getHeadless() {
        return Boolean.valueOf(getProperty("headless"));
    }

    public static String getUserAgent(){
        return getProperty("user_agent");
    }

    public static String getProperty(String property) {
        return System.getProperty(property) == null
                ? readFromFile(CONFIG_FILE, property) :
                System.getProperty(property);
    }


    private static String readFromFile(String filename, String propName) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(filename)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file / File hasn't been found");
        }
        return properties.getProperty(propName);
    }
}

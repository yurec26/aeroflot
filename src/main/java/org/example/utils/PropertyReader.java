package org.example.utils;

import org.example.enam.Browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    public static String getBaseUtl() {
        return readFromFile(CONFIG_FILE, "base_aeroflot_url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(readFromFile(CONFIG_FILE, "browser"));
    }

    public static String getBrowserLang() {
        return readFromFile(CONFIG_FILE, "browser_lang");
    }

    public static String getWindowSize() {
        return readFromFile(CONFIG_FILE, "window_size");
    }

    public static String getBrowserMode() {
        return readFromFile(CONFIG_FILE, "browser_mode");
    }

    public static Integer getTimeout() {
        return Integer.valueOf(readFromFile(CONFIG_FILE, "timeout"));
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

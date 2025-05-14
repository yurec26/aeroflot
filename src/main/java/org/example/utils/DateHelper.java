package org.example.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static String getTodayAsString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}

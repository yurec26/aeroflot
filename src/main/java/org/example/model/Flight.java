package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Flight(
        @JsonProperty("city_from")
        String departureCity,
        @JsonProperty("city_to")
        String arrivalCity,
        @JsonProperty("date_to")
        String dateTo,
        @JsonProperty("date_back")
        String dateBack
) {
}

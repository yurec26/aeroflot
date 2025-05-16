package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record City(
        @JsonProperty("city")
        String name,
        @JsonProperty("city_code")
        String unlocode
) {
}

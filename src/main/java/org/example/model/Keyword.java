package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Keyword (
        @JsonProperty("keyword")
        String keyword
) {
}

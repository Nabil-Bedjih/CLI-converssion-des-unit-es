package fr.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {
    @JsonProperty("from")
    private String from;
    @JsonProperty("conversion")
    private List<Conversion> conversion;

    public String getFrom() {
        return from;
    }

    public List<Conversion> getConversion() {
        return conversion;
    }
}

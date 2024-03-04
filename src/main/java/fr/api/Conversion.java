package fr.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conversion {
    @JsonProperty("to")
    private String to;
    @JsonProperty("date")
    private String date;
    @JsonProperty("rate")
    private double rate;

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public double getRate() {
        return rate;
    }
}

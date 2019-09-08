package com.kodilla.holiday.facade.flight;

public class FlightProcessingException extends Exception {
    public static final String ERR_SUBMITTING_ERROR = "Cannot submit flight!";

    public FlightProcessingException(String message) {
        super(message);
    }
}
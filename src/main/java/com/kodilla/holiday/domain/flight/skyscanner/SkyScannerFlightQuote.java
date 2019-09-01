package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SkyScannerFlightQuote {
    private String country;
    private String currency;
    private String locale;
    private String originplace;
    private String destinationplace;
    private String outbounddate;
    private String inbounddate;
}

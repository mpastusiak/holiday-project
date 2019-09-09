package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkyScannerFlightQuoteResponse {
    private List<SkyScannerFlightQuotesList> quotes;
    private List<SkyScannerFlightPlace> places;
    private List<SkyScannerFlightCarrier> carriers;
    private List<SkyScannerFlightCurrency> currencies;
}

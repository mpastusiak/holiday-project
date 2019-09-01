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
    private List<SkyScannerFlightPlacesList> places;
    private List<SkyScannerFlightCarriersList> carriers;
    private List<SkyScannerFlightCurrencies> currencies;
}

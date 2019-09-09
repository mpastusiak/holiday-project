package com.kodilla.holiday.domain.flight.skyscanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyScannerFlightQuoteResponseDto {
    @JsonProperty("Quotes")
    private List<SkyScannerFlightQuotesListDto> quotes;

    @JsonProperty("Places")
    private List<SkyScannerFlightPlaceDto> places;

    @JsonProperty("Carriers")
    private List<SkyScannerFlightCarrierDto> carriers;

    @JsonProperty("Currencies")
    private List<SkyScannerFlightCurrencyDto> currencies;
}

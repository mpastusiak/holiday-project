package com.kodilla.holiday.domain.flight.skyscanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyScannerFlightCurrencyDto {
    @JsonProperty("Code")
    private String code;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("ThousandsSeparator")
    private String thousandsSeparator;

    @JsonProperty("DecimalSeparator")
    private String decimalSeparator;

    @JsonProperty("SymbolOnLeft")
    private Boolean symbolOnLeft;

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    private Boolean spaceBetweenAmountAndSymbol;

    @JsonProperty("RoundingCoefficient")
    private String roundingCoefficient;

    @JsonProperty("DecimalDigits")
    private String decimalDigits;
}

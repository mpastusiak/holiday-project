package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkyScannerFlightCurrencies {
    private String code;
    private String symbol;
    private String thousandsSeparator;
    private String decimalSeparator;
    private Boolean symbolOnLeft;
    private Boolean spaceBetweenAmountAndSymbol;
    private String roundingCoefficient;
    private String decimalDigits;
}

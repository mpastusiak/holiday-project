package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkyScannerFlightQuotesList {
    private String quoteId;
    private BigDecimal minPrice;
    private Boolean direct;
    private SkyScannerFlightOutboundLeg outboundLeg;
    private SkyScannerFlightInboundLeg inboundLeg;
    private String quoteDateTime;

}

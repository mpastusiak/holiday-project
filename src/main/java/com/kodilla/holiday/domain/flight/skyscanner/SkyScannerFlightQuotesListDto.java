package com.kodilla.holiday.domain.flight.skyscanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyScannerFlightQuotesListDto {
    @JsonProperty("QuoteId")
    private String quoteId;

    @JsonProperty("MinPrice")
    private BigDecimal minPrice;

    @JsonProperty("Direct")
    private Boolean direct;

    @JsonProperty("OutboundLeg")
    private SkyScannerFlightOutboundLegDto outboundLeg;

    @JsonProperty("InboundLeg")
    private SkyScannerFlightInboundLegDto inboundLeg;

    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;

}

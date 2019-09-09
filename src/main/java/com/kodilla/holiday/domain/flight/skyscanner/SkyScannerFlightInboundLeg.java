package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkyScannerFlightInboundLeg {
    private List<String> carrierIds;
    private String originId;
    private String destinationId;
    private String departureDate;
}

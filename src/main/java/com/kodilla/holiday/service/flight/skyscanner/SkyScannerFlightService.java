package com.kodilla.holiday.service.flight.skyscanner;

import com.kodilla.holiday.client.flight.skyscanner.SkyScannerFlightClient;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkyScannerFlightService {
    @Autowired
    SkyScannerFlightClient client;

    public SkyScannerFlightQuoteResponseDto getSkyScannerFlightResponse(String originPlace, String destinationPlace,
                                                                             String outboundPartialDate, String inboundPartialDate) {
        System.out.println("Wykonuje service " + originPlace + destinationPlace + outboundPartialDate + inboundPartialDate);
        return client.getSkyScannerFlightQuoteResponse(originPlace, destinationPlace, outboundPartialDate, inboundPartialDate);
    }
}

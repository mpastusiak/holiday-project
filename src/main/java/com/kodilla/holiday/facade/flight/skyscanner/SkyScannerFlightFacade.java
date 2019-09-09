package com.kodilla.holiday.facade.flight.skyscanner;

import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponse;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import com.kodilla.holiday.mapper.flight.skyscanner.SkyScannerFlightMapper;
import com.kodilla.holiday.service.flight.skyscanner.SkyScannerFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkyScannerFlightFacade {
    @Autowired
    private SkyScannerFlightService service;

    @Autowired
    private SkyScannerFlightMapper mapper;

    public SkyScannerFlightQuoteResponseDto getSkyScannerFlightResponse(String originPlace, String destinationPlace,
                                                                        String outboundPartialDate, String inboundPartialDate) {
        SkyScannerFlightQuoteResponse response =
                mapper.mapToSkyScannerFlightQuoteResponse(service.getSkyScannerFlightResponse(originPlace,
                        destinationPlace, outboundPartialDate, inboundPartialDate));
        return mapper.mapToSkyScannerFlightQuoteResponseDto(response);
    }
}

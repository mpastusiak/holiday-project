package com.kodilla.holiday.controller.flight.skyscanner;

import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import com.kodilla.holiday.facade.flight.skyscanner.SkyScannerFlightFacade;
import com.kodilla.holiday.mapper.flight.skyscanner.SkyScannerFlightMapper;
import com.kodilla.holiday.service.flight.skyscanner.SkyScannerFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class SkyScannerFlightsController {

    @Autowired
    private SkyScannerFlightMapper mapper;

    @Autowired
    private SkyScannerFlightService service;

    @Autowired
    private SkyScannerFlightFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/skyscanner/flight/{originPlace}/{destinationPlace}/{outboundPartialDate}/{inboundPartialDate}")
    public SkyScannerFlightQuoteResponseDto getResponse(@PathVariable String originPlace, @PathVariable String destinationPlace,
                                                        @PathVariable String outboundPartialDate, @PathVariable String inboundPartialDate) {
        System.out.println("Wykonuje controller " + originPlace + destinationPlace + outboundPartialDate + inboundPartialDate);
        return facade.getSkyScannerFlightResponse(originPlace, destinationPlace,
                outboundPartialDate, inboundPartialDate);
    }

}

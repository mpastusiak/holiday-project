package com.kodilla.holiday.controller.flight.skyscanner;

import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import com.kodilla.holiday.facade.flight.skyscanner.SkyScannerFlightFacade;
import com.kodilla.holiday.mapper.flight.SkyScannerFlightToFlightMapper;
import com.kodilla.holiday.mapper.flight.skyscanner.SkyScannerFlightMapper;
import com.kodilla.holiday.service.flight.skyscanner.SkyScannerFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flight/skyscanner")
@CrossOrigin("*")
public class SkyScannerFlightsController {

    @Autowired
    private SkyScannerFlightMapper mapper;

    @Autowired
    private SkyScannerFlightService service;

    @Autowired
    private SkyScannerFlightToFlightMapper ssToFlightMapper;

    @Autowired
    private SkyScannerFlightFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/{originPlace}/{destinationPlace}/{outboundPartialDate}/{inboundPartialDate}")
    public SkyScannerFlightQuoteResponseDto getResponse(@PathVariable String originPlace, @PathVariable String destinationPlace,
                                                        @PathVariable String outboundPartialDate, @PathVariable String inboundPartialDate) {
        return facade.getSkyScannerFlightResponse(originPlace, destinationPlace,
                outboundPartialDate, inboundPartialDate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/toFlight/{originPlace}/{destinationPlace}/{outboundPartialDate}/{inboundPartialDate}")
    public List<TheFlightDto> getResponseByFlight(@PathVariable String originPlace, @PathVariable String destinationPlace,
                                                  @PathVariable String outboundPartialDate, @PathVariable String inboundPartialDate) {
        return ssToFlightMapper.mapToFlightDto(facade.getSkyScannerFlightResponse(originPlace, destinationPlace,
                outboundPartialDate, inboundPartialDate));
    }

}

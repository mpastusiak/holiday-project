package com.kodilla.holiday.controller.flight;

import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.kodilla.holiday.facade.flight.FlightFacade;
import com.kodilla.holiday.mapper.flight.FlightMapper;
import com.kodilla.holiday.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/flight/flight")
public class FlightController {
    @Autowired
    private FlightService service;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<TheFlightDto> getFlights() {
        return flightMapper.mapToTheFlightDtoList(service.getAllFlights());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{flightId}")
    public TheFlightDto getFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        return flightMapper.mapToTheFlightDto(service.getFlight(flightId).orElseThrow(FlightNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {
        service.deleteFlight(flightId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public TheFlightDto updateFlight(@RequestBody TheFlightDto theFlightDto) {
        return flightMapper.mapToTheFlightDto(service.saveFlight(flightMapper.mapToTheFlight(theFlightDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = APPLICATION_JSON_VALUE)
    public void createFlight(@RequestBody TheFlightDto theFlightDto) {
        facade.createFlight(theFlightDto);
    }

}

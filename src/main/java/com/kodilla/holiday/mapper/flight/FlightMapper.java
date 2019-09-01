package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {
    @Autowired
    private CarrierMapper carrierMapper;

    @Autowired
    private PlaceMapper placeMapper;

    public TheFlight mapToTheFlight(TheFlightDto theFlightDto) {
        return new TheFlight(theFlightDto.getId(), placeMapper.mapToOrigin(theFlightDto.getOrigin_id()),
                placeMapper.mapToDestination(theFlightDto.getDestination_id()), theFlightDto.getDepartureDate(),
                theFlightDto.isDirect(), theFlightDto.getMinPrice(),
                carrierMapper.mapToCarrier(theFlightDto.getCarriersList()));
    }

    public TheFlightDto mapToTheFlightDto(TheFlight theFlight) {
        return new TheFlightDto(theFlight.getId(), placeMapper.mapToPlaceDto(theFlight.getOrigin_id()),
                placeMapper.mapToPlaceDto(theFlight.getDestination_id()),
                theFlight.getDepartureDate(), theFlight.isDirect(), theFlight.getMinPrice(),
                carrierMapper.mapToCarrierDto(theFlight.getCarriersList()));
    }
}

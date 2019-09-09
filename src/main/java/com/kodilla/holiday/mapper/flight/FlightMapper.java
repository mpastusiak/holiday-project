package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.TheFlight;
import com.kodilla.holiday.domain.flight.TheFlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {
    @Autowired
    private CarrierMapper carrierMapper;

    @Autowired
    private PlaceMapper placeMapper;

    public TheFlight mapToTheFlight(TheFlightDto theFlightDto) {
        return new TheFlight(theFlightDto.getFlightId(), placeMapper.mapToOriginList(theFlightDto.getOriginsList()),
                placeMapper.mapToDestinationList(theFlightDto.getDestinationsList()), theFlightDto.getDepartureDate(),
                theFlightDto.getReturnDate(), theFlightDto.isDirect(), theFlightDto.getMinPrice(),
                carrierMapper.mapToCarrierList(theFlightDto.getCarriersList()));
    }

    public TheFlightDto mapToTheFlightDto(TheFlight theFlight) {
        return new TheFlightDto(theFlight.getFlightId(), placeMapper.mapOriginsToPlaceDtoList(theFlight.getOriginsList()),
                placeMapper.mapDestinationsToPlaceDtoList(theFlight.getDestinationsList()),
                theFlight.getDepartureDate(), theFlight.getReturnDate(), theFlight.isDirect(),
                theFlight.getMinPrice(), carrierMapper.mapToCarrierDtoList(theFlight.getCarriersList()));
    }

    public List<TheFlightDto> mapToTheFlightDtoList(List<TheFlight> theFlightList) {
        return theFlightList.stream()
                .map(flight -> new TheFlightDto(flight.getFlightId(), placeMapper.mapOriginsToPlaceDtoList(flight.getOriginsList()),
                        placeMapper.mapDestinationsToPlaceDtoList(flight.getDestinationsList()),
                        flight.getDepartureDate(), flight.getReturnDate(), flight.isDirect(),
                        flight.getMinPrice(), carrierMapper.mapToCarrierDtoList(flight.getCarriersList())))
                .collect(Collectors.toList());
    }
}

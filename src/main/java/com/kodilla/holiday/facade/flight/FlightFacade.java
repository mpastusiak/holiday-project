package com.kodilla.holiday.facade.flight;

import com.kodilla.holiday.domain.flight.*;
import com.kodilla.holiday.mapper.flight.CarrierMapper;
import com.kodilla.holiday.mapper.flight.FlightMapper;
import com.kodilla.holiday.mapper.flight.PlaceMapper;
import com.kodilla.holiday.service.flight.CarrierService;
import com.kodilla.holiday.service.flight.FlightService;
import com.kodilla.holiday.service.flight.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FlightFacade {
    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceMapper placeMapper;

    @Autowired
    private CarrierService carrierService;

    @Autowired
    private CarrierMapper carrierMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightFacade.class);

    public void createFlight(TheFlightDto theFlightDto) {
        boolean wasError = false;

        List<PlaceDto> origins = theFlightDto.getOriginsList();
        List<PlaceDto> destinations = theFlightDto.getDestinationsList();

        theFlightDto.setOriginsList(validatePlaceDtoList(origins));
        theFlightDto.setDestinationsList(validatePlaceDtoList(destinations));

        List<CarrierDto> carriers = theFlightDto.getCarriersList();
        theFlightDto.setCarriersList(validateCarrierDtoList(carriers));

        flightService.saveFlight(flightMapper.mapToTheFlight(theFlightDto));
    }

    private List<PlaceDto> validatePlaceDtoList(List<PlaceDto> placesDto) {
        List<PlaceDto> newPlacesDto = new ArrayList<>();
        Iterator<PlaceDto> placeDtoIterator = placesDto.iterator();
        while (placeDtoIterator.hasNext()) {
            PlaceDto placeDto = placeDtoIterator.next();
            String placePartnerId = placeDto.getPlacePartnerId();
            Place place = placeService.findPlace(placePartnerId).orElse(null);

            if(place == null) {
                placeService.savePlace(placeMapper.mapToOrigin(placeDto));
                place = placeService.findPlace(placePartnerId).orElse(new Place());
            }

            placeDto = placeMapper.mapToPlaceDto(place);
            newPlacesDto.add(placeDto);
        }
        return newPlacesDto;
    }

    private List<CarrierDto> validateCarrierDtoList(List<CarrierDto> carriersDto) {
        List<CarrierDto> newCarrierDto = new ArrayList<>();
        Iterator<CarrierDto> carrierDtoIterator = carriersDto.iterator();
        while (carrierDtoIterator.hasNext()) {
            CarrierDto carrierDto = carrierDtoIterator.next();
            String carrierPartnerId = carrierDto.getCarrierPartnerId();
            Carrier carrier = carrierService.findCarrier(carrierPartnerId).orElse(null);

            if(carrier == null) {
                carrierService.saveCarrier(carrierMapper.mapToCarrier(carrierDto));
                carrier = carrierService.findCarrier(carrierPartnerId).orElse(new Carrier());
            }

            carrierDto = carrierMapper.mapToCarrierDto(carrier);
            newCarrierDto.add(carrierDto);
        }
        return newCarrierDto;
    }
}

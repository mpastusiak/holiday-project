package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.Destination;
import com.kodilla.holiday.domain.flight.Origin;
import com.kodilla.holiday.domain.flight.Place;
import com.kodilla.holiday.domain.flight.PlaceDto;
import org.mapstruct.IterableMapping;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

public class PlaceMapper {
    public Destination mapToDestination(PlaceDto placeDto) {
        Destination destination = new Destination();
        destination.setPlace_id(placeDto.getPlace_id());
        destination.setIataCode(placeDto.getIataCode());
        destination.setPlaceName(placeDto.getPlaceName());
        destination.setCityName(placeDto.getCityName());
        destination.setCountryName(placeDto.getCountryName());
        destination.getFlightsList();
        return destination;
    }

    public Origin mapToOrigin(PlaceDto placeDto) {
        Origin origin = new Origin();
        origin.setPlace_id(placeDto.getPlace_id());
        origin.setIataCode(placeDto.getIataCode());
        origin.setPlaceName(placeDto.getPlaceName());
        origin.setCityName(placeDto.getCityName());
        origin.setCountryName(placeDto.getCountryName());
        origin.getFlightsList();
        return origin;
    }

    public PlaceDto mapToPlaceDto(Destination destination) {
        return new PlaceDto(destination.getPlace_id(), destination.getIataCode(), destination.getPlaceName(),
                destination.getCityName(), destination.getCountryName());
    }

    public PlaceDto mapToPlaceDto(Origin origin) {
        return new PlaceDto(origin.getPlace_id(), origin.getIataCode(), origin.getPlaceName(), origin.getCityName(),
                origin.getCountryName());
    }
}

package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.Destination;
import com.kodilla.holiday.domain.flight.Origin;
import com.kodilla.holiday.domain.flight.Place;
import com.kodilla.holiday.domain.flight.PlaceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceMapper {
    public Destination mapToDestination(PlaceDto placeDto) {
        Destination destination = new Destination();
        destination.setPlaceId(placeDto.getPlaceId());
        destination.setPlacePartnerId(destination.getPlacePartnerId());
        destination.setIataCode(placeDto.getIataCode());
        destination.setPlaceName(placeDto.getPlaceName());
        destination.setCityName(placeDto.getCityName());
        destination.setCountryName(placeDto.getCountryName());
        destination.getFlightsList();
        return destination;
    }

    public Origin mapToOrigin(PlaceDto placeDto) {
        Origin origin = new Origin();
        origin.setPlaceId(placeDto.getPlaceId());
        origin.setPlacePartnerId(placeDto.getPlacePartnerId());
        origin.setIataCode(placeDto.getIataCode());
        origin.setPlaceName(placeDto.getPlaceName());
        origin.setCityName(placeDto.getCityName());
        origin.setCountryName(placeDto.getCountryName());
        origin.getFlightsList();
        return origin;
    }

    public Place mapToPlace(PlaceDto placeDto) {
        Place place = new Place();
        place.setPlaceId(placeDto.getPlaceId());
        place.setPlacePartnerId(placeDto.getPlacePartnerId());
        place.setIataCode(placeDto.getIataCode());
        place.setPlaceName(placeDto.getPlaceName());
        place.setCityName(placeDto.getCityName());
        place.setCountryName(placeDto.getCountryName());
        return place;
    }

    public PlaceDto mapToPlaceDto(Destination destination) {
        return new PlaceDto(destination.getPlaceId(), destination.getPlacePartnerId(), destination.getIataCode(),
                destination.getPlaceName(), destination.getCityName(), destination.getCountryName());
    }

    public PlaceDto mapToPlaceDto(Origin origin) {
        return new PlaceDto(origin.getPlaceId(), origin.getPlacePartnerId(), origin.getIataCode(), origin.getPlaceName(),
                origin.getCityName(), origin.getCountryName());
    }

    public PlaceDto mapToPlaceDto(Place place) {
        return new PlaceDto(place.getPlaceId(), place.getPlacePartnerId(), place.getIataCode(), place.getPlaceName(),
                place.getCityName(), place.getCountryName());
    }

    public List<PlaceDto> mapDestinationsToPlaceDtoList(List<Destination> destinations) {
        return destinations.stream()
                .map(place -> mapToPlaceDto(place))
                .collect(Collectors.toList());
    }

    public List<PlaceDto> mapOriginsToPlaceDtoList(List<Origin> origins) {
        return origins.stream()
                .map(place -> mapToPlaceDto(place))
                .collect(Collectors.toList());
    }

    public List<PlaceDto> mapPlacesToPlaceDtoList(List<Place> places) {
        return places.stream()
                .map(place -> mapToPlaceDto(place))
                .collect(Collectors.toList());
    }

    public List<Destination> mapToDestinationList(List<PlaceDto> places) {
        return places.stream()
                .map(destination -> mapToDestination(destination))
                .collect(Collectors.toList());
    }

    public List<Origin> mapToOriginList(List<PlaceDto> places) {
        return places.stream()
                .map(origin -> mapToOrigin(origin))
                .collect(Collectors.toList());
    }
}

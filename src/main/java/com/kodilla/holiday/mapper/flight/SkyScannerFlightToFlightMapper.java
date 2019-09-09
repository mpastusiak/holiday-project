package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.CarrierDto;
import com.kodilla.holiday.domain.flight.PlaceDto;
import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightCarrierDto;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightPlaceDto;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkyScannerFlightToFlightMapper {

    private SkyScannerFlightQuoteResponseDto ssFlight;

    public List<TheFlightDto> mapToFlightDto(SkyScannerFlightQuoteResponseDto skyScannerFlight) {
        ssFlight = skyScannerFlight;
        List<PlaceDto> originDtoList = new ArrayList<>();
        List<PlaceDto> destinationDtoList = new ArrayList<>();
        List<CarrierDto> carrierDtoList = new ArrayList<>();
        List<TheFlightDto> flightDtoList = new ArrayList<>();
        for (int i = 0; i < skyScannerFlight.getQuotes().size(); i++) {
            originDtoList.clear();
            originDtoList.add(mapToOriginDto(skyScannerFlight).get(i));
            destinationDtoList.clear();
            destinationDtoList.add(mapToDestinationDto(skyScannerFlight).get(i));
            carrierDtoList.clear();
            carrierDtoList.addAll(mapToDirectCarrierDto(skyScannerFlight).get(i));
            carrierDtoList.addAll(mapToReturnCarrierDto(skyScannerFlight).get(i));

            flightDtoList.add(new TheFlightDto(new Long(i+1), originDtoList, destinationDtoList,
                    mapToDepartureDate(skyScannerFlight).get(i), mapToReturnDate(skyScannerFlight).get(i),
                    mapToDirect(skyScannerFlight).get(i), mapToMinPrice(skyScannerFlight).get(i),
                    carrierDtoList));
        }
        return flightDtoList;
    }

    public List<PlaceDto> mapToOriginDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssPlaceToPlaceDto(ssPlaceIdsToSsPlace(mapFromOriginLegToSsPlaceIds(ssFlight)));
    }

    public List<PlaceDto> mapToDestinationDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssPlaceToPlaceDto(ssPlaceIdsToSsPlace(mapFromDestinationLegToSsPlaceIds(ssFlight)));
    }

    public List<String> mapFromOriginLegToSsPlaceIds(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(outboundLeg -> outboundLeg.getOutboundLeg().getOriginId())
                .collect(Collectors.toList());
    }

    public List<String> mapFromDestinationLegToSsPlaceIds(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(inboundLeg -> inboundLeg.getOutboundLeg().getDestinationId())
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightPlaceDto> ssPlaceIdsToSsPlace(List<String> ssPlaceIds) {
        return ssPlaceIds.stream()
                .map(m -> {
                    return ssFlight.getPlaces().stream()
                            .filter(p -> p.getPlaceId().equals(m))
                            .findFirst()
                            .get();
                })
                .collect(Collectors.toList());
    }

    public List<PlaceDto> ssPlaceToPlaceDto(List<SkyScannerFlightPlaceDto> ssPlaceList) {
        return ssPlaceList.stream()
                .map(place -> {
                    PlaceDto placeDto = new PlaceDto();
                    placeDto.setPlacePartnerId(place.getPlaceId());
                    placeDto.setIataCode(place.getIatacode());
                    placeDto.setPlaceName(place.getName());
                    placeDto.setCityName(place.getCityName());
                    placeDto.setCountryName(place.getCountryName());
                    return placeDto; })
                .collect(Collectors.toList());
    }

    public List<String> mapToDepartureDate(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getOutboundLeg().getDepartureDate())
                .collect(Collectors.toList());
    }

    public List<String> mapToReturnDate(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getInboundLeg().getDepartureDate())
                .collect(Collectors.toList());
    }

    public List<Boolean> mapToDirect(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getDirect())
                .collect(Collectors.toList());
    }

    public List<BigDecimal> mapToMinPrice(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getMinPrice())
                .collect(Collectors.toList());
    }

    public List<List<CarrierDto>> mapToDirectCarrierDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        return sSCarriersDtoToCarriersDto(ssCarrierIdsToSsCarriersDto(ssFlightTossDirectCarriersId(ssFlight)));
    }

    public List<List<CarrierDto>> mapToReturnCarrierDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        return sSCarriersDtoToCarriersDto(ssCarrierIdsToSsCarriersDto(ssFlightTossReturnCarriersId(ssFlight)));
    }

    public List<List<String>> ssFlightTossDirectCarriersId(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(f -> f.getOutboundLeg().getCarrierIds())
                .peek(k -> System.out.println(k))
                .collect(Collectors.toList());
    }

    public List<List<String>> ssFlightTossReturnCarriersId(SkyScannerFlightQuoteResponseDto ssFlight) {
        return ssFlight.getQuotes().stream()
                .map(f -> f.getInboundLeg().getCarrierIds())
                .peek(k -> System.out.println(k))
                .collect(Collectors.toList());
    }


    public List<List<SkyScannerFlightCarrierDto>> ssCarrierIdsToSsCarriersDto(List<List<String>> ssCarrierIds) {
        return ssCarrierIds.stream()
                .map(f -> {
                    List<SkyScannerFlightCarrierDto> ssCarrierList = new ArrayList<>();
                    ssCarrierList.addAll(f.stream()
                            .map(k -> ssCarrierIdToSsCarrier(k))
                            .collect(Collectors.toList()));
                    return ssCarrierList;
                })
                .collect(Collectors.toList());
    }

    public SkyScannerFlightCarrierDto ssCarrierIdToSsCarrier(String ssCarrierId) {
        return ssFlight.getCarriers().stream()
                    .filter(carrier -> carrier.getCarrierId().equals(ssCarrierId))
                    .findFirst()
                    .get();
    }

    public List<List<CarrierDto>> sSCarriersDtoToCarriersDto(List<List<SkyScannerFlightCarrierDto>> ssCariersDto) {
        return ssCariersDto.stream()
                .map(f -> {
                    return f.stream()
                            .map(s -> {
                                CarrierDto carrierDto = new CarrierDto();
                                carrierDto.setCarrierPartnerId(s.getCarrierId());
                                carrierDto.setCarrierName(s.getName());
                                return carrierDto;
                            }).collect(Collectors.toList());
                })
                .collect(Collectors.toList());

    }

}

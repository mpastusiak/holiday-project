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
        System.out.println("mapToFlightDto ! " + skyScannerFlight);
        List<TheFlightDto> flightDtoList = new ArrayList<>();
        for (int i = 0; i < skyScannerFlight.getQuotes().size(); i++) {
            flightDtoList.add(new TheFlightDto(new Long(i), mapToOriginDto(skyScannerFlight), mapToDestinationDto(skyScannerFlight),
                    mapToDepartureDate(skyScannerFlight).get(i), mapToDirect(skyScannerFlight).get(i),
                    mapToMinPrice(skyScannerFlight).get(i), mapToCarrierDto(skyScannerFlight).get(i)));
        }
        return flightDtoList;
    }

    public List<PlaceDto> mapToOriginDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapToOriginDto ! " + ssFlight);
        return ssPlaceToPlaceDto(ssPlaceIdsToSsPlace(mapFromOriginLegToSsPlaceIds(ssFlight)));
    }

    public List<PlaceDto> mapToDestinationDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapToDestinationDto ! " + ssFlight);
        return ssPlaceToPlaceDto(ssPlaceIdsToSsPlace(mapFromDestinationLegToSsPlaceIds(ssFlight)));
    }

    public List<String> mapFromOriginLegToSsPlaceIds(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapFromOriginLegToSsPlaceIds ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(outboundLeg -> outboundLeg.getOutboundLeg().getOriginId())
                .collect(Collectors.toList());
    }

    public List<String> mapFromDestinationLegToSsPlaceIds(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapFromDestinationLegToSsPlaceIds ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(inboundLeg -> inboundLeg.getOutboundLeg().getDestinationId())
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightPlaceDto> ssPlaceIdsToSsPlace(List<String> ssPlaceIds) {
        System.out.println("ssPlaceIdsToSsPlace ! " + ssPlaceIds);
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
        System.out.println("ssPlaceToPlaceDto ! " + ssPlaceList);
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
        System.out.println("mapToDepartureDate ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getOutboundLeg().getDepartureDate())
                .collect(Collectors.toList());
    }

    public List<Boolean> mapToDirect(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapToDirect ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getDirect())
                .collect(Collectors.toList());
    }

    public List<BigDecimal> mapToMinPrice(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapToMinPrice ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(flight -> flight.getMinPrice())
                .collect(Collectors.toList());
    }

    public List<List<CarrierDto>> mapToCarrierDto(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("mapToCarrierDto ! " + ssFlight);
        return sSCarriersDtoToCarriersDto(ssCarrierIdsToSsCarriersDto(ssFlightTossCarriersId(ssFlight)));
    }

    public List<List<String>> ssFlightTossCarriersId(SkyScannerFlightQuoteResponseDto ssFlight) {
        System.out.println("ssFlightTossCarriersId ! " + ssFlight);
        return ssFlight.getQuotes().stream()
                .map(f -> f.getOutboundLeg().getCarrierIds())
                .collect(Collectors.toList());
    }

    public List<List<SkyScannerFlightCarrierDto>> ssCarrierIdsToSsCarriersDto(List<List<String>> ssCarrierIds) {
        System.out.println("ssCarrierIdsToSsCarriersDto ! " + ssCarrierIds);
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
        System.out.println("ssCarrierIdToSsCarrier ! " + ssCarrierId);
        return ssFlight.getCarriers().stream()
                    .filter(carrier -> carrier.getCarrierId().equals(ssCarrierId))
                    .findFirst()
                    .get();
    }

    public List<List<CarrierDto>> sSCarriersDtoToCarriersDto(List<List<SkyScannerFlightCarrierDto>> ssCariersDto) {
        System.out.println("sSCarriersDtoToCarriersDto ! " + ssCariersDto);
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

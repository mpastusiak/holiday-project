package com.kodilla.holiday.mapper.flight.skyscanner;

import com.kodilla.holiday.domain.flight.skyscanner.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkyScannerFlightMapper {
    public SkyScannerFlightQuoteResponse mapToSkyScannerFlightQuoteResponse(final SkyScannerFlightQuoteResponseDto quoteResponseDto) {
        return new SkyScannerFlightQuoteResponse(mapToSkyScannerFlightQuotesList(quoteResponseDto.getQuotes()),
                mapToSkyScannerFlightPlacesList(quoteResponseDto.getPlaces()),
                mapToSkyScannerFlightCarriersList(quoteResponseDto.getCarriers()),
                mapToSkyScannerFlightCurrencies(quoteResponseDto.getCurrencies()));
    }

    public SkyScannerFlightQuoteResponseDto mapToSkyScannerFlightQuoteResponseDto(final SkyScannerFlightQuoteResponse quoteResponse) {
        return new SkyScannerFlightQuoteResponseDto(mapToSkyScannerFlightQuotesListDto(quoteResponse.getQuotes()),
                mapToSkyScannerFlightPlacesListDto(quoteResponse.getPlaces()),
                mapToSkyScannerFlightCarriersListDto(quoteResponse.getCarriers()),
                mapToSkyScannerFlightCurrenciesDto(quoteResponse.getCurrencies()));
    }

    public List<SkyScannerFlightQuotesList> mapToSkyScannerFlightQuotesList(final List<SkyScannerFlightQuotesListDto> quotesListDto) {
        return quotesListDto.stream()
                .map(quote ->
                        new SkyScannerFlightQuotesList(quote.getQuoteId(), quote.getMinPrice(), quote.getDirect(), 
                                mapToSkyScannerFlightOutboundLeg(quote.getOutboundLeg()), 
                                mapToSkyScannerFlightInboundLeg(quote.getInboundLeg()), quote.getQuoteDateTime()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightQuotesListDto> mapToSkyScannerFlightQuotesListDto(final List<SkyScannerFlightQuotesList> quotesList) {
        return quotesList.stream()
                .map(quote ->
                        new SkyScannerFlightQuotesListDto(quote.getQuoteId(), quote.getMinPrice(), quote.getDirect(),
                                mapToSkyScannerFlightOutboundLegDto(quote.getOutboundLeg()),
                                mapToSkyScannerFlightInboundLegDto(quote.getInboundLeg()), quote.getQuoteDateTime()))
                .collect(Collectors.toList());
    }

    public SkyScannerFlightOutboundLeg mapToSkyScannerFlightOutboundLeg(final SkyScannerFlightOutboundLegDto outboundLegDto) {
        return new SkyScannerFlightOutboundLeg(mapToSkyScannerFlightCarrierIds(outboundLegDto.getCarrierIds()), 
                outboundLegDto.getOriginId(), outboundLegDto.getDestinationId(), outboundLegDto.getDepartureDate());
    }

    public SkyScannerFlightOutboundLegDto mapToSkyScannerFlightOutboundLegDto(final SkyScannerFlightOutboundLeg outboundLeg) {
        return new SkyScannerFlightOutboundLegDto(mapToSkyScannerFlightCarrierIdsDto(outboundLeg.getCarrierIds()),
                outboundLeg.getOriginId(), outboundLeg.getDestinationId(), outboundLeg.getDepartureDate());
    }

    public SkyScannerFlightInboundLeg mapToSkyScannerFlightInboundLeg(final SkyScannerFlightInboundLegDto inboundLegDto) {
        return new SkyScannerFlightInboundLeg(mapToSkyScannerFlightCarrierIds(inboundLegDto.getCarrierIds()), 
                inboundLegDto.getOriginId(), inboundLegDto.getDestinationId(), inboundLegDto.getDepartureDate());
    }

    public SkyScannerFlightInboundLegDto mapToSkyScannerFlightInboundLegDto(final SkyScannerFlightInboundLeg inboundLeg) {
        return new SkyScannerFlightInboundLegDto(mapToSkyScannerFlightCarrierIdsDto(inboundLeg.getCarrierIds()),
                inboundLeg.getOriginId(), inboundLeg.getDestinationId(), inboundLeg.getDepartureDate());
    }

    public List<SkyScannerFlightCarrierIdsList> mapToSkyScannerFlightCarrierIds(final List<SkyScannerFlightCarrierIdsListDto> carrierIdsListDto) {
        return carrierIdsListDto.stream()
                .map(carrierId -> new SkyScannerFlightCarrierIdsList(carrierId.getCarrierId()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCarrierIdsListDto> mapToSkyScannerFlightCarrierIdsDto(final List<SkyScannerFlightCarrierIdsList> carrierIdsList) {
        return carrierIdsList.stream()
                .map(carrierId -> new SkyScannerFlightCarrierIdsListDto(carrierId.getCarrierId()))
                .collect(Collectors.toList());
    }
    
    public List<SkyScannerFlightPlacesList> mapToSkyScannerFlightPlacesList(final List<SkyScannerFlightPlacesListDto> placesListDto) {
        return placesListDto.stream()
                .map(place -> new SkyScannerFlightPlacesList(place.getPlaceId(), place.getIatacode(), place.getName(),
                        place.getType(), place.getSkyscannerCode(), place.getCityName(), place.getCityId(), place.getCountryName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightPlacesListDto> mapToSkyScannerFlightPlacesListDto(final List<SkyScannerFlightPlacesList> placesList) {
        return placesList.stream()
                .map(place -> new SkyScannerFlightPlacesListDto(place.getPlaceId(), place.getIatacode(), place.getName(),
                        place.getType(), place.getSkyscannerCode(), place.getCityName(), place.getCityId(), place.getCountryName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCarriersList> mapToSkyScannerFlightCarriersList(final List<SkyScannerFlightCarriersListDto> carriersListDto) {
        return carriersListDto.stream()
                .map(carrier -> new SkyScannerFlightCarriersList(carrier.getCarrierId(), carrier.getName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCarriersListDto> mapToSkyScannerFlightCarriersListDto(final List<SkyScannerFlightCarriersList> carriersList) {
        return carriersList.stream()
                .map(carrier -> new SkyScannerFlightCarriersListDto(carrier.getCarrierId(), carrier.getName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCurrencies> mapToSkyScannerFlightCurrencies(final List<SkyScannerFlightCurrenciesDto> currenciesDto) {
        return currenciesDto.stream()
                .map(currency -> new SkyScannerFlightCurrencies(currency.getCode(), currency.getSymbol(),
                        currency.getThousandsSeparator(), currency.getDecimalSeparator(), currency.getSymbolOnLeft(),
                        currency.getSpaceBetweenAmountAndSymbol(), currency.getRoundingCoefficient(), currency.getDecimalDigits()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCurrenciesDto> mapToSkyScannerFlightCurrenciesDto(final List<SkyScannerFlightCurrencies> currencies) {
        return currencies.stream()
                .map(currency -> new SkyScannerFlightCurrenciesDto(currency.getCode(), currency.getSymbol(),
                        currency.getThousandsSeparator(), currency.getDecimalSeparator(), currency.getSymbolOnLeft(),
                        currency.getSpaceBetweenAmountAndSymbol(), currency.getRoundingCoefficient(), currency.getDecimalDigits()))
                .collect(Collectors.toList());
    }

}

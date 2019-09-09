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
        return new SkyScannerFlightOutboundLeg(outboundLegDto.getCarrierIds(),
                outboundLegDto.getOriginId(), outboundLegDto.getDestinationId(), outboundLegDto.getDepartureDate());
    }

    public SkyScannerFlightOutboundLegDto mapToSkyScannerFlightOutboundLegDto(final SkyScannerFlightOutboundLeg outboundLeg) {
        return new SkyScannerFlightOutboundLegDto(outboundLeg.getCarrierIds(),
                outboundLeg.getOriginId(), outboundLeg.getDestinationId(), outboundLeg.getDepartureDate());
    }

    public SkyScannerFlightInboundLeg mapToSkyScannerFlightInboundLeg(final SkyScannerFlightInboundLegDto inboundLegDto) {
        return new SkyScannerFlightInboundLeg(inboundLegDto.getCarrierIds(),
                inboundLegDto.getOriginId(), inboundLegDto.getDestinationId(), inboundLegDto.getDepartureDate());
    }

    public SkyScannerFlightInboundLegDto mapToSkyScannerFlightInboundLegDto(final SkyScannerFlightInboundLeg inboundLeg) {
        return new SkyScannerFlightInboundLegDto(inboundLeg.getCarrierIds(),
                inboundLeg.getOriginId(), inboundLeg.getDestinationId(), inboundLeg.getDepartureDate());
    }

    
    public List<SkyScannerFlightPlace> mapToSkyScannerFlightPlacesList(final List<SkyScannerFlightPlaceDto> placesListDto) {
        return placesListDto.stream()
                .map(place -> new SkyScannerFlightPlace(place.getPlaceId(), place.getIatacode(), place.getName(),
                        place.getType(), place.getSkyscannerCode(), place.getCityName(), place.getCityId(), place.getCountryName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightPlaceDto> mapToSkyScannerFlightPlacesListDto(final List<SkyScannerFlightPlace> placesList) {
        return placesList.stream()
                .map(place -> new SkyScannerFlightPlaceDto(place.getPlaceId(), place.getIatacode(), place.getName(),
                        place.getType(), place.getSkyscannerCode(), place.getCityName(), place.getCityId(), place.getCountryName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCarrier> mapToSkyScannerFlightCarriersList(final List<SkyScannerFlightCarrierDto> carriersListDto) {
        return carriersListDto.stream()
                .map(carrier -> new SkyScannerFlightCarrier(carrier.getCarrierId(), carrier.getName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCarrierDto> mapToSkyScannerFlightCarriersListDto(final List<SkyScannerFlightCarrier> carriersList) {
        return carriersList.stream()
                .map(carrier -> new SkyScannerFlightCarrierDto(carrier.getCarrierId(), carrier.getName()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCurrency> mapToSkyScannerFlightCurrencies(final List<SkyScannerFlightCurrencyDto> currenciesDto) {
        return currenciesDto.stream()
                .map(currency -> new SkyScannerFlightCurrency(currency.getCode(), currency.getSymbol(),
                        currency.getThousandsSeparator(), currency.getDecimalSeparator(), currency.getSymbolOnLeft(),
                        currency.getSpaceBetweenAmountAndSymbol(), currency.getRoundingCoefficient(), currency.getDecimalDigits()))
                .collect(Collectors.toList());
    }

    public List<SkyScannerFlightCurrencyDto> mapToSkyScannerFlightCurrenciesDto(final List<SkyScannerFlightCurrency> currencies) {
        return currencies.stream()
                .map(currency -> new SkyScannerFlightCurrencyDto(currency.getCode(), currency.getSymbol(),
                        currency.getThousandsSeparator(), currency.getDecimalSeparator(), currency.getSymbolOnLeft(),
                        currency.getSpaceBetweenAmountAndSymbol(), currency.getRoundingCoefficient(), currency.getDecimalDigits()))
                .collect(Collectors.toList());
    }

}

package com.kodilla.holiday.domain.flight.skyscanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkyScannerFlightPlacesList {
    private String placeId;
    private String iatacode;
    private String name;
    private String type;
    private String skyscannerCode;
    private String cityName;
    private String cityId;
    private String countryName;
}

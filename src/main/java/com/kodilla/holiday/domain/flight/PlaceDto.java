package com.kodilla.holiday.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDto {
    private Long placeId;

    private String placePartnerId;

    private String iataCode;

    private String placeName;

    private String cityName;

    private String countryName;

    public PlaceDto() {

    }

    @Override
    public String toString() {
        return placeName;
    }
}

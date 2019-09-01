package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
public class PlaceDto {
    private Long place_id;

    private String iataCode;

    private String placeName;

    private String cityName;

    private String countryName;
}

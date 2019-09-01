package com.kodilla.holiday.domain.rapidapi.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDto {
    @JsonProperty("data")
    private List<WeatherDataDto> weatherDataDto;

    @JsonProperty("city_name")
    private String city_nameDto;
}

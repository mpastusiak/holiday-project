package com.kodilla.holiday.domain.rapidapi.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataDto {
    @JsonProperty("moonrise_ts")
    private String moonrise_ts;
}

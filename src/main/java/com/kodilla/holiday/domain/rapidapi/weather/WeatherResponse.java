package com.kodilla.holiday.domain.rapidapi.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class WeatherResponse {
    private List<WeatherData> weatherData;
    private String city_name;
}

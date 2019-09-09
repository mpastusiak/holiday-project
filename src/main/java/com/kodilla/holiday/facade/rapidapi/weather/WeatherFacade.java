package com.kodilla.holiday.facade.rapidapi.weather;

import com.kodilla.holiday.domain.rapidapi.weather.WeatherResponse;
import com.kodilla.holiday.domain.rapidapi.weather.WeatherResponseDto;
import com.kodilla.holiday.mapper.rapidapi.weather.WeatherMapper;
import com.kodilla.holiday.service.rapidapi.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherFacade {
    @Autowired
    private WeatherService service;

    @Autowired
    private WeatherMapper mapper;

    public WeatherResponseDto getWeatherResponse(String lat, String lon) {
        WeatherResponse response =
                mapper.mapToWeatherResponse(service.getWeatherResponse(lat, lon));
        return mapper.mapToWeatherResponseDto(response);
    }
}

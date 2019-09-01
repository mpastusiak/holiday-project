package com.kodilla.holiday.service.rapidapi.weather;

import com.kodilla.holiday.client.rapidapi.weather.WeatherClient;
import com.kodilla.holiday.domain.rapidapi.weather.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    WeatherClient client;

    public WeatherResponseDto getWeatherResponse(String lat, String lon) {
        System.out.println("Wykonuje service " + lat + lon);
        return client.getWeatherForSixteenDays(lat, lon);
    }
}

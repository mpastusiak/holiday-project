package com.kodilla.holiday.config.rapidapi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WeatherApiConfig {
    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;

    @Value("${weather.app.key}")
    private String weatherAppKey;
}

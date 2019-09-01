package com.kodilla.holiday.client.rapidapi.weather;

import com.kodilla.holiday.config.rapidapi.WeatherApiConfig;
import com.kodilla.holiday.domain.rapidapi.weather.WeatherResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

    @Autowired
    private WeatherApiConfig weatherApiConfig;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponseDto getWeatherForSixteenDays(String lat, String lon) {
        URI url =  UriComponentsBuilder.fromHttpUrl(weatherApiConfig.getWeatherApiEndpoint() + "/forecast/daily")
                .queryParam("lang", "en")
                .queryParam("lat", lat)
                .queryParam("lon", lon).build().encode().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "weatherbit-v1-mashape.p.rapidapi.com");
        headers.add("x-rapidapi-key", "01fe5bf5f5msh02c620ebb440538p18f721jsn609088bbf22c");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        System.out.println(url);

        ResponseEntity<WeatherResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherResponseDto.class);
        ResponseEntity<String> response2 = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response2.getBody());

        return response.getBody();
    }
}

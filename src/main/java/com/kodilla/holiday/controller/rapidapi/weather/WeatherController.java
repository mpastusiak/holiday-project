package com.kodilla.holiday.controller.rapidapi.weather;

import com.kodilla.holiday.domain.rapidapi.weather.WeatherResponseDto;
import com.kodilla.holiday.facade.rapidapi.weather.WeatherFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class WeatherController {

    @Autowired
    private WeatherFacade facade;

    @RequestMapping(method = RequestMethod.GET, value = "/rapidapi/weather/{lat}/{lon}")
    public WeatherResponseDto getResponse(@PathVariable String lat, @PathVariable String lon) {
        System.out.println("Wykonuje controller " + lat + lon);
        return facade.getWeatherResponse(lat, lon);
    }

}

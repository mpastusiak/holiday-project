package com.kodilla.holiday.mapper.rapidapi.weather;

import com.kodilla.holiday.domain.rapidapi.weather.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {
    public WeatherResponse mapToWeatherResponse(final WeatherResponseDto weatherResponseDto) {
        return new WeatherResponse(mapToWeatherDataList(weatherResponseDto.getWeatherDataDto()), weatherResponseDto.getCity_nameDto());
    }

    public WeatherResponseDto mapToWeatherResponseDto(final WeatherResponse weatherResponse) {
        return new WeatherResponseDto(mapToWeatherDataListDto(weatherResponse.getWeatherData()), weatherResponse.getCity_name());
    }

    public List<WeatherData> mapToWeatherDataList(final List<WeatherDataDto> weatherDataDtoList) {
        return weatherDataDtoList.stream()
                .map(data ->
                        new WeatherData(data.getMoonrise_ts()))
                .collect(Collectors.toList());
    }

    public List<WeatherDataDto> mapToWeatherDataListDto(final List<WeatherData> weatherDataList) {
        return weatherDataList.stream()
                .map(data ->
                        new WeatherDataDto(data.getMoonrise_ts()))
                .collect(Collectors.toList());
    }
}

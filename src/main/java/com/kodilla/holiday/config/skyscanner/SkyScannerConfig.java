package com.kodilla.holiday.config.skyscanner;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SkyScannerConfig {
    @Value("${skyscanner.api.endpoint.prod}")
    private String skyscannerApiEndpoint;

    @Value("${skyscanner.app.key}")
    private String skyscannerAppKey;
}
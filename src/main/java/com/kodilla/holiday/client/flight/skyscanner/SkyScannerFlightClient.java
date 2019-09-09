package com.kodilla.holiday.client.flight.skyscanner;

import com.kodilla.holiday.client.RestTemplateResponseErrorHandler;
import com.kodilla.holiday.config.skyscanner.SkyScannerConfig;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuoteResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@Component
public class SkyScannerFlightClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkyScannerFlightClient.class);

    @Autowired
    private SkyScannerConfig skyScannerConfig;

    @Autowired
    private RestTemplate restTemplate;

    public SkyScannerFlightQuoteResponseDto getSkyScannerFlightQuoteResponse(String originPlace, String destinationPlace,
                                                                             String outboundPartialDate, String inboundPartialDate) {
        URI url =  UriComponentsBuilder.fromHttpUrl(skyScannerConfig.getSkyscannerApiEndpoint() + "/browsequotes/v1.0/PL/PLN/pl-PL/")
                .pathSegment(originPlace)
                .pathSegment(destinationPlace)
                .pathSegment(outboundPartialDate)
                .path("/")
                .pathSegment(inboundPartialDate)
                .queryParam("apikey", skyScannerConfig.getSkyscannerAppKey()).build().encode().toUri();

        System.out.println(url);

        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        int count = 0;
        int maxTries = 100;
        while(true) {
            try {
                return restTemplate.getForObject(url, SkyScannerFlightQuoteResponseDto.class);
            } catch (Exception e) {
                if (++count == maxTries) {
                    return new SkyScannerFlightQuoteResponseDto(new ArrayList<>(), new ArrayList<>(),
                            new ArrayList<>(), new ArrayList<>());
                }
            }
        }
    }
}

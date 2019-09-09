package com.kodilla.holiday.domain.flight.skyscanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyScannerFlightInboundLegDto {
    @JsonProperty("CarrierIds")
    private List<String> carrierIds;

    @JsonProperty("OriginId")
    private String originId;

    @JsonProperty("DestinationId")
    private String destinationId;

    @JsonProperty("DepartureDate")
    private String departureDate;

    @Override
    public String toString() {
        return "carrierIds=" + carrierIds +
                ", originId='" + originId + '\'' +
                ", destinationId='" + destinationId + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}

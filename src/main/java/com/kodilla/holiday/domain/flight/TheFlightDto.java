package com.kodilla.holiday.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheFlightDto {
    @JsonProperty("flightId")
    private Long flightId;

    @JsonProperty("origin")
    private List<PlaceDto> originsList;

    @JsonProperty("destination")
    private List<PlaceDto> destinationsList;

    @JsonProperty("departureDate")
    private String departureDate;

    @JsonProperty("returnDate")
    private String returnDate;

    @JsonProperty("direct")
    private boolean direct;

    @JsonProperty("minPrice")
    private BigDecimal minPrice;

    @JsonProperty("carriers")
    private List<CarrierDto> carriersList;

    public TheFlightDto() {

    }
}
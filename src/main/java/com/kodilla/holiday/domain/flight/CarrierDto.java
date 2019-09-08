package com.kodilla.holiday.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierDto {
    private Long carrierId;

    private String carrierPartnerId;

    private String carrierName;

    public CarrierDto() {

    }

    @Override
    public String toString() {
        return carrierName;
    }
}

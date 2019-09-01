package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.Carrier;
import com.kodilla.holiday.domain.flight.CarrierDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarrierMapper {
    public List<Carrier> mapToCarrier(List<CarrierDto> carrierDtoList) {
        return carrierDtoList.stream()
                .map(carrier -> new Carrier(carrier.getCarrier_id(), carrier.getCarrierName(), new ArrayList<>()))
                .collect(Collectors.toList());
    }

    public List<CarrierDto> mapToCarrierDto(List<Carrier> carrierList) {
        return carrierList.stream()
                .map(carrier -> new CarrierDto(carrier.getCarrier_id(), carrier.getCarrierName()))
                .collect(Collectors.toList());
    }
}

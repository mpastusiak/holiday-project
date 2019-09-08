package com.kodilla.holiday.mapper.flight;

import com.kodilla.holiday.domain.flight.Carrier;
import com.kodilla.holiday.domain.flight.CarrierDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrierMapper {
    public Carrier mapToCarrier(CarrierDto carrierDto) {
        return new Carrier(carrierDto.getCarrierId(), carrierDto.getCarrierPartnerId(), carrierDto.getCarrierName(),
                new ArrayList<>());
    }

    public CarrierDto mapToCarrierDto(Carrier carrier) {
        return new CarrierDto(carrier.getCarrierId(), carrier.getCarrierPartnerId(), carrier.getCarrierName());
    }

    public List<Carrier> mapToCarrierList(List<CarrierDto> carrierDtoList) {
        return carrierDtoList.stream()
                .map(carrier -> mapToCarrier(carrier))
                .collect(Collectors.toList());
    }

    public List<CarrierDto> mapToCarrierDtoList(List<Carrier> carrierList) {
        return carrierList.stream()
                .map(carrier -> mapToCarrierDto(carrier))
                .collect(Collectors.toList());
    }
}

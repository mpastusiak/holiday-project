package com.kodilla.holiday.domain.flight;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Getter
@AllArgsConstructor
public class TheFlightDto {
    private Long id;
    private PlaceDto origin_id;;
    private PlaceDto destination_id;
    private SimpleDateFormat departureDate;
    private boolean direct;
    private BigDecimal minPrice;
    private List<CarrierDto> carriersList;
}
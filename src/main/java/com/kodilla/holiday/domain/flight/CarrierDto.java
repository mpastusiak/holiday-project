package com.kodilla.holiday.domain.flight;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
public class CarrierDto {
    private Long carrier_id;

    private String carrierName;
}

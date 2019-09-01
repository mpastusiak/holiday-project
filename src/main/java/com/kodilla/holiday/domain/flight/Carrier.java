package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrier")
@Builder
public class Carrier {
    @Id
    @Column(name = "carrier_id", unique = true)
    private Long carrier_id;

    @Column(name = "carrier_name")
    private String carrierName;

    @ManyToMany(mappedBy = "carriersList")
    private List<TheFlight> flightsList;

}

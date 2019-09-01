package com.kodilla.holiday.domain.flight;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight")
@Builder
public class TheFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_id")
    private Origin origin_id;;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    private Destination destination_id;

    @Column(name = "departureDate")
    private SimpleDateFormat departureDate;

    @Column(name = "direct")
    private boolean direct;

    @Column(name = "minPrice")
    private BigDecimal minPrice;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_flight_carrier",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "carrier_id")
    )
    private List<Carrier> carriersList;
}
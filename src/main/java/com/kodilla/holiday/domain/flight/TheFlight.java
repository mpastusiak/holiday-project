package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @Column(name = "flightId")
    private Long flightId;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "join_flight_origin",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Origin> originsList;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "join_flight_destination",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Destination> destinationsList;

    @Column(name = "departureDate")
    private String departureDate;

    @Column(name = "direct")
    private boolean direct;

    @Column(name = "minPrice")
    private BigDecimal minPrice;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "join_flight_carrier",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "carrier_id")
    )
    private List<Carrier> carriersList;
}
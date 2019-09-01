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
@Table(name = "place")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="place_type",
        discriminatorType = DiscriminatorType.STRING)
public class Place {
    @Id
    @Column(name = "place_id", unique = true)
    private Long place_id;

    @Column(name = "iataCode")
    private String iataCode;

    @Column(name = "placeName")
    private String placeName;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "countryName")
    private String countryName;
}

package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorOptions(force=true)
@Inheritance(strategy=InheritanceType.JOINED)
public class Place {
    @Id
    @Column(name = "placeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long placeId;

    @Column(name = "placePartnerId", unique = true)
    private String placePartnerId;

    @Column(name = "iataCode")
    private String iataCode;

    @Column(name = "placeName")
    private String placeName;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "countryName")
    private String countryName;
}

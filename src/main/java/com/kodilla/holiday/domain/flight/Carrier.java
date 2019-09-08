package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @Column(name = "carrierId", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carrierId;

    @Column(name = "carrierPartnerId")
    private String carrierPartnerId;

    @Column(name = "carrierName")
    private String carrierName;

    @ManyToMany(mappedBy = "carriersList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TheFlight> flightsList;

}

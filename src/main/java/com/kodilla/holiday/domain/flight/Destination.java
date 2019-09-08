package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("destination")
public class Destination extends Place {
    @OneToMany(mappedBy = "destinationsList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TheFlight> flightsList;
}

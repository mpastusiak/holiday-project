package com.kodilla.holiday.domain.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="destination")
@PrimaryKeyJoinColumn(name="placeId")
public class Destination extends Place {
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "destinationsList")
    private List<TheFlight> flightsList = new ArrayList<>();
}

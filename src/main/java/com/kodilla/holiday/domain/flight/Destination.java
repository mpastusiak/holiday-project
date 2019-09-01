package com.kodilla.holiday.domain.flight;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("destination")
public class Destination extends Place {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destination_id")
    private List<TheFlight> flightsList;
}

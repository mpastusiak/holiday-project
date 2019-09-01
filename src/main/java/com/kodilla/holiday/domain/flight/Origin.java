package com.kodilla.holiday.domain.flight;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("origin")
public class Origin extends Place {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "origin_id")
    private List<TheFlight> flightsList;
}

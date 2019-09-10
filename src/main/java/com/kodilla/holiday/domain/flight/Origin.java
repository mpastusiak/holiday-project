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
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="origin")
@PrimaryKeyJoinColumn(name="placeId")
public class Origin extends Place {
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "originsList")
    private List<TheFlight> flightsList;
}

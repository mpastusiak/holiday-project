package com.kodilla.holiday.repository.flight;

import com.kodilla.holiday.domain.flight.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    @Override
    Place save(Place place);

    @Override
    Optional<Place> findById(Long id);

    Optional<Place> findFirstByPlacePartnerId(String placePartnerId);

    @Override
    List<Place> findAll();

    @Override
    void deleteById(Long id);
}

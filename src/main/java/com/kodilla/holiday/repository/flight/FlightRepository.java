package com.kodilla.holiday.repository.flight;

import com.kodilla.holiday.domain.flight.TheFlight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends CrudRepository<TheFlight, Long> {
    @Override
    List<TheFlight> findAll();

    @Override
    TheFlight save(TheFlight flight);

    Optional<TheFlight> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
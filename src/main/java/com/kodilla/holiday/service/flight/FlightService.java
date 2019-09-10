package com.kodilla.holiday.service.flight;

import com.kodilla.holiday.domain.flight.TheFlight;
import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.kodilla.holiday.repository.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    public List<TheFlight> getAllFlights() {
        return repository.findAll();
    }

    public Optional<TheFlight> getFlight(final Long id) {
        return repository.findById(id);
    }

    public TheFlight saveFlight(final TheFlight flight) {
        return repository.save(flight);
    }

    public void deleteFlight(final Long id) { repository.deleteById(id); }

    public TheFlightDto getFlightDtoById(List<TheFlightDto> flightDtoList, String id) {
        return flightDtoList.stream()
                .filter(f -> f.getFlightId().equals(id))
                .findFirst()
                .get();
    }
}

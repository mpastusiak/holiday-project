package com.kodilla.holiday.service.flight;

import com.kodilla.holiday.domain.flight.Place;
import com.kodilla.holiday.repository.flight.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository repository;

    public Optional<Place> getPlace(final Long id) {
        return repository.findById(id);
    }

    public Place savePlace(final Place place) {
        return repository.save(place);
    }

    public Optional<Place> findPlace(final String placePartnerId) {
        return repository.findFirstByPlacePartnerId(placePartnerId);
    }

    public List<Place> gelAllPlaces() { return repository.findAll(); }

    public void deletePlace(final Long id) { repository.deleteById(id); }
}

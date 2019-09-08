package com.kodilla.holiday.service.flight;

import com.kodilla.holiday.domain.flight.Carrier;
import com.kodilla.holiday.repository.flight.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierService {
    @Autowired
    private CarrierRepository repository;

    public Optional<Carrier> getCarrier(final Long id) {
        return repository.findById(id);
    }

    public Carrier saveCarrier(final Carrier carrier) {
        return repository.save(carrier);
    }

    public Optional<Carrier> findCarrier(final String carrierPartnerId) { return repository.findByCarrierPartnerId(carrierPartnerId); }

    public List<Carrier> gelAllCarriers() { return repository.findAll(); }

    public void deleteCarrier(final Long id) { repository.deleteById(id); }
}

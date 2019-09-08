package com.kodilla.holiday.repository.flight;

import com.kodilla.holiday.domain.flight.Carrier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarrierRepository extends CrudRepository<Carrier, Long> {
    @Override
    Carrier save(Carrier carrier);

    Optional<Carrier> findById(Long id);

    Optional<Carrier> findByCarrierPartnerId(String carrierPartnerId);

    @Override
    List<Carrier> findAll();

    @Override
    void deleteById(Long id);
}

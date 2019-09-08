package com.kodilla.holiday.controller.flight;

import com.kodilla.holiday.domain.flight.CarrierDto;
import com.kodilla.holiday.mapper.flight.CarrierMapper;
import com.kodilla.holiday.service.flight.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/flight/carrier")
public class CarrierController {
    @Autowired
    private CarrierService service;
    @Autowired
    private CarrierMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<CarrierDto> getCarriers() {
        return mapper.mapToCarrierDtoList(service.gelAllCarriers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{carrierId}")
    public CarrierDto getCarrier(@PathVariable Long carrierId) throws CarrierNotFoundException {
        return mapper.mapToCarrierDto(service.getCarrier(carrierId).orElseThrow(CarrierNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{carrierId}")
    public void deleteCarrier(@PathVariable Long carrierId) {
        service.deleteCarrier(carrierId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public CarrierDto updateCarrier(@RequestBody CarrierDto carrierDto) {
        return mapper.mapToCarrierDto(service.saveCarrier(mapper.mapToCarrier(carrierDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = APPLICATION_JSON_VALUE)
    public void createCarrier(@RequestBody CarrierDto carrierDto) {
        service.saveCarrier(mapper.mapToCarrier(carrierDto));
    }
}

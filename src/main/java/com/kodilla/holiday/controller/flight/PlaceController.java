package com.kodilla.holiday.controller.flight;

import com.kodilla.holiday.domain.flight.PlaceDto;
import com.kodilla.holiday.mapper.flight.PlaceMapper;
import com.kodilla.holiday.service.flight.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/flight/place")
public class PlaceController {
    @Autowired
    private PlaceService service;
    @Autowired
    private PlaceMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<PlaceDto> getPlaces() {
        return mapper.mapPlacesToPlaceDtoList(service.gelAllPlaces());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{placeId}")
    public PlaceDto getPlace(@PathVariable Long placeId) throws PlaceNotFoundException {
        return mapper.mapToPlaceDto(service.getPlace(placeId).orElseThrow(PlaceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{placeId}")
    public void deletePlace(@PathVariable Long placeId) {
        service.deletePlace(placeId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public PlaceDto updatePlace(@RequestBody PlaceDto placeDto) {
        return mapper.mapToPlaceDto(service.savePlace(mapper.mapToPlace(placeDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = APPLICATION_JSON_VALUE)
    public void createPlace(@RequestBody PlaceDto placeDto) {
        service.savePlace(mapper.mapToPlace(placeDto));
    }
}

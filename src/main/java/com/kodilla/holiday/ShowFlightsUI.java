package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.CarrierController;
import com.kodilla.holiday.controller.flight.FlightController;
import com.kodilla.holiday.controller.flight.PlaceController;
import com.kodilla.holiday.domain.flight.CarrierDto;
import com.kodilla.holiday.domain.flight.PlaceDto;
import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Route
@Transactional
public class ShowFlightsUI extends HorizontalLayout {
    @Autowired
    private FlightController flightController;

    @Autowired
            private PlaceController placeController;

    @Autowired
            private CarrierController carrierController;

    Accordion accordion = new Accordion();
    private Grid<TheFlightDto> gridFlights = new Grid<>(TheFlightDto.class);
    private Grid<PlaceDto> gridOrigin = new Grid<>(PlaceDto.class);
    private Grid<PlaceDto> gridDestination = new Grid<>(PlaceDto.class);
    private Grid<CarrierDto> gridCarrier = new Grid<>(CarrierDto.class);

    @Autowired
    public ShowFlightsUI(FlightController flightController) {
        this.flightController = flightController;
        gridFlights.setColumns("departureDate", "direct", "originsList", "destinationsList", "minPrice");
        gridFlights.addComponentColumn(this :: showDetailsButton);
        gridFlights.addItemClickListener(e -> showFligt(e.getItem()));
        gridFlights.setSizeFull();

        accordion.add("ORIGINS", gridOrigin);
        accordion.add("DESTINATIONS", gridDestination);
        accordion.add("CARRIERS", gridCarrier);
        accordion.setSizeFull();
        accordion.setVisible(false);

        add(gridFlights);
        add(accordion);
        setSizeFull();
        showFlights();
    }

    public void showFlights() {
        gridFlights.setItems(flightController.getFlights());
    }

    public void showPlace(TheFlightDto flightDto) {
        gridOrigin.setItems(flightDto.getOriginsList());
        gridDestination.setItems(flightDto.getDestinationsList());
    }

    public void showCarrier(TheFlightDto flightDto) {
        gridCarrier.setItems(flightDto.getCarriersList());
    }

    public Button showDetailsButton(TheFlightDto flightDto) {
        Button button = new Button("Details");
        button.setIcon(new Icon(VaadinIcon.ARROW_RIGHT));
        button.addClickListener(e -> showFligt(flightDto));
        return button;
    }

    public void showFligt(TheFlightDto flightDto) {
        showPlace(flightDto);
        showCarrier(flightDto);
        if(accordion.isVisible()) {
            accordion.setVisible(false);
        } else {
            accordion.setVisible(true);
        }
    }

}

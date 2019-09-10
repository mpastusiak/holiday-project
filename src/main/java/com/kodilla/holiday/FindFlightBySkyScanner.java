package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.CarrierController;
import com.kodilla.holiday.controller.flight.FlightController;
import com.kodilla.holiday.controller.flight.PlaceController;
import com.kodilla.holiday.controller.flight.skyscanner.SkyScannerFlightsController;
import com.kodilla.holiday.domain.flight.CarrierDto;
import com.kodilla.holiday.domain.flight.PlaceDto;
import com.kodilla.holiday.domain.flight.TheFlightDto;
import com.kodilla.holiday.service.flight.skyscanner.GeoCatalogService;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Route
@Transactional
public class FindFlightBySkyScanner extends VerticalLayout {
    @Autowired
    private FlightController flightController;

    @Autowired
    private SkyScannerFlightsController ssFlightsController;

    @Autowired
    private GeoCatalogService geoCatalogService;

    @Autowired
            private PlaceController placeController;

    @Autowired
            private CarrierController carrierController;

    private HorizontalLayout searchLayout = new HorizontalLayout();
    private TextField originTextField = new TextField("Origin place:");
    private TextField destinationTextField = new TextField("Destination place:");
    private TextField dateFromTextField = new TextField("Date from:");
    private TextField dateToTextField = new TextField("Date to:");
    private Button showFlightsButton = new Button("Search flights on partners services");

    private String originIataCode;
    private String destinationIataCode;

    private HorizontalLayout dataLayout = new HorizontalLayout();
    Accordion accordion = new Accordion();
    private Grid<TheFlightDto> gridFlights = new Grid<>(TheFlightDto.class);
    private Grid<PlaceDto> gridOrigin = new Grid<>(PlaceDto.class);
    private Grid<PlaceDto> gridDestination = new Grid<>(PlaceDto.class);
    private Grid<CarrierDto> gridCarrier = new Grid<>(CarrierDto.class);

    private VerticalLayout detailsLayout = new VerticalLayout();
    private TextField departureDateTextField = new TextField("Departure date:");
    private TextField returnDateLabelTextField = new TextField("Return date:");
    private TextField priceTextField = new TextField("Your price:");

    @Autowired
    public FindFlightBySkyScanner(FlightController flightController) {
        this.flightController = flightController;
        showFlightsButton.addClickListener(e -> showFlights());

        gridFlights.setColumns("departureDate", "returnDate", "direct", "originsList", "destinationsList", "minPrice");
        gridFlights.addComponentColumn(this :: showDetailsButton);
        gridFlights.addComponentColumn(this :: showBookingButton);
        gridFlights.addItemClickListener(e -> showFligt(e.getItem()));
        gridFlights.setSizeFull();

        searchLayout.add(originTextField, destinationTextField, dateFromTextField, dateToTextField,
                showFlightsButton);

        departureDateTextField.setReadOnly(true);
        returnDateLabelTextField.setReadOnly(true);
        priceTextField.setReadOnly(true);

        gridOrigin.setColumns("placeName", "cityName", "countryName", "iataCode");
        gridDestination.setColumns("placeName", "cityName", "countryName", "iataCode");
        gridCarrier.setColumns("carrierName");
        accordion.add("ORIGINS", gridOrigin);
        accordion.add("DESTINATIONS", gridDestination);
        accordion.add("CARRIERS", gridCarrier);
        accordion.setSizeFull();

        detailsLayout.add(departureDateTextField, returnDateLabelTextField, priceTextField, accordion);
        detailsLayout.setSizeFull();
        detailsLayout.setVisible(false);

        dataLayout.add(gridFlights, detailsLayout);
        dataLayout.setSizeFull();

        add(searchLayout);
        add(dataLayout);
        setSizeFull();
    }

    public void showFlights() {
        originTextField.setValue(geoCatalogService.findPlaceName(originTextField.getValue()));
        originIataCode = geoCatalogService.findPlaceIata(originTextField.getValue());
        destinationTextField.setValue(geoCatalogService.findPlaceName(destinationTextField.getValue()));
        destinationIataCode = geoCatalogService.findPlaceIata(destinationTextField.getValue());
        gridFlights.setItems(ssFlightsController.getResponseByFlight(originIataCode, destinationIataCode,
                dateFromTextField.getValue(), dateToTextField.getValue()));
    }

    public void showPlace(TheFlightDto flightDto) {
        gridOrigin.setItems(flightDto.getOriginsList());
        gridDestination.setItems(flightDto.getDestinationsList());
    }

    public void showCarrier(TheFlightDto flightDto) {
        gridCarrier.setItems(flightDto.getCarriersList());
    }

    public void showDatesAndPrice(TheFlightDto flightDto) {
        departureDateTextField.setValue(flightDto.getDepartureDate());
        returnDateLabelTextField.setValue(flightDto.getReturnDate());
        priceTextField.setValue(flightDto.getMinPrice().toString());
    }

    public Button showDetailsButton(TheFlightDto flightDto) {
        Button button = new Button("Details");
        button.setIcon(new Icon(VaadinIcon.ARROW_RIGHT));
        button.addClickListener(e -> showFligt(flightDto));
        return button;
    }

    public void showFligt(TheFlightDto flightDto) {
        showDatesAndPrice(flightDto);
        showPlace(flightDto);
        showCarrier(flightDto);
        detailsLayout.setVisible(true);
    }

    public Button showBookingButton(TheFlightDto flightDto) {
        Button button = new Button("Book flight!");
        button.setIcon(new Icon(VaadinIcon.CHECK));
        button.addClickListener(e -> bookFlight(flightDto));
        return button;
    }

    public void bookFlight(TheFlightDto flightDto) {
        flightController.createFlight(flightDto);
    }

}

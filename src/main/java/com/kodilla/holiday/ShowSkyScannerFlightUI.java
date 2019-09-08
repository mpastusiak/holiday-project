package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.skyscanner.SkyScannerFlightsController;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuotesListDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Route
@Transactional
public class ShowSkyScannerFlightUI extends VerticalLayout {
    @Autowired
    private SkyScannerFlightsController flightController;

    private TextField a;
    private TextField b;
    private TextField c;
    private TextField d;
    private Button testShowFlights;
    private Grid<SkyScannerFlightQuotesListDto> grid = new Grid<>(SkyScannerFlightQuotesListDto.class);

    @Autowired
    public ShowSkyScannerFlightUI(SkyScannerFlightsController flightController) {
        this.flightController = flightController;
        grid.addComponentColumn(this :: buildDeleteButton);
        a = new TextField("A:");
        b = new TextField("B:");
        c = new TextField("C:");
        d = new TextField("D:");
        testShowFlights = new Button("Show flights!");
        testShowFlights.addClickListener(e -> showFlights());

        add(a);
        add(b);
        add(c);
        add(d);
        add(testShowFlights);
        add(grid);

    }

    public void showFlights() {
        grid.setItems(flightController.getResponse(a.getValue(), b.getValue(), c.getValue(), d.getValue()).getQuotes());
    }

    private Button buildDeleteButton(SkyScannerFlightQuotesListDto f) {
        Button button = new Button("TEST");
        button.setIcon(new Icon(VaadinIcon.CLOSE));
        button.addClickListener(e -> deleteFlight(f));
        return button;
    }

    private void deleteFlight(SkyScannerFlightQuotesListDto f) {

    }
}

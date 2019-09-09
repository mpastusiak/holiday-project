package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.skyscanner.SkyScannerFlightsController;
import com.kodilla.holiday.domain.flight.skyscanner.SkyScannerFlightQuotesListDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

    private HorizontalLayout form = new HorizontalLayout();
    private TextField originTextField;
    private TextField destinationTextField;
    private TextField dateFromTextField;
    private TextField dateToTextField;
    private Button showFlightsButton;
    private Grid<SkyScannerFlightQuotesListDto> grid = new Grid<>(SkyScannerFlightQuotesListDto.class);

    @Autowired
    public ShowSkyScannerFlightUI(SkyScannerFlightsController flightController) {
        this.flightController = flightController;
        //grid.addComponentColumn(this :: showDetailsButton);
        originTextField = new TextField("Origin place:");
        destinationTextField = new TextField("Destination place:");
        dateFromTextField = new TextField("Date from:");
        dateToTextField = new TextField("Date to:");
        showFlightsButton = new Button("Show flights");
        showFlightsButton.addClickListener(e -> showFlights());

        form.add(originTextField);
        form.add(destinationTextField);
        form.add(dateFromTextField);
        form.add(dateToTextField);
        form.add(showFlightsButton);
        add(form, grid);
    }

    public void showFlights() {
        grid.setItems(flightController.getResponse(originTextField.getValue(), destinationTextField.getValue(),
                dateFromTextField.getValue(), dateToTextField.getValue()).getQuotes());
    }

    /*
    public Button showDetailsButton(SkyScannerFlightQuotesListDto quotesListDto) {
        Button button = new Button("Details");
        button.setIcon(new Icon(VaadinIcon.ARROW_RIGHT));
        button.addClickListener(e -> showQuote(quotesListDto));
        return button;
    }

    public void showFligt(SkyScannerFlightQuotesListDto quotesListDto) {
        showPlace(flightDto);
        showCarrier(flightDto);
        if(accordion.isVisible()) {
            accordion.setVisible(false);
        } else {
            accordion.setVisible(true);
        }
    }
     */
}

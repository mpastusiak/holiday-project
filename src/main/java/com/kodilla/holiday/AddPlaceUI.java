package com.kodilla.holiday;

import com.kodilla.holiday.domain.flight.Place;
import com.kodilla.holiday.repository.flight.PlaceRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class AddPlaceUI extends VerticalLayout {
    private PlaceRepository placeRepository;

    private TextField iataCodeTextField;
    private TextField placeNameTextField;
    private TextField cityNameTextField;
    private TextField countryNameTextField;
    private Button addPlaceButton;

    @Autowired
    public AddPlaceUI(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        iataCodeTextField = new TextField("IATA code:");
        placeNameTextField = new TextField("Aiport name:");
        cityNameTextField = new TextField("City:");
        countryNameTextField = new TextField("Country:");
        addPlaceButton = new Button("Dodaj");
        addPlaceButton.addClickListener(clickEvent -> addPlace());

        add(iataCodeTextField);
        add(placeNameTextField);
        add(placeNameTextField);
        add(cityNameTextField);
        add(countryNameTextField);
        add(addPlaceButton);
    }

    public void addPlace() {
        Place place = new Place();
        place.setIataCode(iataCodeTextField.getValue());
        place.setPlaceName(placeNameTextField.getValue());
        place.setCityName(cityNameTextField.getValue());
        place.setCountryName(countryNameTextField.getValue());
        placeRepository.save(place);
    }
}

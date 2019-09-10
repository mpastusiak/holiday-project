package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.PlaceController;
import com.kodilla.holiday.domain.flight.PlaceDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Route
@Transactional
public class ShowPlacesUI extends VerticalLayout {
    @Autowired
    private PlaceController placeController;
    private Grid<PlaceDto> grid = new Grid<>(PlaceDto.class);

    @Autowired
    public ShowPlacesUI(PlaceController placeController) {
        this.placeController = placeController;

        add(grid);
        showPlaces();
    }

    public void showPlaces() {
        grid.setItems(placeController.getPlaces());
    }
}
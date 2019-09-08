package com.kodilla.holiday;

import com.kodilla.holiday.controller.flight.CarrierController;
import com.kodilla.holiday.domain.flight.CarrierDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Route
@Transactional
public class ShowCarrierUI extends VerticalLayout {
    @Autowired
    private CarrierController carrierController;
    private Button testShowCarriers;
    private Grid<CarrierDto> grid = new Grid<>(CarrierDto.class);

    @Autowired
    public ShowCarrierUI(CarrierController carrierController) {
        this.carrierController = carrierController;
        testShowCarriers = new Button("Show carriers!");
        testShowCarriers.addClickListener(e -> showCarriers());

        add(grid);
        add(testShowCarriers);
        showCarriers();
    }

    public void showCarriers() {
        grid.setItems(carrierController.getCarriers());
    }
}

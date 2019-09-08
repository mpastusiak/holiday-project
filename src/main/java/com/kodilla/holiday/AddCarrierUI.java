package com.kodilla.holiday;

import com.kodilla.holiday.domain.flight.Carrier;
import com.kodilla.holiday.repository.flight.CarrierRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class AddCarrierUI extends VerticalLayout {
    private CarrierRepository carrierRepository;

    private TextField carrierName;
    private Button addCarrierButton;

    @Autowired
    public AddCarrierUI(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
        carrierName = new TextField("Carrier name:");
        addCarrierButton = new Button("Add");
        addCarrierButton.addClickListener(clickEvent -> {
            addCarrier();
            carrierName.clear();
        });

        add(carrierName);
        add(addCarrierButton);
    }

    public void addCarrier() {
        Carrier carrier = new Carrier();
        carrier.setCarrierName(carrierName.getValue());
        carrierRepository.save(carrier);
    }
}

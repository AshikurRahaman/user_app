package com.example.user_app.core.usecase.impl;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.core.port.AddressPersistancePort;
import com.example.user_app.core.usecase.AddressUseCase;
import com.example.user_app.infrustracture.response.models.AddressResponseModel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AddressUseCaseImpl implements AddressUseCase {
    private AddressPersistancePort addressPersistancePort;
    @Override
    public AddressResponseModel getAllAddress() {
        List<AddressDomainModel> models = addressPersistancePort.getAllAddress().orElse(new ArrayList<>());
        return new AddressResponseModel(models);
    }

    @Override
    public AddressResponseModel addAddress(AddressDomainModel addressDomainModel) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        addressDomainModel.setUpdatedAt(now.format(dtf));
        List<AddressDomainModel> models = addressPersistancePort.addAddress(addressDomainModel).orElse(new ArrayList<>());
        return new AddressResponseModel(models);
    }
}

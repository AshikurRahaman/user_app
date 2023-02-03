package com.example.user_app.core.usecase;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.infrustracture.response.models.AddressResponseModel;

public interface AddressUseCase {
    public AddressResponseModel getAllAddress();

    public AddressResponseModel addAddress(AddressDomainModel addressDomainModel);
}

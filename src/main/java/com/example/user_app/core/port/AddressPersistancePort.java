package com.example.user_app.core.port;

import com.example.user_app.core.model.AddressDomainModel;

import java.util.List;
import java.util.Optional;

public interface AddressPersistancePort {
    public Optional<List<AddressDomainModel>> getAllAddress();

    public Optional<List<AddressDomainModel>> addAddress(AddressDomainModel addressDomainModel);

    public Optional<AddressDomainModel> addAddressAndGet(AddressDomainModel addressDomainModel);

    public void deleteById(Long id);

}

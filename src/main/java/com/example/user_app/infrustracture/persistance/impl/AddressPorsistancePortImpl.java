package com.example.user_app.infrustracture.persistance.impl;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.core.port.AddressPersistancePort;
import com.example.user_app.infrustracture.persistance.entity.AddressEntity;
import com.example.user_app.infrustracture.persistance.repository.AddressRepository;
import com.example.user_app.service.mapper.AddressDomainEntityMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Slf4j
@AllArgsConstructor
public class AddressPorsistancePortImpl implements AddressPersistancePort {
    private AddressRepository addressRepository;

    @Override
    public Optional<List<AddressDomainModel>> getAllAddress() {
        List<AddressEntity> entities = addressRepository.findAll();
        List<AddressDomainModel> models = AddressDomainEntityMapper.INSTANCE.entityToModel(entities);
        return Optional.ofNullable(models);
    }

    @Override
    public Optional<List<AddressDomainModel>> addAddress(AddressDomainModel addressDomainModel) {
        addAddressAndGet(addressDomainModel);
        return getAllAddress();
    }

    @Override
    public Optional<AddressDomainModel> addAddressAndGet(AddressDomainModel addressDomainModel) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        addressDomainModel.setUpdatedAt(now.format(dtf));

        AddressEntity entity = AddressDomainEntityMapper.INSTANCE.modelToEntity(addressDomainModel);
        AddressEntity saved = addressRepository.save(entity);
        return Optional.ofNullable(AddressDomainEntityMapper.INSTANCE.entityToModel(saved));
    }

    @Override
    public void deleteById(Long id) {
        try {
            addressRepository.deleteById(id);
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}

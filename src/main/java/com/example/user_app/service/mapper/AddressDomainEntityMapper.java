package com.example.user_app.service.mapper;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.infrustracture.persistance.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AddressDomainEntityMapper extends DomainEntityMapper<AddressDomainModel, AddressEntity>{
    AddressDomainEntityMapper INSTANCE = Mappers.getMapper(AddressDomainEntityMapper.class);
}

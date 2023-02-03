package com.example.user_app.service.mapper;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.infrustracture.persistance.entity.AddressEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T22:41:57+0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class AddressDomainEntityMapperImpl implements AddressDomainEntityMapper {

    @Override
    public AddressDomainModel entityToModel(AddressEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDomainModel addressDomainModel = new AddressDomainModel();

        addressDomainModel.setId( entity.getId() );
        addressDomainModel.setState( entity.getState() );
        addressDomainModel.setCity( entity.getCity() );
        addressDomainModel.setStreet( entity.getStreet() );
        addressDomainModel.setZipCode( entity.getZipCode() );
        addressDomainModel.setUpdatedAt( entity.getUpdatedAt() );

        return addressDomainModel;
    }

    @Override
    public AddressEntity modelToEntity(AddressDomainModel model) {
        if ( model == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId( model.getId() );
        addressEntity.setState( model.getState() );
        addressEntity.setCity( model.getCity() );
        addressEntity.setStreet( model.getStreet() );
        addressEntity.setZipCode( model.getZipCode() );
        addressEntity.setUpdatedAt( model.getUpdatedAt() );

        return addressEntity;
    }

    @Override
    public List<AddressDomainModel> entityToModel(List<AddressEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<AddressDomainModel> list = new ArrayList<AddressDomainModel>( entity.size() );
        for ( AddressEntity addressEntity : entity ) {
            list.add( entityToModel( addressEntity ) );
        }

        return list;
    }

    @Override
    public List<AddressEntity> modelToEntity(List<AddressDomainModel> model) {
        if ( model == null ) {
            return null;
        }

        List<AddressEntity> list = new ArrayList<AddressEntity>( model.size() );
        for ( AddressDomainModel addressDomainModel : model ) {
            list.add( modelToEntity( addressDomainModel ) );
        }

        return list;
    }
}

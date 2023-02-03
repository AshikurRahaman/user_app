package com.example.user_app.service.mapper;

import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.infrustracture.persistance.entity.UserInfoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T22:41:56+0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class UserInfoDomainEntityMapperImpl implements UserInfoDomainEntityMapper {

    @Override
    public UserInfoDomainModel entityToModel(UserInfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserInfoDomainModel userInfoDomainModel = new UserInfoDomainModel();

        userInfoDomainModel.setId( entity.getId() );
        userInfoDomainModel.setFirstName( entity.getFirstName() );
        userInfoDomainModel.setLastName( entity.getLastName() );
        userInfoDomainModel.setAddress( entity.getAddress() );
        userInfoDomainModel.setUserType( entity.getUserType() );
        userInfoDomainModel.setUpdatedAt( entity.getUpdatedAt() );

        return userInfoDomainModel;
    }

    @Override
    public UserInfoEntity modelToEntity(UserInfoDomainModel model) {
        if ( model == null ) {
            return null;
        }

        UserInfoEntity userInfoEntity = new UserInfoEntity();

        userInfoEntity.setId( model.getId() );
        userInfoEntity.setFirstName( model.getFirstName() );
        userInfoEntity.setLastName( model.getLastName() );
        userInfoEntity.setAddress( model.getAddress() );
        userInfoEntity.setUserType( model.getUserType() );
        userInfoEntity.setUpdatedAt( model.getUpdatedAt() );

        return userInfoEntity;
    }

    @Override
    public List<UserInfoDomainModel> entityToModel(List<UserInfoEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserInfoDomainModel> list = new ArrayList<UserInfoDomainModel>( entity.size() );
        for ( UserInfoEntity userInfoEntity : entity ) {
            list.add( entityToModel( userInfoEntity ) );
        }

        return list;
    }

    @Override
    public List<UserInfoEntity> modelToEntity(List<UserInfoDomainModel> model) {
        if ( model == null ) {
            return null;
        }

        List<UserInfoEntity> list = new ArrayList<UserInfoEntity>( model.size() );
        for ( UserInfoDomainModel userInfoDomainModel : model ) {
            list.add( modelToEntity( userInfoDomainModel ) );
        }

        return list;
    }
}

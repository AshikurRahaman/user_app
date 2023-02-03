package com.example.user_app.service.mapper;

import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.infrustracture.persistance.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoDomainEntityMapper extends DomainEntityMapper<UserInfoDomainModel, UserInfoEntity>{
    UserInfoDomainEntityMapper INSTANCE = Mappers.getMapper(UserInfoDomainEntityMapper.class);
}

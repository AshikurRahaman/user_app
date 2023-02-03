package com.example.user_app.infrustracture.persistance.impl;

import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.core.model.UserWithAddressDomainModel;
import com.example.user_app.core.port.UserInfoPersistancePort;
import com.example.user_app.infrustracture.persistance.entity.UserInfoEntity;
import com.example.user_app.infrustracture.persistance.repository.UserInfoRepository;
import com.example.user_app.service.mapper.UserInfoDomainEntityMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Slf4j
public class UserInfoPersistancePortImpl implements UserInfoPersistancePort {
    private UserInfoRepository userInfoRepository;
    @Override
    public Optional<List<UserInfoDomainModel>> getAllUser() {
        List<UserInfoEntity> entities = userInfoRepository.findAll();
        List<UserInfoDomainModel> models = UserInfoDomainEntityMapper.INSTANCE.entityToModel(entities);
        return Optional.ofNullable(models);
    }

    @Override
    public Optional<List<UserWithAddressDomainModel>> getAllUserWithAddress() {
        return Optional.ofNullable(userInfoRepository.getAllUserWithAddress());
    }

    @Override
    public Optional<List<UserWithAddressDomainModel>> getAllUserWithAddressByUserType(String userType) {
        return Optional.ofNullable(userInfoRepository.getAllUserWithAddressByUserType(userType));
    }

    @Override
    public Optional<List<UserWithAddressDomainModel>> getUserWithAddressByUserId(Long userId) {
        return Optional.ofNullable(userInfoRepository.getUserWithAddressByUserId(userId));
    }

    @Override
    public Optional<UserInfoDomainModel> addUser(UserInfoDomainModel userInfoDomainModel) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        userInfoDomainModel.setUpdatedAt(now.format(dtf));

        UserInfoEntity entity = UserInfoDomainEntityMapper.INSTANCE.modelToEntity(userInfoDomainModel);
        UserInfoEntity saved = userInfoRepository.save(entity);
        UserInfoDomainModel savedModel = UserInfoDomainEntityMapper.INSTANCE.entityToModel(saved);
        return Optional.ofNullable(savedModel);
    }

    @Override
    public Optional<List<UserInfoDomainModel>> getUserById(Long userId) {
        List<UserInfoEntity> entities = userInfoRepository.findAllById(userId);
        List<UserInfoDomainModel> models = UserInfoDomainEntityMapper.INSTANCE.entityToModel(entities);
        return Optional.ofNullable(models);
    }

    @Override
    public void deleteUserById(Long userId) {
        try{
            userInfoRepository.deleteById(userId);
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }

    @Override
    public Optional<List<UserInfoDomainModel>> getChildrenByParentAddressAndUserType(Long parentAddress, String userType) {
        List<UserInfoEntity> entities = userInfoRepository.findAllByAddressAndUserType(parentAddress, userType);
        List<UserInfoDomainModel> models = UserInfoDomainEntityMapper.INSTANCE.entityToModel(entities);
        return Optional.ofNullable(models);
    }
}

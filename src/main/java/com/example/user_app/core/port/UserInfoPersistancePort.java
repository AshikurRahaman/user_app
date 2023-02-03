package com.example.user_app.core.port;

import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.core.model.UserWithAddressDomainModel;

import java.util.List;
import java.util.Optional;

public interface UserInfoPersistancePort {
    Optional<List<UserInfoDomainModel>> getAllUser();

    Optional<List<UserWithAddressDomainModel>> getAllUserWithAddress();

    Optional<List<UserWithAddressDomainModel>> getAllUserWithAddressByUserType(String userType);

    Optional<List<UserWithAddressDomainModel>> getUserWithAddressByUserId(Long userId);


    Optional<UserInfoDomainModel> addUser(UserInfoDomainModel userInfoDomainModel);

    Optional<List<UserInfoDomainModel>> getUserById(Long userId);

    void deleteUserById(Long userId);

    Optional<List<UserInfoDomainModel>> getChildrenByParentAddressAndUserType(Long parentAddress, String userType);
}

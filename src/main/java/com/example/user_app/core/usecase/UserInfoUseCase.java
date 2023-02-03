package com.example.user_app.core.usecase;

import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.core.requestmodel.UserInfoRequestModel;
import com.example.user_app.infrustracture.response.models.UserInfoResponseModel;
import com.example.user_app.infrustracture.response.models.UserWithAddressResponseModel;

public interface UserInfoUseCase {
    public UserInfoResponseModel getAllUserInfo();

    public UserWithAddressResponseModel getAllUserInfoWithAddress();

    public UserWithAddressResponseModel getAllUserInfoWithAddressByUserType(String userType);

    public UserWithAddressResponseModel getUserInfoWithAddressByUserId(Long userId);

    public UserInfoDomainModel addUser(UserInfoDomainModel userInfoDomainModel);

    public UserWithAddressResponseModel addUserWithAddress(UserInfoRequestModel userInfoRequestModel);

    public UserWithAddressResponseModel deleteUserWithAddress(Long id);

    public UserWithAddressResponseModel updateUserWithAddress(Long userId, UserInfoRequestModel requestModel);
}

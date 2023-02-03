package com.example.user_app.core.usecase.impl;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.core.model.UserInfoDomainModel;
import com.example.user_app.core.model.UserWithAddressDomainModel;
import com.example.user_app.core.port.AddressPersistancePort;
import com.example.user_app.core.port.UserInfoPersistancePort;
import com.example.user_app.core.requestmodel.UserInfoRequestModel;
import com.example.user_app.core.usecase.UserInfoUseCase;
import com.example.user_app.infrustracture.shared.constants.Constants;
import com.example.user_app.infrustracture.shared.exceptions.BadRequestException;
import com.example.user_app.infrustracture.response.models.UserInfoResponseModel;
import com.example.user_app.infrustracture.response.models.UserWithAddressResponseModel;
import com.example.user_app.infrustracture.shared.exceptions.DataNotFoundException;
import com.example.user_app.infrustracture.shared.exceptions.ForBiddenException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class UserInfoUseCaseImpl implements UserInfoUseCase {
    private UserInfoPersistancePort userPort;

    private AddressPersistancePort addressPort;
    @Override
    public UserInfoResponseModel getAllUserInfo() {
        List<UserInfoDomainModel> models = userPort.getAllUser().orElse(new ArrayList<>());
        UserInfoResponseModel responseModel = new UserInfoResponseModel(models);
        return responseModel;
    }

    @Override
    public UserWithAddressResponseModel getAllUserInfoWithAddress() {
        List<UserWithAddressDomainModel> userWithAddress = userPort.getAllUserWithAddress().orElse(new ArrayList<>());
        UserWithAddressResponseModel responseModel = new UserWithAddressResponseModel(userWithAddress);
        return responseModel;
    }

    @Override
    public UserWithAddressResponseModel getAllUserInfoWithAddressByUserType(String userType) {
        List<UserWithAddressDomainModel> userWithAddress = userPort.getAllUserWithAddressByUserType(userType).orElse(new ArrayList<>());
        UserWithAddressResponseModel responseModel = new UserWithAddressResponseModel(userWithAddress);
        return responseModel;
    }

    @Override
    public UserWithAddressResponseModel getUserInfoWithAddressByUserId(Long userId) {
        List<UserWithAddressDomainModel> userWithAddress = userPort.getUserWithAddressByUserId(userId).orElse(new ArrayList<>());
        UserWithAddressResponseModel responseModel = new UserWithAddressResponseModel(userWithAddress);
        return responseModel;
    }

    @Override
    public UserInfoDomainModel addUser(UserInfoDomainModel userInfoDomainModel) {
        UserInfoDomainModel saved = userPort.addUser(userInfoDomainModel).orElse(new UserInfoDomainModel());
        return saved;
    }

    @SneakyThrows
    @Override
    public UserWithAddressResponseModel addUserWithAddress(UserInfoRequestModel userInfoRequestModel) {
        UserInfoDomainModel userInfoDomainModel = saveUserAndAddress(userInfoRequestModel, null, null);

        return getAllUserInfoWithAddress();
    }

    @SneakyThrows
    @Override
    public UserWithAddressResponseModel deleteUserWithAddress(Long id) {
        UserInfoDomainModel user = getUserModel(id);

        //check user type
        if(Objects.equals(user.getUserType(), Constants.PARENT_USER_TYPE)){
            //check if child exits of the parent
            checkForChildren(user);
            userPort.deleteUserById(user.getId());
            addressPort.deleteById(user.getAddress());

        }else if(Objects.equals(user.getUserType(), Constants.CHILD_USER_TYPE)){
            userPort.deleteUserById(id);
        }

        return getAllUserInfoWithAddress();
    }

    @SneakyThrows
    @Override
    public UserWithAddressResponseModel updateUserWithAddress(Long userId, UserInfoRequestModel requestModel) {
        UserInfoDomainModel user = getUserModel(userId);
        UserInfoDomainModel userInfoDomainModel = new UserInfoDomainModel();
        if(Objects.equals(requestModel.getUserType(), user.getUserType())){
            userInfoDomainModel = saveUserAndAddress(requestModel, userId, user.getAddress());
            return getAllUserInfoWithAddress();
        }
        if(Objects.equals(user.getUserType(), Constants.PARENT_USER_TYPE) && Objects.equals(requestModel.getUserType(), Constants.CHILD_USER_TYPE)){
            checkForChildren(user);
            userInfoDomainModel = saveUserAndAddress(requestModel, userId, user.getAddress());
            getAllUserInfoWithAddress();
        }
        if(Objects.equals(user.getUserType(), Constants.CHILD_USER_TYPE) && Objects.equals(requestModel.getUserType(), Constants.PARENT_USER_TYPE)){
            userInfoDomainModel = saveUserAndAddress(requestModel, userId, null);
            getAllUserInfoWithAddress();
        }
        return getAllUserInfoWithAddress();
    }

    private AddressDomainModel extractAddressFromRequest(UserInfoRequestModel requestModel){
        AddressDomainModel addressDomainModel = new AddressDomainModel();
        addressDomainModel.setCity(requestModel.getCity());
        addressDomainModel.setStreet(requestModel.getStreet());
        addressDomainModel.setState(requestModel.getState());
        addressDomainModel.setZipCode(requestModel.getZipCode());
        return addressDomainModel;
    }

    private UserInfoDomainModel extractUserInfoFromRequest(UserInfoRequestModel requestModel){
        UserInfoDomainModel userInfoDomainModel = new UserInfoDomainModel();
        userInfoDomainModel.setUserType(requestModel.getUserType());
        userInfoDomainModel.setFirstName(requestModel.getFirstName());
        userInfoDomainModel.setLastName(requestModel.getLastName());
        return userInfoDomainModel;
    }

    private Boolean isValidUserType(String userType){
        if(Objects.equals(userType, Constants.PARENT_USER_TYPE) || Objects.equals(userType, Constants.CHILD_USER_TYPE)){
            return true;
        }
        return false;
    }

    private UserInfoDomainModel getUserModel(Long id) throws DataNotFoundException {
        List<UserInfoDomainModel> users = userPort.getUserById(id).orElse(new ArrayList<>());
        UserInfoDomainModel user = new UserInfoDomainModel();
        if(users.size()>0){
            user = users.get(0);
        }else{
            throw new DataNotFoundException("Data not Found");
        }
        return user;
    }

    private void checkForChildren(UserInfoDomainModel user) {
        List<UserInfoDomainModel> children = userPort.getChildrenByParentAddressAndUserType(user.getId(), user.getUserType()).orElse(new ArrayList<>());
        if(children.size()>0){
            throw new ForBiddenException("Action Forbidden. Please Delete Associated Children First");
        }
    }

    private UserInfoDomainModel saveUserAndAddress(UserInfoRequestModel userInfoRequestModel, Long userId, Long addressId) throws BadRequestException, DataNotFoundException {
        if(!isValidUserType(userInfoRequestModel.getUserType())){
            throw new BadRequestException("Invalid User Type");
        }

        UserInfoDomainModel userInfoDomainModel = extractUserInfoFromRequest(userInfoRequestModel);
        userInfoDomainModel.setId(userId);

        // check if user is Parent
        if(Objects.equals(Constants.PARENT_USER_TYPE, userInfoDomainModel.getUserType())){
            AddressDomainModel addressDomainModel = extractAddressFromRequest(userInfoRequestModel);
            addressDomainModel.setId(addressId);
            AddressDomainModel saved = addressPort.addAddressAndGet(addressDomainModel).orElse(new AddressDomainModel());
            userInfoDomainModel.setAddress(saved.getId());
        }else{
            List<UserInfoDomainModel> parentUsers = userPort.getUserById(userInfoRequestModel.getParentId()).orElse(new ArrayList<>());
            if(parentUsers.size()>0){
                userInfoDomainModel.setAddress(parentUsers.get(0).getAddress());
            }else{
                throw new DataNotFoundException("Parent Not Exist");
            }
        }
        return userPort.addUser(userInfoDomainModel).orElse(new UserInfoDomainModel());
    }

}

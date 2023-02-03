package com.example.user_app.infrustracture.controller;

import com.example.user_app.core.requestmodel.UserInfoRequestModel;
import com.example.user_app.core.usecase.UserInfoUseCase;
import com.example.user_app.infrustracture.response.builder.ResponseEntityBuilder;
import com.example.user_app.infrustracture.response.models.UserInfoResponseModel;
import com.example.user_app.infrustracture.response.models.UserWithAddressResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user-app/api/v1/user")
@AllArgsConstructor
public class UserInfoController {
    private ResponseEntityBuilder responseEntityBuilder;
    private UserInfoUseCase userInfoUseCase;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> getAllUser(){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.getAllUserInfoWithAddress();
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }

    @GetMapping(path = "/type/{userType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> getAllUserByUserType(@PathVariable String userType){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.getAllUserInfoWithAddressByUserType(userType);
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> getUserById(@PathVariable Long id){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.getUserInfoWithAddressByUserId(id);
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> getAllUser(@RequestBody UserInfoRequestModel userInfoRequestModel){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.addUserWithAddress(userInfoRequestModel);
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> deleteUser(@PathVariable Long id){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.deleteUserWithAddress(id);
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithAddressResponseModel> updateUser(@PathVariable Long id, @RequestBody UserInfoRequestModel requestModel){
        UserWithAddressResponseModel userWithAddress = userInfoUseCase.updateUserWithAddress(id, requestModel);
        return responseEntityBuilder.buildOkResponse(userWithAddress);
    }
}

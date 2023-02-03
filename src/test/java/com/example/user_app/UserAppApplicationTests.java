package com.example.user_app;

import com.example.user_app.core.requestmodel.UserInfoRequestModel;
import com.example.user_app.core.usecase.UserInfoUseCase;
import com.example.user_app.infrustracture.controller.UserInfoController;
import com.example.user_app.infrustracture.response.models.UserWithAddressResponseModel;
import lombok.extern.slf4j.Slf4j;
import static junit.framework.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpResponse;

import static org.junit.Assert.*;

@SpringBootTest
@Slf4j
class UserAppApplicationTests {

    @Autowired
    UserInfoUseCase userInfoUseCase;

    @Test
    public void UserInfoController_addChildUser_ReturnAdded() throws Exception{

        UserInfoRequestModel requestModel = new UserInfoRequestModel();
        requestModel.setFirstName("Ashik");
        requestModel.setLastName("User");
        requestModel.setUserType("CHILD");
        requestModel.setCity("DHAKA");
        requestModel.setStreet("GULSHAN");
        requestModel.setState("GULSHAN 2");
        requestModel.setZipCode("1234");

        try{
            UserWithAddressResponseModel responseModel = userInfoUseCase.addUserWithAddress(requestModel);
        }catch (Exception e){
            assertEquals( "Parent Not Exist", e.getMessage());
        }
    }

    @Test
    public void UserInfoController_addParentUser_ReturnAdded() throws Exception{

        UserInfoRequestModel requestModel = new UserInfoRequestModel();
        requestModel.setFirstName("Ashik");
        requestModel.setLastName("User");
        requestModel.setUserType("PARENT");
        requestModel.setParentId(null);
        requestModel.setCity("DHAKA");
        requestModel.setStreet("GULSHAN");
        requestModel.setState("GULSHAN 2");
        requestModel.setZipCode("1234");
        UserWithAddressResponseModel responseModel = userInfoUseCase.addUserWithAddress(requestModel);
        assertEquals( 8, responseModel.getUserInfoWithAddress().size());
    }

    @Test
    void contextLoads() {
    }

}

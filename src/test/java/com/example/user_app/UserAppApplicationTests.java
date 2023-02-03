package com.example.user_app;

import com.example.user_app.core.requestmodel.UserInfoRequestModel;
import com.example.user_app.core.usecase.UserInfoUseCase;
import com.example.user_app.infrustracture.controller.UserInfoController;
import com.example.user_app.infrustracture.response.models.UserWithAddressResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
@Slf4j
class UserAppApplicationTests {

    @Test
    void contextLoads() {
    }

}

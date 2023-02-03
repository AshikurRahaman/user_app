package com.example.user_app.infrustracture.response.models;

import com.example.user_app.core.model.UserWithAddressDomainModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithAddressResponseModel {
    private List<UserWithAddressDomainModel> userInfoWithAddress;
}

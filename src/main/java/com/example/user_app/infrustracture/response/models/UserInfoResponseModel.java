package com.example.user_app.infrustracture.response.models;

import com.example.user_app.core.model.UserInfoDomainModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponseModel {
    private List<UserInfoDomainModel> users;
}

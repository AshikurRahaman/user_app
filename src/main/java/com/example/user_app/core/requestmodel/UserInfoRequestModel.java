package com.example.user_app.core.requestmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequestModel {
    private String firstName;
    private String lastName;
    private String userType;
    private Long parentId;
    private String state;
    private String city;
    private String street;
    private String zipCode;
}

package com.example.user_app.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserWithAddressDomainModel {

    private Long userId;
    private String firstName;
    private String lastName;
    private String userType;
    private Long addressId;
    private String state;
    private String city;
    private String street;
    private String zipCode;

}

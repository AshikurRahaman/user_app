package com.example.user_app.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDomainModel {
    private Long id;
    private String firstName;
    private String lastName;
    private Long address;
    private String userType;
    private String updatedAt;
}

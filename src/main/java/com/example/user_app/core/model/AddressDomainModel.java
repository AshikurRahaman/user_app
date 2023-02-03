package com.example.user_app.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDomainModel {
    private Long id;
    private String state;
    private String city;
    private String street;
    private String zipCode;
    private String updatedAt;
}

package com.example.user_app.infrustracture.response.models;

import com.example.user_app.core.model.AddressDomainModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class AddressResponseModel {
    private List<AddressDomainModel> addresses;
}

package com.example.user_app.infrustracture.controller;

import com.example.user_app.core.model.AddressDomainModel;
import com.example.user_app.core.usecase.AddressUseCase;
import com.example.user_app.infrustracture.response.builder.ResponseEntityBuilder;
import com.example.user_app.infrustracture.response.models.AddressResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user-app/api/v1/address")
@AllArgsConstructor
public class AddressController {
    private ResponseEntityBuilder responseEntityBuilder;
    private AddressUseCase addressUseCase;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponseModel> getAllAddress(){
        AddressResponseModel responseModel = addressUseCase.getAllAddress();
        return responseEntityBuilder.buildOkResponse(responseModel);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponseModel> addAddress(@RequestBody AddressDomainModel domainModel){
        AddressResponseModel responseModel = addressUseCase.addAddress(domainModel);
        return responseEntityBuilder.buildOkResponse(responseModel);
    }
}

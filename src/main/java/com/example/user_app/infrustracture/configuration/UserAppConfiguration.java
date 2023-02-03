package com.example.user_app.infrustracture.configuration;

import com.example.user_app.core.port.AddressPersistancePort;
import com.example.user_app.core.port.UserInfoPersistancePort;
import com.example.user_app.core.usecase.AddressUseCase;
import com.example.user_app.core.usecase.UserInfoUseCase;
import com.example.user_app.core.usecase.impl.AddressUseCaseImpl;
import com.example.user_app.core.usecase.impl.UserInfoUseCaseImpl;
import com.example.user_app.infrustracture.persistance.impl.AddressPorsistancePortImpl;
import com.example.user_app.infrustracture.persistance.impl.UserInfoPersistancePortImpl;
import com.example.user_app.infrustracture.persistance.repository.AddressRepository;
import com.example.user_app.infrustracture.persistance.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAppConfiguration {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private AddressRepository addressRepository;

    /**User-Info**/
    @Bean
    public UserInfoUseCase userInfoUseCase(){
        return new UserInfoUseCaseImpl(userInfoPersistancePort(), addressPersistancePort());
    }

    @Bean
    public UserInfoPersistancePort userInfoPersistancePort(){
        return new UserInfoPersistancePortImpl(userInfoRepository);
    }
    /**User-Info**/


    /**Address**/
    @Bean
    public AddressUseCase addressUseCase(){
        return new AddressUseCaseImpl(addressPersistancePort());
    }

    @Bean
    public AddressPersistancePort addressPersistancePort(){
        return new AddressPorsistancePortImpl(addressRepository);
    }
    /**Address**/

}

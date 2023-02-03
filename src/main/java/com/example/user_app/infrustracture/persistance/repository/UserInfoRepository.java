package com.example.user_app.infrustracture.persistance.repository;

import com.example.user_app.core.model.UserWithAddressDomainModel;
import com.example.user_app.infrustracture.persistance.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
    @Query("select new com.example.user_app.core.model.UserWithAddressDomainModel(ui.id, ui.firstName, ui.lastName, "
            +"ui.userType, ui.address, ad.state, ad.city, ad.street, ad.zipCode)"
            +"from UserInfoEntity ui "
            +"inner join AddressEntity ad on ui.address = ad.id order by ui.updatedAt desc")
    public List<UserWithAddressDomainModel> getAllUserWithAddress();

    public List<UserInfoEntity> findAllById(Long userId);

//    public List<UserInfoEntity> findAllByIdAndUserType(Long id, String userType);
    public List<UserInfoEntity> findAllByAddressAndUserType(Long addressId, String userType);


    @Query("select new com.example.user_app.core.model.UserWithAddressDomainModel(ui.id, ui.firstName, ui.lastName, "
            +"ui.userType, ui.address, ad.state, ad.city, ad.street, ad.zipCode)"
            +"from UserInfoEntity ui "
            +"inner join AddressEntity ad on ui.address = ad.id where ui.userType=?1 order by ui.updatedAt desc")
    public List<UserWithAddressDomainModel> getAllUserWithAddressByUserType(@Param(value = "userType") String userType);

    @Query("select new com.example.user_app.core.model.UserWithAddressDomainModel(ui.id, ui.firstName, ui.lastName, "
            +"ui.userType, ui.address, ad.state, ad.city, ad.street, ad.zipCode)"
            +"from UserInfoEntity ui "
            +"inner join AddressEntity ad on ui.address = ad.id where ui.id=?1 order by ui.updatedAt desc")
    public List<UserWithAddressDomainModel> getUserWithAddressByUserId(@Param(value = "id") Long id);
}

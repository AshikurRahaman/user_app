package com.example.user_app.infrustracture.persistance.repository;

import com.example.user_app.infrustracture.persistance.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}

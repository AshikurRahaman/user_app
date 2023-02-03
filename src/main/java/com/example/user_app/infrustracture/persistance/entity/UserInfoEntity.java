package com.example.user_app.infrustracture.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity {
    @Id
    @SequenceGenerator(name="user_info_id_seq_gen",sequenceName="user_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_info_id_seq_gen")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private Long address;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "updated_at")
    private String updatedAt;
}

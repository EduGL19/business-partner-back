package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long idUser;

    @Column(name = "firstname", nullable = false,length = 100)
    private String firstName;

    @Column(name = "lastname", nullable = false,length = 100)
    private String lastName;

}

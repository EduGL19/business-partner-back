package com.code.BusinessPartner.infraestructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="benefit")
@Getter
@Setter
public class BenefitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbenefit")
    private Long idBenefit;

    @Column(name = "name", nullable = false,length = 50)
    private String name;

    @Column(name="isactive", nullable = false,length = 1)
    private Boolean isActive;

    @Column(name="createdby",nullable = false)
    private Integer createdby;

    @Column(name="createdat",nullable = false)
    private Timestamp createdAt;

    @Column(name="updatedby",nullable = true)
    private Integer updatedBy;

    @Column(name="updatedat",nullable = true)
    private Timestamp updatedAt;

    @Column(name="rejectby",nullable = true)
    private Integer rejectBy;

    @Column(name="rejectat",nullable = true)
    private Timestamp rejectAt;

}

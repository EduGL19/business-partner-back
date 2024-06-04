package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="code")
@Getter
@Setter
public class CodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcode")
    private Long idCode;

    @Column(name = "code", nullable = false,length = 50)
    private String code;

    @Column(name = "available", nullable = false,length = 1)
    private Boolean available;

    @Column(name="isactive", nullable = false,length = 1)
    private Boolean isActive;

    @Column(name = "idpartner", nullable = true)
    private Long idPartner;

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

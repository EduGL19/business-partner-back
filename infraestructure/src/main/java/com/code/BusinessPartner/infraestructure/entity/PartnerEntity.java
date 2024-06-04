package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="partner")
@Getter
@Setter
public class PartnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpartner")
    private Long idPartner;

    @Column(name = "firstname", nullable = false,length = 100)
    private String firstName;

    @Column(name = "lastname", nullable = false,length = 100)
    private String lastName;

    @Column(name = "email", nullable = false,length = 100)
    private String email;

    @Column(name = "phone", nullable = false,length = 100)
    private String phone;

    @Column(name = "ruc", nullable = false,length = 11)
    private String ruc;

    @Column(name = "rucfile", nullable = true ,length = 500)
    private String rucFile;

    @Column(name = "bank", nullable = true,length = 30)
    private String bank;

    @Column(name = "bankfile", nullable = true,length = 500)
    private String bankFile;

    @Column(name = "bankcertificate", nullable = true,length = 500)
    private String bankCertificate;

    @Column(name = "dnirepresent", nullable = true,length = 11)
    private String dniRepresent;

    @Column(name = "dnifile", nullable = true,length = 500)
    private String dniFile;

    @Column(name = "country", nullable = true,length = 50)
    private String country;

    @Column(name = "address1", nullable = false,length = 250)
    private String address1;

    @Column(name = "address2", nullable = true,length = 250)
    private String address2;

    @Column(name = "facebook", nullable = true,length = 500)
    private String facebook;

    @Column(name = "instagram", nullable = true,length = 500)
    private String instagram;

    @Column(name = "tiktok", nullable = true,length = 500)
    private String tiktok;

    @Column(name = "website", nullable = true,length = 500)
    private String webSite;

    @Column(name = "image", nullable = true,length = 500)
    private String image;

    @Column(name = "status", nullable = false,length = 1)
    private String status;

    @Column(name = "code", nullable = true,length = 100)
    private String code;

    @Column(name = "isactive", nullable = false)
    private Boolean isActive;
    /*
    @Column(name="createdby",nullable = false)
    private Integer createdby;
    */
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

    @Column(name="approveby",nullable = true)
    private Integer approveBy;

    @Column(name="approveat",nullable = true)
    private Timestamp approveAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    private UserEntity users;

}

package com.code.BusinessPartner.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnerDto {

    private Long idPartner;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String ruc;
    private String rucFile;
    private String bank;
    private String bankFile;
    private String bankCertificate;
    private String dniRepresent;
    private String dniFile;
    private String country;
    private String address1;
    private String address2;
    private String facebook;
    private String instagram;
    private String tiktok;
    private String webSite;
    private String image;
    private String status;
    private String code;
    private Boolean isActive;
    private Long idUser;

}

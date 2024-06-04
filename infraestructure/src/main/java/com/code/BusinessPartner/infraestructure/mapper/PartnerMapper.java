package com.code.BusinessPartner.infraestructure.mapper;

import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.infraestructure.entity.PartnerEntity;
import com.code.BusinessPartner.infraestructure.entity.ProductEntity;

public class PartnerMapper {

    public static PartnerDto fromEntity(PartnerEntity partnerEntity){

        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setIdPartner(partnerEntity.getIdPartner());
        partnerDto.setFirstName(partnerEntity.getFirstName());
        partnerDto.setLastName(partnerEntity.getLastName());
        partnerDto.setEmail(partnerEntity.getEmail());
        partnerDto.setPhone(partnerEntity.getPhone());
        partnerDto.setRuc(partnerEntity.getRuc());
        partnerDto.setRucFile(partnerEntity.getRucFile());
        partnerDto.setBank(partnerEntity.getBank());
        partnerDto.setBankFile(partnerEntity.getBankFile());
        partnerDto.setBankCertificate(partnerEntity.getBankCertificate());
        partnerDto.setDniRepresent(partnerEntity.getDniRepresent());
        partnerDto.setDniFile(partnerEntity.getDniFile());
        partnerDto.setCountry(partnerEntity.getCountry());
        partnerDto.setAddress1(partnerEntity.getAddress1());
        partnerDto.setAddress2(partnerEntity.getAddress2());
        partnerDto.setFacebook(partnerEntity.getFacebook());
        partnerDto.setInstagram(partnerEntity.getInstagram());
        partnerDto.setTiktok(partnerEntity.getTiktok());
        partnerDto.setWebSite(partnerEntity.getWebSite());
        partnerDto.setImage(partnerEntity.getImage());
        partnerDto.setStatus(partnerEntity.getStatus());
        partnerDto.setCode(partnerEntity.getCode());
        partnerDto.setIsActive(partnerEntity.getIsActive());
        partnerDto.setIdUser(partnerEntity.getUsers().getIdUser());

        return  partnerDto;

    }

}

package com.code.BusinessPartner.infraestructure.mapper;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.infraestructure.entity.BenefitEntity;

public class BenefitMapper {

    public static BenefitDto fromEntity(BenefitEntity benefitEntity){

        BenefitDto benefitDto = new BenefitDto();
        benefitDto.setIdBenefit(benefitEntity.getIdBenefit());
        benefitDto.setName(benefitEntity.getName());
        benefitDto.setIsActive(benefitEntity.getIsActive());

        return  benefitDto;

    }

}

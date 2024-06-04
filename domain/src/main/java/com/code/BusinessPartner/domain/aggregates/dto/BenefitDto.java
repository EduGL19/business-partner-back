package com.code.BusinessPartner.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenefitDto {

    private Long idBenefit;
    private String name;
    private Boolean isActive;

}

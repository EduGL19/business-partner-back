package com.code.BusinessPartner.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeDto {

    private Long idCode;
    private String code;
    private Boolean available;
    private Boolean isActive;

}

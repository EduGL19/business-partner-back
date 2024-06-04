package com.code.BusinessPartner.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeRequest {

    private Long idCode;
    private String code;
    private Boolean available;
    private Boolean isActive;
    private Long idPartner;

}

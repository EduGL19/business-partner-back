package com.code.BusinessPartner.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceDto {

    private Long idResource;
    private String title;
    private String type;
    private String url;
    private String tags;
    private Boolean isActive;

}

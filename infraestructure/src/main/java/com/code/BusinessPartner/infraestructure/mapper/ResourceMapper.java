package com.code.BusinessPartner.infraestructure.mapper;


import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.infraestructure.entity.ResourceEntity;

public class ResourceMapper {
    public static ResourceDto fromEntity(ResourceEntity resourceEntity){

        ResourceDto resourceDto = new ResourceDto();
        resourceDto.setIdResource(resourceEntity.getIdResource());
        resourceDto.setTitle(resourceEntity.getTitle());
        resourceDto.setUrl(resourceEntity.getUrl());
        resourceDto.setType(resourceEntity.getType());
        resourceDto.setTags(resourceEntity.getTags());
        resourceDto.setIsActive(resourceEntity.getIsActive());

        return  resourceDto;

    }
}

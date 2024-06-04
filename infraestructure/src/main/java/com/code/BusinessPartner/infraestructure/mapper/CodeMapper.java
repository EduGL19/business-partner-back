package com.code.BusinessPartner.infraestructure.mapper;


import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.infraestructure.entity.CodeEntity;

public class CodeMapper {
    public static CodeDto fromEntity(CodeEntity codeEntity){

        CodeDto codeDto = new CodeDto();
        codeDto.setIdCode(codeEntity.getIdCode());
        codeDto.setCode(codeEntity.getCode());
        codeDto.setAvailable(codeEntity.getAvailable());
        codeDto.setIsActive(codeEntity.getIsActive());

        return  codeDto;

    }

}

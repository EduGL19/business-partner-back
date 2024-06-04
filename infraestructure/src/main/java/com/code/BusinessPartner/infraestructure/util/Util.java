package com.code.BusinessPartner.infraestructure.util;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    public  static  String convertirAStringResource(ResourceDto resourceDto){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(resourceDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public  static  <T> T convertirDesdeString(String json,Class<T> tipoClase){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json,tipoClase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}

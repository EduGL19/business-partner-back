package com.code.BusinessPartner.infraestructure.mapper;

import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.infraestructure.entity.SaleEntity;

public class SaleMapper {

    public static SaleDto fromEntity(SaleEntity saleEntity){

        SaleDto saleDto = new SaleDto();
        saleDto.setIdSale(saleEntity.getIdSale());
        saleDto.setIdOrder(saleEntity.getIdOrder());
        saleDto.setOperationDate(saleEntity.getOperationDate());
        saleDto.setCustomer(saleEntity.getCustomer());
        saleDto.setSku(saleEntity.getSku());
        saleDto.setAmount(saleEntity.getAmount());
        saleDto.setSubTotal(saleEntity.getSubTotal());
        saleDto.setDiscount(saleEntity.getDiscount());
        saleDto.setTotal(saleEntity.getTotal());
        saleDto.setCode(saleEntity.getCode());
        saleDto.setPaymentType(saleEntity.getPaymentType());
        saleDto.setStatus(saleEntity.getStatus());
        saleDto.setIsActive(saleEntity.getIsActive());

        return  saleDto;

    }

}

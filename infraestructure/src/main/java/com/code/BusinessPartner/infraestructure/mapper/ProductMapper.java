package com.code.BusinessPartner.infraestructure.mapper;

import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.infraestructure.entity.ProductEntity;

public class ProductMapper {

    public static ProductDto fromEntity(ProductEntity productEntity){

        ProductDto productDto = new ProductDto();
        productDto.setIdProduct(productEntity.getIdProduct());
        productDto.setSku(productEntity.getSku());
        productDto.setName(productEntity.getName());
        productDto.setDescription(productEntity.getDescription());
        productDto.setImage(productEntity.getImage());
        productDto.setUrlPage(productEntity.getUrlPage());
        productDto.setUrlShop(productEntity.getUrlShop());
        productDto.setPriceCurrent(productEntity.getPriceCurrent());
        productDto.setPriceDiscount(productEntity.getPriceDiscount());
        productDto.setIsActive(productEntity.getIsActive());

        return  productDto;

    }

}

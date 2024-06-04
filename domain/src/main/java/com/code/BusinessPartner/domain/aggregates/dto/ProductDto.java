package com.code.BusinessPartner.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long idProduct;
    private String sku;
    private String name;
    private String description;
    private String image;
    private String urlPage;
    private String urlShop;
    private Float priceCurrent;
    private Float priceDiscount;
    private Boolean isActive;

}

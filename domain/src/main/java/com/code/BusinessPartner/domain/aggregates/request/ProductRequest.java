package com.code.BusinessPartner.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private Long idProduct;
    private String sku;
    private String name;
    private String description;
    private String image;
    private String urlPage;
    private String urlShop;
    private Float priceCurrent;
    private Float priceDiscount;

}

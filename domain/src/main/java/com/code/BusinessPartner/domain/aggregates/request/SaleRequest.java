package com.code.BusinessPartner.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class SaleRequest {
    private Long idSale;
    private Long idOrder;
    private Timestamp operationDate;
    private String customer;
    private String sku;
    private Integer amount;
    private Float subTotal;
    private Float discount;
    private Float total;
    private String code;
    private String paymentType;
    private String status;
    private Boolean isActive;

    private String number;

}

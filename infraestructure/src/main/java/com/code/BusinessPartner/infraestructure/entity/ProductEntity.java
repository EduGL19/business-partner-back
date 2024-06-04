package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Long idProduct;

    @Column(name = "sku", nullable = false,length = 50)
    private String sku;

    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 250)
    private String description;

    @Column(name = "image", nullable = false,length = 250)
    private String image;

    @Column(name = "urlpage", nullable = false,length = 250)
    private String urlPage;

    @Column(name = "urlshop", nullable = false,length = 250)
    private String urlShop;

    @Column(name = "pricecurrent", nullable = false)
    private Float priceCurrent;

    @Column(name = "pricediscount", nullable = false)
    private Float priceDiscount;

    @Column(name = "isactive", nullable = false)
    private Boolean isActive;

    @Column(name="createdby",nullable = false)
    private Integer createdby;

    @Column(name="createdat",nullable = false)
    private Timestamp createdAt;

    @Column(name="updatedby",nullable = true)
    private Integer updatedBy;

    @Column(name="updatedat",nullable = true)
    private Timestamp updatedAt;

    @Column(name="rejectby",nullable = true)
    private Integer rejectBy;

    @Column(name="rejectat",nullable = true)
    private Timestamp rejectAt;

}

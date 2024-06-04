package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="sale")
@Getter
@Setter
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsale")
    private Long idSale;

    @Column(name = "idorder", nullable = false)
    private Long idOrder;

    @Column(name="operationdate", nullable = false)
    private Timestamp operationDate;

    @Column(name = "customer", nullable = false,length = 100)
    private String customer;

    @Column(name = "sku", nullable = false,length = 50)
    private String sku;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "subtotal", nullable = false)
    private Float subTotal;

    @Column(name = "discount", nullable = false)
    private Float discount;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "code", nullable = false,length = 100)
    private String code;

    @Column(name = "paymenttype", nullable = false,length = 100)
    private String paymentType;

    @Column(name = "status", nullable = false,length = 1)
    private String status;

    @Column(name="isactive", nullable = false,length = 1)
    private Boolean isActive;

    @Column(name="createdby",nullable = false)
    private Integer createdby;

    @Column(name="createdat",nullable = false)
    private Timestamp createdAt;

    @Column(name="rejectby",nullable = true)
    private Integer rejectBy;

    @Column(name="rejectat",nullable = true)
    private Timestamp rejectAt;

}

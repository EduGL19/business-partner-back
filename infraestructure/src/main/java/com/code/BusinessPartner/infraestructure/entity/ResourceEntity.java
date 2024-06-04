package com.code.BusinessPartner.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="resource")
@Getter
@Setter
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresource")
    private Long idResource;

    @Column(name = "title", nullable = false,length = 100)
    private String title;

    @Column(name = "url", nullable = false,length = 250)
    private String url;

    @Column(name = "type", nullable = false,length = 100)
    private String type;

    @Column(name = "tags", nullable = false,length = 100)
    private String tags;

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

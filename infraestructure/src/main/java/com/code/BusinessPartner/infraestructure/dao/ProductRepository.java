package com.code.BusinessPartner.infraestructure.dao;

import com.code.BusinessPartner.infraestructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}

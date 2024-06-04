package com.code.BusinessPartner.infraestructure.dao;

import com.code.BusinessPartner.infraestructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity,Long> {
}

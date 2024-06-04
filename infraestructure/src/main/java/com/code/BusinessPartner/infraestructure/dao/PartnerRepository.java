package com.code.BusinessPartner.infraestructure.dao;

import com.code.BusinessPartner.infraestructure.entity.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<PartnerEntity,Long> {
}

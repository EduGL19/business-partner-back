package com.code.BusinessPartner.infraestructure.dao;

import com.code.BusinessPartner.infraestructure.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<CodeEntity,Long> {
}

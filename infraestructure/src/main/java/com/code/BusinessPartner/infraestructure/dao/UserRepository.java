package com.code.BusinessPartner.infraestructure.dao;

import com.code.BusinessPartner.infraestructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}

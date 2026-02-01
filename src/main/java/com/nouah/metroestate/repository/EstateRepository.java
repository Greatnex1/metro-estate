package com.nouah.metroestate.repository;

import com.nouah.metroestate.model.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EstateRepository extends  JpaRepository<Estate, Long>, JpaSpecificationExecutor<Estate> {
//    /Optional<Estate> findByEstateId(String id);

    boolean existsByEstateId(String estateId);

}


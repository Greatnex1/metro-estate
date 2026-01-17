package com.nouah.metroestate.repository;

import com.nouah.metroestate.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

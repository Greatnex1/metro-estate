package com.nouah.metroestate.repository;

import com.nouah.metroestate.dto.request.PasswordResetRequest;
import com.nouah.metroestate.model.entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {
    PasswordReset findFirstByEmailAddressOrderByDateCreatedDesc(String email);
}

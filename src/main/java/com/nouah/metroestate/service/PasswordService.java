package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.request.PasswordResetRequest;
import com.nouah.metroestate.dto.response.ApiResponse;

public interface PasswordService {
    ApiResponse requestPasswordReset(String emailAddress);

    ApiResponse resetPassword(PasswordResetRequest passwordResetRequest);

    String encode(String password);

    void validateNewPassword(PasswordResetRequest passwordResetRequest);

    void validateNewPassword(String password);

    ApiResponse validatePasswordResetCode(PasswordResetRequest passwordResetRequest);

    boolean passwordMatch(String rawPassword, String encrypted);
}

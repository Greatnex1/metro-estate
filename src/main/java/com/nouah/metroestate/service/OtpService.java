package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.response.ApiResponse;

public interface OtpService {

        ApiResponse generateOtp(String emailAddress);
}

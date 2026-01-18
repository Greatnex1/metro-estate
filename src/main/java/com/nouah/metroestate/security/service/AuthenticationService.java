package com.nouah.metroestate.security.service;

import com.nouah.metroestate.dto.request.LoginRequest;
import com.nouah.metroestate.dto.response.LoginResponse;
import com.nouah.metroestate.security.model.Token;

public interface AuthenticationService {

    LoginResponse authenticate(LoginRequest loginRequest);
    Token refreshAccessToken(String token);
}

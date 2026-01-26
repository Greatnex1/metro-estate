package com.nouah.metroestate.controller.user;

import com.nouah.metroestate.dto.CustomerDto;
import com.nouah.metroestate.dto.request.CustomerRequest;
import com.nouah.metroestate.dto.request.LoginRequest;
import com.nouah.metroestate.dto.response.BaseResponse;
import com.nouah.metroestate.dto.response.LoginResponse;
import com.nouah.metroestate.security.model.Unsecured;
import com.nouah.metroestate.security.service.AuthenticationService;
import com.nouah.metroestate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nouah.metroestate.util.Constants.BASE_URL;
import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_URL)
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;


//    @Unsecured
    @PostMapping("/create-customer")
    public ResponseEntity<BaseResponse<CustomerDto>> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        CustomerDto customer = userService.createCustomer(customerRequest);
        return new ResponseEntity<>(BaseResponse.success(customer, "Customer created successfully"), CREATED);
    }

    @Unsecured
    @PostMapping("/customer-login")
    public ResponseEntity<BaseResponse<LoginResponse>> customerLogin(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = authenticationService.authenticate(loginRequest);
        return ResponseEntity.ok(BaseResponse.success(loginResponse, "You are successfully logged in."));
    }
}

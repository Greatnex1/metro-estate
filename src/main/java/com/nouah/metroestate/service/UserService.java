package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.CustomerDto;
import com.nouah.metroestate.dto.UserDto;
import com.nouah.metroestate.dto.request.AdminCustomerRequest;
import com.nouah.metroestate.dto.request.CustomerRequest;
import com.nouah.metroestate.dto.request.CustomerUpdateRequest;
import com.nouah.metroestate.dto.request.PasswordResetRequest;
import com.nouah.metroestate.dto.response.ApiResponse;
import com.nouah.metroestate.dto.response.PaginatedResponse;
import com.nouah.metroestate.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface UserService {
    CustomerDto createCustomer(CustomerRequest customerRequest);

    @Transactional
    CustomerDto adminCreateCustomer(AdminCustomerRequest customerRequest);

    CustomerDto updateCustomer(CustomerUpdateRequest customerRequest, String emailAddress);

    ApiResponse updateCustomerProfileImage(String profileImage, String emailAddress);

    CustomerDto getCustomer(String customerId);

    UserEntity getCustomerEntity(String customerId);

    CustomerDto getCustomerByEmail(String emailAddress);

    void updateLastLogin(CustomerDto user);

    void updateLoginAttempts(String emailAddress);

    ApiResponse requestPasswordReset(String emailAddress);

    ApiResponse resetPassword(PasswordResetRequest passwordResetRequest);

    ApiResponse validatePasswordResetCode(PasswordResetRequest passwordResetRequest);

    ApiResponse createPin(String customerId, String pin);

    ApiResponse checkPin(String customerId, String pin);

    ApiResponse resetPinInitiateEmail(String customerId, String phoneNumber);

    ApiResponse verifyResetPinCode(String customerId, String code);

    ApiResponse resetPin(String customerId, String pin);

    ApiResponse allowSaveCard(String customerId, Boolean saveCard);

    PaginatedResponse<List<UserDto>> fetchAllUsersBy(int page, int size, String firstName, String lastName, String email, Long roleId, Boolean isActive);

    ApiResponse toggleEnableUser(String phone);

    UserEntity getUserByEmail(String email);

    UserDto getAllCustomerDetailsByEmail(@NotBlank @Email String emailAddress);

//    UserStatistics getUserStats();
}

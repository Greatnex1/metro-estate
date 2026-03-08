package com.nouah.metroestate.service;

import com.nouah.metroestate.dto.response.ApiResponse;
import com.nouah.metroestate.exception.PasswordException;
import com.nouah.metroestate.model.entity.Otp;
import com.nouah.metroestate.model.entity.UserEntity;
import com.nouah.metroestate.model.enums.OTPType;
import com.nouah.metroestate.model.enums.ResponseStatus;
import com.nouah.metroestate.repository.OtpRepository;
import com.nouah.metroestate.repository.UserRepository;
import com.nouah.metroestate.security.utils.NumberUtils;
import com.nouah.metroestate.util.ResponseUtil;
import com.nouah.metroestate.util.UserValidationUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpServiceImp implements OtpService {

    private final OtpRepository otpRepository;
    private final UserRepository userRepository;


    @Override
    public ApiResponse generateOtp(String emailAddress) {
        log.debug("Request for password reset from customer with email address [{}]", emailAddress);

        if (!UserValidationUtils.isValidEmail(emailAddress)) {
            log.warn("Customer email address [{}] invalid for password reset", emailAddress);
            throw new PasswordException(ResponseStatus.INVALID_EMAIL_ADDRESS);
        }

        Optional<UserEntity> optionalCustomer = userRepository.findByEmail(emailAddress);

        if (optionalCustomer.isEmpty()) {
            log.error("A customer with email address [{}] not found for password reset", emailAddress);
            throw new PasswordException(ResponseStatus.USER_NOT_FOUND);
        }

        try {
            Otp otp = new Otp();
            otp.setEmailAddress(emailAddress);

            String token = NumberUtils.generate(5);

            otp.setOtpCode(token);
            otp.setGeneratedOn(Instant.now());
            otp.setOTPType(OTPType.SIGN_UP);
            otp.setExpiredOn(Instant.now().plus(15, ChronoUnit.MINUTES));
            otpRepository.save(otp);

            log.info("Customer has requested a password reset process and reset code sent to email [{}]", emailAddress);
            return ResponseUtil.createSuccessResponse("otp sent to your email");

        } catch (Exception e) {
            log.error("Failed to request password reset for email address [{}]", emailAddress, e);
            throw new PasswordException(ResponseStatus.PROCESSING_ERROR);
        }
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("try 1");
//        generateOtp("app_owner@ems.com");
//        System.out.println("try 2");
//    }
}

package com.nouah.metroestate.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum ResponseStatus {

        SUCCESS("Successful",HttpStatus.OK),
        INVALID_PHONE_NUMBER("The phone number is invalid: provide international format", HttpStatus.BAD_REQUEST),
        PHONE_NUMBER_NOT_FOUND( "The phone number was not found", HttpStatus.NOT_FOUND),
        EMAIL_ADDRESS_NOT_FOUND( "The email address was not found", HttpStatus.NOT_FOUND),
        INVALID_VERIFICATION_CODE( "The verification code is invalid", HttpStatus.BAD_REQUEST),
        EXPIRED_VERIFICATION_CODE( "The verification code has expired", HttpStatus.BAD_REQUEST),
        PHONE_NUMBER_EXISTS( "A user with that phone number already exists", HttpStatus.BAD_REQUEST),
        INVALID_REFERENCE_CODE( "Invalid reference code", HttpStatus.BAD_REQUEST),

        EMAIL_ADDRESS_EXISTS( "A user with that email address already exists", HttpStatus.BAD_REQUEST),
        INVALID_ESTATE_ID( "Estate does not exist", HttpStatus.BAD_REQUEST),


        USERNAME_EXISTS( "A user with that username already exists", HttpStatus.BAD_REQUEST),

        INVALID_USER_ID( "The user Id is invalid", HttpStatus.BAD_REQUEST),
        USER_NOT_FOUND("The user could not be found", HttpStatus.NOT_FOUND),
        INVALID_EMAIL_ADDRESS("The email address is invalid", HttpStatus.BAD_REQUEST),
        PASSWORD_MISMATCH( "Passwords do not match",HttpStatus.BAD_REQUEST),
        OLD_PASSWORD_INCORRECT( "The old password is incorrect",HttpStatus.BAD_REQUEST),
        PASSWORD_EMPTY( "Empty password(s) provided",HttpStatus.BAD_REQUEST),
        EMAIL_ADDRESS_UNVERIFIED( "Email address has not been verified", HttpStatus.BAD_REQUEST),
        PASSWORD_RESET_CODE_UNVERIFIED( "Password reset code sent to email has not been verified", HttpStatus.BAD_REQUEST),

        INVALID_RESET_CODE( "The reset code is invalid", HttpStatus.BAD_REQUEST),

        EXPIRED_RESET_CODE( "The reset code has expired", HttpStatus.BAD_REQUEST),

        INVALID_PIN_UPDATE("Pin cannot be updated", HttpStatus.BAD_REQUEST),

        PIN_FORMAT_ERROR("Pin must be 4 digit", HttpStatus.BAD_REQUEST),

        WRONG_PIN("Wrong Pin!!", HttpStatus.BAD_REQUEST),

        RESET_PIN_FLAG("exceeded", HttpStatus.BAD_REQUEST),

        INSUFFICIENT_WALLET_BALANCE( "Wallet balance is insufficient for debit", HttpStatus.BAD_REQUEST),

        EMPTY_FIELD_VALUES("Empty field values provided", HttpStatus.BAD_REQUEST),
        FIELD_VALIDATION_ERROR( "The request field(s) failed validations", HttpStatus.BAD_REQUEST),
        REQUEST_BODY_INVALID( "The request body is malformed and could not be parsed", HttpStatus.UNPROCESSABLE_ENTITY),
        UNAUTHORIZED_ACCESS("Access denied, authentication required", HttpStatus.UNAUTHORIZED),
        TOKEN_EXPIRED( "Token is expired", HttpStatus.FORBIDDEN),
        TOKEN_INVALID( "Invalid token", HttpStatus.BAD_REQUEST),
        PROCESSING_ERROR( "Error processing request", HttpStatus.INTERNAL_SERVER_ERROR);


//        private final int code;
        private final String message;
        private final HttpStatus httpStatus;


        ResponseStatus( String message, HttpStatus httpStatus) {
//            this.code = code;
            this.message = message;
            this.httpStatus = httpStatus;

        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
    }

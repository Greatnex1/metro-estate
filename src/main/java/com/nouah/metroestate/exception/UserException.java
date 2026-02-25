package com.nouah.metroestate.exception;

import com.nouah.metroestate.model.enums.ResponseStatus;
import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private ResponseStatus status;
    private Error error;
    private Object details;
    private int code;

    public UserException(String message, int code) {
        super(message);
        this.code = code;
    }
    public UserException(String message){
        super(message);
    }

    public UserException(ResponseStatus status){
        super(status.getMessage());
        this.status = status;

    }

    public UserException(ResponseStatus status, Object details){
        super(status.getMessage());
        this.status = status;
        this.details = details;
    }

    public UserException(String message, Throwable cause){
        super(message,cause);
    }

    public UserException(ResponseStatus status, Throwable cause){
        super(status.getMessage(),cause);
        this.status = status;
    }

    @Override
    public String getMessage(){

        String message = details!=null?super.getMessage()+" : "+details:super.getMessage();
        return message;
    }


    public ResponseStatus getStatus() {
        return status;
    }

    public HttpStatus getHttpStatus() {
        return status.getHttpStatus();
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }


//    public com.nouah.metroestate.dto.Error getError(){
//        error = new com.nouah.metroestate.dto.Error();
//        error.setCode(status.getCode());
//        error.setMessage(status.getMessage());
//        return error;
//    }

    public int getCode() {
        return code;
    }
}


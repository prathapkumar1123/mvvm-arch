package com.sample.framework.mvvm.java.network.responsemodels;

import com.sample.framework.mvvm.java.network.model.Status;

public class BaseResponse<T> {

    private int statusCode;
    private Status status;
    private String message;
    public T responseData;

    public BaseResponse(Status status) {
        this.status = status;
    }

    public BaseResponse(String errorMessage) {
        this.status = Status.ERROR;
        this.message = errorMessage;
    }

    public BaseResponse(Status status, int statusCode, String message, T responseData) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.responseData = responseData;
    }

    public BaseResponse(T responseData) {
        this.status = Status.SUCCESS;
        this.statusCode = 200;
        this.message = "";
        this.responseData = responseData;
    }

    public BaseResponse(int statusCode, T responseData) {
        this.status = Status.SUCCESS;
        this.statusCode = statusCode;
        this.message = "";
        this.responseData = responseData;
    }

    public BaseResponse(int statusCode, String message, T responseData) {
        this.status = Status.SUCCESS;
        this.statusCode = statusCode;
        this.message = message;
        this.responseData = responseData;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}

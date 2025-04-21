package com.HRManagementInformation.core.result;

public class Result {
    private boolean status;
    private String message;
    private String Code;

    public Result() {
    }

    public Result(boolean status, String message, String code) {
        this.status = status;
        this.message = message;
        Code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}

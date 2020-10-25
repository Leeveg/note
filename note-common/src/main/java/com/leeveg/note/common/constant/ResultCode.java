package com.leeveg.note.common.constant;

public enum ResultCode {
    SUCCESS(200, "请求成功"),
    FAIL(4000, "请求失败"),
    ERROR(4001, "系统异常"),
    ;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

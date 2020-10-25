package com.leeveg.note.common.exception;

import com.leeveg.note.common.constant.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 3684691892060517598L;
    @Setter
    @Getter
    private String msg;

    @Setter
    @Getter
    private int code = ResultCode.FAIL.getCode();

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}

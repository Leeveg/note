package com.leeveg.note.api.base;

import com.leeveg.note.api.constant.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMsg<T> implements Serializable {
    private static final long serialVersionUID = 3666124093407460515L;

    private int code;
    private String message;
    private T data;

    public ResultMsg() {
    }

    public ResultMsg(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ResultMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultMsg ok() {
        return new ResultMsg(ResultCode.SUCCESS);
    }

    public static <T> ResultMsg<T> ok(T data) {
        ResultMsg<T> result = new ResultMsg<T>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResultMsg fail() {
        return new ResultMsg(ResultCode.FAIL);
    }

    public static ResultMsg fail(int code,String message) {
        return new ResultMsg(code,message);
    }

    public static ResultMsg fail(String message) {
        return new ResultMsg(ResultCode.FAIL.getCode(),message);
    }

    public static ResultMsg fail(ResultCode resultCode) {
        return new ResultMsg(resultCode);
    }

    public static ResultMsg error() {
        return new ResultMsg(ResultCode.FAIL);
    }

    public static ResultMsg error(String message) {
        return new ResultMsg(ResultCode.FAIL.getCode(),message);
    }
}

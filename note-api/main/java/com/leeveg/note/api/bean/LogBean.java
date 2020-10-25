package com.leeveg.note.api.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogBean implements Serializable {
    private static final long serialVersionUID = 6387497132800752373L;
    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 参数
     */
    private Object parameter;


    /**
     * 请求头
     */
    private Object header;
}

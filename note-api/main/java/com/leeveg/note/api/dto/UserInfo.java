package com.leeveg.note.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -3703001327680533722L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 显示名称
     */
    private String userNickname;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 手机号
     */
    private String userMobile;

    /**
     * 头像连接
     */
    private String userPortrait;
}

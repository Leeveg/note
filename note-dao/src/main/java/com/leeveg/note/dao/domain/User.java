package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("s_user")
public class User extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

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

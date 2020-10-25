package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 实体公共类
 * </p>
 *
 * @author blank
 * @since 2020-04-14
 */
@Data
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 是否有效(0：无效，1：有效)
     */
    private Integer sysStatus;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifier;

    /**
     * 修改日期
     */
    private Date modifyTime;

    /**
     * 操作说明
     */
    private String comment;


}

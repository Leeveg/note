package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("s_menu")
public class Menu extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 排序
     */
    private Integer menuSort;

    /**
     * 父菜单id
     */
    private Long parentId;

    /**
     * 菜单路径
     */
    private String menuUrl;


}

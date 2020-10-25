package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 标签
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_tag_config")
public class TagConfig extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 标签名称
     */
    private String tagName;

}

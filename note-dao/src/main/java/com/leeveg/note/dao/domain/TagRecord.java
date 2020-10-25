package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 标签记录
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_tag_record")
public class TagRecord extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 素材id
     */
    private Long noteEntityId;

    /**
     * 小说id
     */
    private Long storyChapterId;

}

package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小说大纲
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_story_outline")
public class StoryOutline extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 类型：book->大纲，chapter->章节纲要
     */
    private String outlineType;

    /**
     * 内容
     */
    private String outlineContent;

}

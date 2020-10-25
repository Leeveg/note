package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 摘要，素材，笔记
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_note_entity")
public class NoteEntity extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 文章id
     */
    private Long entityId;

    /**
     * 主题id
     */
    private Long topicId;

    /**
     * 题目
     */
    private String entityName;

    /**
     * 内容
     */
    private String entityContent;

    /**
     * 来源
     */
    private String entitySource;

    /**
     * 描述
     */
    private String entityDesc;


}

package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 素材主表
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_note_topic")
public class NoteTopic extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 主题id
     */
    private Long topicId;

    /**
     * 名称
     */
    private String topicName;


}

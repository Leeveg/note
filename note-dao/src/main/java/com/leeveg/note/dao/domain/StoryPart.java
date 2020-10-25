package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 卷
 * </p>
 *
 * @author leeveg
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_story_part")
public class StoryPart extends Entity {

    private static final long serialVersionUID=1L;

    private Long partId;

    /**
     * 书id
     */
    private Long bookId;

    /**
     * 卷名
     */
    private String partName;

    /**
     * 前一卷id
     */
    private Long partBefore;

    /**
     * 后一卷id
     */
    private Long partAfter;


}

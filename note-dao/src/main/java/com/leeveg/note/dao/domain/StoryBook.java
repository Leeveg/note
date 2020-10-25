package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小说题目
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_story_book")
public class StoryBook extends Entity {

    private static final long serialVersionUID=1L;

    private Long bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 类型
     */
    private String bookType;

    /**
     * 作者
     */
    private String bookAuthor;

    /**
     * 描述
     */
    private String bookDesc;


}

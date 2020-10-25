package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 小说内容
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_story_chapter")
public class StoryChapter extends Entity {

    private static final long serialVersionUID=1L;

    private Long chapterId;

    /**
     * 名称
     */
    private String chapterName;

    /**
     * 作者
     */
    private String chapterAuthor;

    /**
     * 描述
     */
    private String chapterDesc;

    /**
     * 内容
     */
    private String chapterContent;

    /**
     * 文章状态：0->编写中；1->已完成；2->已发布；
     */
    private Integer chapterStatus;

    /**
     * 发布时间
     */
    private Date chapterPublishTime;

    /**
     * 父级id
     */
    private Long chapterPartId;

    /**
     * 前一篇文章的id
     */
    private Long chapterBefore;

    /**
     * 后一篇文章的id
     */
    private Long chapterAfter;


}

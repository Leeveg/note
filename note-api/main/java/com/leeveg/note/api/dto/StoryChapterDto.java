package com.leeveg.note.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liz
 * @date 2020-10-26 15:48
 */
@Data
public class StoryChapterDto implements Serializable {
    private static final long serialVersionUID = 8560757230127228982L;

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

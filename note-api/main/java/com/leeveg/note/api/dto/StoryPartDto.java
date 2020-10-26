package com.leeveg.note.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liz
 * @date 2020-10-26 15:47
 */
@Data
public class StoryPartDto implements Serializable {
    private static final long serialVersionUID = -1232773586518162606L;

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

    /**
     * 章节列表
     */
    private List<StoryChapterDto> chapterList;
}

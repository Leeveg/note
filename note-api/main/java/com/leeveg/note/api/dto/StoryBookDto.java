package com.leeveg.note.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liz
 * @date 2020-10-26 15:45
 */
@Data
public class StoryBookDto implements Serializable {

    private static final long serialVersionUID = -5686427362701859549L;

    private Long userId;

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

    private Date createTime;

    /**
     * 卷列表
     */
    List<StoryPartDto> partList;

}

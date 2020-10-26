package com.leeveg.note.api.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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

    private long id;

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
     * 创建者
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改日期
     */
    private Date modifyTime;

    /**
     * 操作说明
     */
    private String comment;

    /**
     * 卷列表
     */
    List<StoryPartDto> partList;

}

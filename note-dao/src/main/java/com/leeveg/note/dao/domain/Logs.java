package com.leeveg.note.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leeveg.note.dao.domain.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("s_logs")
public class Logs extends Entity {

    private static final long serialVersionUID=1L;

    /**
     * 标题
     */
    private String logTitle;

    /**
     * 内容
     */
    private String logContent;


}

package com.leeveg.note.api.param;

import com.leeveg.note.api.bean.PageParam;
import lombok.Data;

/**
 * @author liz
 * @date 2020-10-26 14:58
 */
@Data
public class StoryListParam extends PageParam {

    private static final long serialVersionUID = 3319184075061042418L;

    private long userId;
}

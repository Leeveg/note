package com.leeveg.note.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.param.StoryListParam;
import com.leeveg.note.dao.domain.StoryBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 小说题目 Mapper 接口
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
public interface StoryBookMapper extends BaseMapper<StoryBook> {

    Page<StoryBookDto> queryStoryBookList(Page page, @Param("params") StoryListParam queryParams);
}

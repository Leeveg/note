package com.leeveg.note.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.dao.domain.StoryBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 小说题目 Mapper 接口
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
public interface StoryBookMapper extends BaseMapper<StoryBook> {

    IPage<StoryBook> queryStoryBookList(Page page, StoryBook queryParams);
}

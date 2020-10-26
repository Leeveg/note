package com.leeveg.note.dao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.param.StoryListParam;
import com.leeveg.note.dao.domain.StoryBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 小说题目 服务类
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
public interface IStoryBookService extends IService<StoryBook> {
    Page<StoryBookDto> queryStoryBookList(StoryListParam queryParams);
}

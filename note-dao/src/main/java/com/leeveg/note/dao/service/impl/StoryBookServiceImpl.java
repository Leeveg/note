package com.leeveg.note.dao.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.param.StoryListParam;
import com.leeveg.note.dao.domain.StoryBook;
import com.leeveg.note.dao.mapper.StoryBookMapper;
import com.leeveg.note.dao.service.IStoryBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 小说题目 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Service
public class StoryBookServiceImpl extends ServiceImpl<StoryBookMapper, StoryBook> implements IStoryBookService {

    @Override
    public Page<StoryBookDto> queryStoryBookList(StoryListParam queryParams) {
        Page<StoryBookDto> page = new Page<StoryBookDto>(queryParams.getPageCurrent(), queryParams.getPageSize());
        return baseMapper.queryStoryBookList(page, queryParams);
    }
}

package com.leeveg.note.core.service;

import com.leeveg.note.api.bean.PageInfo;
import com.leeveg.note.api.service.IStoryService;
import com.leeveg.note.dao.domain.StoryBook;
import com.leeveg.note.dao.service.IStoryBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoryService implements IStoryService {

    @Resource
    IStoryBookService storyBookService;

    @Override
    public List<StoryBook> queryStoryBookList(PageInfo pageInfo) {
//        storyBookService.page();
        return null;
    }
}

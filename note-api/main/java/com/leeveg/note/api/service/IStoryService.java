package com.leeveg.note.api.service;

import com.leeveg.note.api.bean.PageInfo;
import com.leeveg.note.dao.domain.StoryBook;

import java.util.List;

public interface IStoryService {

    List<StoryBook> queryStoryBookList(PageInfo pageInfo);

}

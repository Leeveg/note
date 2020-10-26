package com.leeveg.note.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.dto.StoryChapterDto;
import com.leeveg.note.api.dto.StoryPartDto;
import com.leeveg.note.api.param.StoryListParam;

import java.util.List;

public interface IStoryService {

    Page<StoryBookDto> queryStoryBookList(StoryListParam pageParam);

    List<StoryPartDto> getPartByBookId(Long bookId);

    List<StoryChapterDto> getChapterByPartId(Long partId);

    boolean createBook(StoryBookDto dto);

    boolean updateBook(StoryBookDto dto);

    boolean createPart(StoryPartDto dto);

    boolean updatePart(StoryPartDto dto);

    boolean createChapter(StoryChapterDto dto);

    boolean updateChapter(StoryChapterDto dto);
}

package com.leeveg.note.core.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.dto.StoryChapterDto;
import com.leeveg.note.api.dto.StoryPartDto;
import com.leeveg.note.api.param.StoryListParam;
import com.leeveg.note.api.service.IStoryService;
import com.leeveg.note.common.constant.SysStatusConstant;
import com.leeveg.note.common.util.IDGenerator;
import com.leeveg.note.dao.domain.StoryBook;
import com.leeveg.note.dao.domain.StoryChapter;
import com.leeveg.note.dao.domain.StoryPart;
import com.leeveg.note.dao.service.IStoryBookService;
import com.leeveg.note.dao.service.IStoryChapterService;
import com.leeveg.note.dao.service.IStoryPartService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoryService implements IStoryService {

    @Resource
    IStoryBookService storyBookService;

    @Resource
    IStoryPartService storyPartService;

    @Resource
    IStoryChapterService storyChapterService;

    @Override
    public Page<StoryBookDto> queryStoryBookList(StoryListParam param) {
        IPage<StoryBook> page = new Page<StoryBook>(param.getPageCurrent(), param.getPageSize());
        QueryWrapper<StoryBook> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(StoryBook::getTenantId, user.getTenantId());
//                .eq(StoryBook::getAuthId, user.getAuthId())
//                .eq(StoryBook::getSysStatus, SysStatusEnum.ENABLED.getValue())
//                .eq(StoryBook::getAuditStatus, SealGrantAuditStatusEnum.ACCEPTED.getValue())
//                .like(StringUtils.isNotBlank(param.getImageNameLike()), StoryBook::getImageName,
//                        param.getImageNameLike())
//                .eq(param.getType() != null, StoryBook::getType, param.getType())
//                .eq(param.getHoldType() != null, StoryBook::getHoldType, param.getHoldType())
//                .orderByAsc(StoryBook::getHoldType)
//                .orderByDesc(StoryBook::getCrtTime);
        IPage<StoryBook> result = storyBookService.page(page, queryWrapper);

        return null;
    }

    @Override
    public List<StoryPartDto> getPartByBookId(Long bookId) {
        List<StoryPartDto> result = new ArrayList<>();
        QueryWrapper<StoryPart> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StoryPart::getSysStatus, SysStatusConstant.ENABLE)
                .eq(StoryPart::getBookId, bookId)
        ;
        List<StoryPart> storyParts = storyPartService.list(queryWrapper);
        for (StoryPart item : storyParts) {
            StoryPartDto dto = new StoryPartDto();
            BeanUtils.copyProperties(item, dto);
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<StoryChapterDto> getChapterByPartId(Long partId) {
        List<StoryChapterDto> result = new ArrayList<>();
        QueryWrapper<StoryChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StoryChapter::getSysStatus, SysStatusConstant.ENABLE)
                .eq(StoryChapter::getChapterPartId, partId)
        ;
        List<StoryChapter> storyChapters = storyChapterService.list(queryWrapper);
        for (StoryChapter item : storyChapters) {
            StoryChapterDto dto = new StoryChapterDto();
            BeanUtils.copyProperties(item, dto);
            result.add(dto);
        }
        return result;
    }

    @Override
    public boolean createBook(StoryBookDto dto) {
        StoryBook book = new StoryBook();
        BeanUtils.copyProperties(dto, book);
        book.setBookId(IDGenerator.generateId());
        return storyBookService.save(book);
    }

    @Override
    public boolean updateBook(StoryBookDto dto) {
        StoryBook book = new StoryBook();
        BeanUtils.copyProperties(dto, book);
        UpdateWrapper<StoryBook> wrapper = new UpdateWrapper();
        wrapper.lambda().eq(StoryBook::getBookId, dto.getBookId());
        return storyBookService.update(book, wrapper);
    }

    @Override
    public boolean createPart(StoryPartDto dto) {
        StoryPart part = new StoryPart();
        BeanUtils.copyProperties(dto, part);
        part.setPartId(IDGenerator.generateId());
        return storyPartService.save(part);
    }

    @Override
    public boolean updatePart(StoryPartDto dto) {
        StoryPart part = new StoryPart();
        BeanUtils.copyProperties(dto, part);
        UpdateWrapper<StoryPart> wrapper = new UpdateWrapper();
        wrapper.lambda().eq(StoryPart::getPartId, dto.getPartId());
        return storyPartService.update(part, wrapper);
    }

    @Override
    public boolean createChapter(StoryChapterDto dto) {
        StoryChapter chapter = new StoryChapter();
        BeanUtils.copyProperties(dto, chapter);
        chapter.setChapterId(IDGenerator.generateId());
        return storyChapterService.save(chapter);
    }

    @Override
    public boolean updateChapter(StoryChapterDto dto) {
        StoryChapter chapter = new StoryChapter();
        BeanUtils.copyProperties(dto, chapter);
        UpdateWrapper<StoryChapter> wrapper = new UpdateWrapper();
        wrapper.lambda().eq(StoryChapter::getChapterId, dto.getChapterId());
        return storyChapterService.update(chapter, wrapper);
    }

}

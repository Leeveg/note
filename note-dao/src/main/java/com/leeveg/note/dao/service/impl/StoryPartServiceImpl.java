package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.StoryPart;
import com.leeveg.note.dao.mapper.StoryPartMapper;
import com.leeveg.note.dao.service.IStoryPartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 卷 服务实现类
 * </p>
 *
 * @author leeveg
 * @since 2020-10-25
 */
@Service
public class StoryPartServiceImpl extends ServiceImpl<StoryPartMapper, StoryPart> implements IStoryPartService {

}

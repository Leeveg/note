package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.TagRecord;
import com.leeveg.note.dao.mapper.TagRecordMapper;
import com.leeveg.note.dao.service.ITagRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签记录 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Service
public class TagRecordServiceImpl extends ServiceImpl<TagRecordMapper, TagRecord> implements ITagRecordService {

}

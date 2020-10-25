package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.TagConfig;
import com.leeveg.note.dao.mapper.TagConfigMapper;
import com.leeveg.note.dao.service.ITagConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Service
public class TagConfigServiceImpl extends ServiceImpl<TagConfigMapper, TagConfig> implements ITagConfigService {

}

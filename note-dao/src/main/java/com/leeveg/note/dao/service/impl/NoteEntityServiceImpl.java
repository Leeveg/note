package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.NoteEntity;
import com.leeveg.note.dao.mapper.NoteEntityMapper;
import com.leeveg.note.dao.service.INoteEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 摘要，素材，笔记 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-25
 */
@Service
public class NoteEntityServiceImpl extends ServiceImpl<NoteEntityMapper, NoteEntity> implements INoteEntityService {

}

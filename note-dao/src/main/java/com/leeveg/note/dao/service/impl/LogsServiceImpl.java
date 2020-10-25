package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.Logs;
import com.leeveg.note.dao.mapper.LogsMapper;
import com.leeveg.note.dao.service.ILogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements ILogsService {

}

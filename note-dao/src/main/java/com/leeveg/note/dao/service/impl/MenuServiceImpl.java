package com.leeveg.note.dao.service.impl;

import com.leeveg.note.dao.domain.Menu;
import com.leeveg.note.dao.mapper.MenuMapper;
import com.leeveg.note.dao.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}

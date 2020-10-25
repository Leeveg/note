package com.leeveg.note.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.leeveg.note.common.constant.SysStatusConstant;
import com.leeveg.note.dao.domain.User;
import com.leeveg.note.dao.mapper.UserMapper;
import com.leeveg.note.dao.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findUser(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getSysStatus, SysStatusConstant.ENABLE);
        queryWrapper.eq(User::getUserName, username);
        queryWrapper.eq(User::getUserPwd, password);
        return getOne(queryWrapper);
    }
}

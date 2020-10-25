package com.leeveg.note.dao.service;

import com.leeveg.note.dao.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author blank
 * @since 2020-10-24
 */
public interface IUserService extends IService<User> {

    User findUser(String username, String password);
}

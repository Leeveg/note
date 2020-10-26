package com.leeveg.note.core.service;

import com.leeveg.note.api.dto.UserInfo;
import com.leeveg.note.api.service.ILoginService;
import com.leeveg.note.dao.domain.User;
import com.leeveg.note.dao.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService implements ILoginService {
    @Resource
    IUserService userService;
    @Override
    public UserInfo doLogin(String username, String password) {
        User user = userService.findUser(username,password);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        userInfo.setUserId(user.getId());
        return userInfo;
    }
}

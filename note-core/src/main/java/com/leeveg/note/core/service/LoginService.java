package com.leeveg.note.core.service;

import com.leeveg.note.api.service.ILoginService;
import com.leeveg.note.dao.domain.User;
import com.leeveg.note.dao.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService implements ILoginService {
    @Resource
    IUserService userService;
    @Override
    public User doLogin(String username, String password) {
        User user = userService.findUser(username,password);
        return user;
    }
}

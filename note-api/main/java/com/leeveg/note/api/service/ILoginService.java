package com.leeveg.note.api.service;

import com.leeveg.note.api.dto.UserInfo;

public interface ILoginService {
    UserInfo doLogin(String username, String password);
}

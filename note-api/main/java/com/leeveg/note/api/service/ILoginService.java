package com.leeveg.note.api.service;

import com.leeveg.note.dao.domain.User;

public interface ILoginService {
    User doLogin(String username, String password);
}

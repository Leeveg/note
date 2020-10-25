package com.leeveg.note.rest.admin;

import com.leeveg.note.api.service.ILoginService;
import com.leeveg.note.common.base.ResultMsg;
import com.leeveg.note.common.constant.CacheKey;
import com.leeveg.note.dao.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liz
 * @date 2020-10-23 16:02
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    HttpServletRequest request;

    @Resource
    ILoginService loginService;

    @RequestMapping("")
    public String index() {
        return "login";
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public ResultMsg doLogin(@RequestParam("username") String username, @RequestParam("password") String password
            , HttpSession session) {
        if (StringUtils.isAnyBlank(username, password)) {
            return ResultMsg.fail("用户名或密码错误");
        }
        User user = loginService.doLogin(username, password);
        if (user == null) {
            return ResultMsg.fail("用户名或密码错误");
        }
        session.setAttribute(CacheKey.USER_SESSION, user);
        return ResultMsg.ok();
    }

}

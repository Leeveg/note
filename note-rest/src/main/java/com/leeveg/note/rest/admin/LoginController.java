package com.leeveg.note.rest.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liz
 * @date 2020-10-23 16:02
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    HttpServletRequest request;

    @RequestMapping("")
    public String index() {
        return "login";
    }

    @RequestMapping("doLogin")
    public String doLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
        return "index";
    }

}

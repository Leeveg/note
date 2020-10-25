package com.leeveg.note.rest.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liz
 * @date 2020-10-23 15:24
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Resource
    HttpServletRequest request;

    @RequestMapping("")
    public String index() {
        return "index";
    }
}

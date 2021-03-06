package com.leeveg.note.rest.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liz
 * @date 2020-10-23 16:02
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        return "admin/index";
    }
}

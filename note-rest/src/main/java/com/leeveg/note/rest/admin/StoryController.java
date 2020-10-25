package com.leeveg.note.rest.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("story")
public class StoryController {

    @RequestMapping({"", "index"})
    public String index() {
        return "/story/storyList";
    }
}

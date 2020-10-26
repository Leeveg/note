package com.leeveg.note.rest.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeveg.note.api.dto.StoryBookDto;
import com.leeveg.note.api.param.StoryListParam;
import com.leeveg.note.api.service.IStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("story")
public class StoryController {

    @Resource
    IStoryService storyService;

    @RequestMapping({"", "index"})
    public String index(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        StoryListParam param = new StoryListParam();
        param.setPageCurrent(current);
        param.setPageSize(size);
        Page<StoryBookDto> pageInfo = storyService.queryStoryBookList(param);
        model.addAttribute("pageInfo", pageInfo);
        return "/story/storyList";
    }
}

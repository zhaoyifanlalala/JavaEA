package club.banyuan.blog.controller;

import club.banyuan.blog.service.IndexService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping({"/" , "/index"})
    public String showHomepage(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "10") Integer size,
                               Model model){
        //获取blogs，按时间倒排
        PageInfo info = indexService.sortBlogsByDate(page,size);
        model.addAttribute("blogs",info);
        return "index";
    }
}

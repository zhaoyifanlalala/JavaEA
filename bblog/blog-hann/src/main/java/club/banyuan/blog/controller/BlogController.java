package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.exception.NotFoundException;
import club.banyuan.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog/{id}")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String showBlog(@PathVariable Integer id, Model model){
        Blog blog = blogService.findBlogById(id);
        if (blog == null){
            throw new NotFoundException("blog not found");
        }
        //PageInfo info = blogService.findBlogs(,1,10);
        //model.addAttribute("blogs",info);
        model.addAttribute("blog",blog);
        return "item";
    }
}

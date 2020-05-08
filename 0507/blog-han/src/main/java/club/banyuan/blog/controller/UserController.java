package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import club.banyuan.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Character.SIZE;

@Controller
public class UserController {
    private static final Integer PAGE = 10;

    @GetMapping("/user/{username:[a-z0-9_]+}")
    @ResponseBody
    public User showUser(@PathVariable String username){
        UserService userService=new UserService();
        User user = userService.findByName(username);
        return user;
    }
    @GetMapping("/user/blog/{username:[a-z0-9_]+}")
    @ResponseBody
    public List<Blog> showBlogUser(
            @PathVariable String username,
            @RequestParam(defaultValue = "1") Integer PAGE,
            @RequestParam(defaultValue = "10") Integer SIZE){
        BlogService blogService=new BlogService();
        UserService userService=new UserService();
        User user = userService.findByName(username);
        List<Blog> blogList = blogService.findBlogs(user);
        List<Blog> list = new ArrayList<>();
        for (int i = (PAGE - 1) * 10; i < (PAGE - 1) * 10 + SIZE; i++) {
            list.add(blogList.get(i));
        }
        return list;
    }

}


package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import club.banyuan.blog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;

@Controller
public class AdminController {
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    //@GetMapping("/admin/{username}")
    @GetMapping("/admin/blog")
    public String adminBlog(
                            @RequestParam(required = false,defaultValue = "1")Integer page,
                            @RequestParam(required = false,defaultValue = "10")Integer size,
                            HttpSession session,
                            Model model,
                            Principal principal) throws UnsupportedEncodingException {
        //判断用户是否已经登录，是否可以访问这个页面
        //User user = (User) session.getAttribute("CURRENT_USER");
            String username = principal.getName();
            User user= userService.findByName(username);
        //PageInfo info = blogService.findBlogsByUsername(username, page, size);
        PageInfo info = blogService.findBlogsByUsername(username, page, size);
        model.addAttribute("blogs", info);
        return "admin-blogs";
    }

    //编辑博客
    @GetMapping("/admin/blog/{id}/edit")
    public String adminBlogEdit(@PathVariable Integer id,
                                 Model model) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }


    //@PostMapping("/admin/blog/{id}/edit")
    @PutMapping("/admin/blog/{id}/edit")
    public String editBlog(
            HttpSession session,
//            Principal principal,
            @Valid @RequestParam @Size(min=10, max=20) String title,
            @RequestParam String content,
            @PathVariable Integer id) throws UnsupportedEncodingException {

        //保存这篇blog
        blogService.saveBlog(id,title,content);
        //String username = ((User)session.getAttribute("CURRENT_USER")).getName();
//        String username = principal.getName();
//        User user= userService.findByName(username);

        //return "redirect:/admin/" + URLEncoder.encode(username,"UTF-8");
        return "redirect:/admin/blog";
    }



    @DeleteMapping("/admin/blog/{id}")
    public String deleteBlog(
            HttpSession session,
            Principal principal,
            @PathVariable Integer id) throws UnsupportedEncodingException {
        blogService.deleteBlog(id);
        //String username = ((User)session.getAttribute("CURRENT_USER")).getName();
        String username = principal.getName();
        User user= userService.findByName(username);

        //return "redirect:/admin/" + URLEncoder.encode(username,"UTF-8");
        return "redirect:/admin/blog";
    }


    @GetMapping("/admin")
    public String UserAdmin(
            HttpSession session,
            HttpServletRequest req,
            Model model,
            Principal principal) {
        String username = principal.getName();
        User user= userService.findByName(username);
        //User user = (User) session.getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        return "admin";
    }
    @GetMapping("/admin/blog/create")
    public String showBlogCreatePage(){
        return "create";
    }
    @PostMapping("/admin/blog/create")
    String createBlog(@RequestParam(value = "title") String title,
                      @RequestParam(value = "content") String content,
                      Principal principal){
        User user = userService.findByName(principal.getName());
        Blog blog = new Blog();
        blog.setAuthor(user);
        blog.setTitle(title);
        blog.setContent(content);
        Integer blogId = blogService.addBlog(blog);
        return "redirect:/blog/" + blogId;
    }

}

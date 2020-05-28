package club.banyuan.blog.controller;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import club.banyuan.blog.service.LoginService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller

public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) throws UnsupportedEncodingException {
        //验证用户登录
        User user = loginService.login(username,password);
        if (user == null){
            return "Login";
        }

        //将用户信息放入Session
        session.setAttribute("CURRENT_USER",user);

//        PageInfo info = blogService.findBlogs(user,1,10);
//        model.addAttribute("blogs",info);
//
//        return "redirect:/admin/"+ URLEncoder.encode(username,"UTF-8") ;
        String next = (String)session.getAttribute("next");
        if (next == null) {
            PageInfo info = blogService.findBlogs(user, 1, 10);
            model.addAttribute("blogs", info);
            return "redirect:/admin/blog";
        } else {
            return "redirect:" + next;
        }

    }


    @PostMapping("/logout")
    public String logout(HttpSession session){
        User user = (User) session.getAttribute("CURRENT_USER");
        if (user != null){
            session.removeAttribute("CURRENT_USER");
        }
        return "redirect:/";
    }
}

package club.banyuan.blog.controller;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.MailService;
import club.banyuan.blog.service.RedisService;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    MailService mailService;
    @Autowired
    RedisService redisService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    @PostMapping("/register")
    public String UserRegister(@RequestParam(value = "name") String name,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "email") String email,
                               HttpSession session,
                               Model model,
                               Principal principal){
        //User user = userService.findByName(principal.getName());
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userService.addUser(user);

        String token =String.valueOf(new Random().nextInt(900) + 100);
        redisService.testRedis(token,user.getName());
        mailService.sendTestMail(email,"http://localhost:8090/activated?token="+token);
        return "redirect:/login/";
    }
}

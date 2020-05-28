package club.banyuan.blog.controller;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.RedisService;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivatedController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @GetMapping("/activated")
    public String activated (@RequestParam(value = "token") String token) {
        String activatedToken = redisService.getRedisValue(token);

        userService.updateActivated(activatedToken);

        return "login";
    }
}

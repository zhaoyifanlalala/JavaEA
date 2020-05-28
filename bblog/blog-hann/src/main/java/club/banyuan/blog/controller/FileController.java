package club.banyuan.blog.controller;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class FileController {
    private String ROOT = "/Users/edz/aaa/";

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private UserService userService;

    @GetMapping("/avatar/{name}")
    @ResponseBody
    public ResponseEntity showImg(@PathVariable String name) {
        return ResponseEntity.ok(resourceLoader.getResource("file:" + ROOT + name));
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file,
                         HttpSession session,
                         Principal principal) throws IOException {
        //User user = (User) session.getAttribute("CURRENT_USER");
        String username = principal.getName();
        User user= userService.findByName(username);


        Path target = Paths.get(ROOT, user.getName());
        Files.deleteIfExists(target);
        Files.copy(file.getInputStream(), target);
        return "redirect:/admin";
    }

}

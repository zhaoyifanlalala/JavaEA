package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;

public class UserService {
    public User findByName(String username) {
        return new User("zhangsan", 21);
    }
}

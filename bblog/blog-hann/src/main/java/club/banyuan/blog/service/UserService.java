package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findByName(String username) {
        return userDao.getUserByName(username);

    }

    //@CacheEvict(value = "index",allEntries = true)
    public User addUser(User user) {
        userDao.insertUser(user);
        return userDao.getUserByName(user.getName());
    }

    public void updateActivated(String name) {
        userDao.updateActivated(name);
//        return userDao.getUserByName(user.getName());
    }
}

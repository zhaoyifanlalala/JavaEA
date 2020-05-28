package club.banyuan.blog.dao;

import club.banyuan.blog.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserById(Integer id);
    public User getUserByName(String name);
    public void insertUser(User user);
    public void updateActivated(String name);
}

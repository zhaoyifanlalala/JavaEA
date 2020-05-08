package club.banyuan.blog.service;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;

import java.util.ArrayList;
import java.util.List;

public class BlogService {
    public List<Blog> findBlogs(User user) {
        List<Blog> blogs = new ArrayList<>();
        for (Integer i = 0; i < 222; i++) {
            Blog blog = new Blog(i, "title " + i, "content " + i);
            blogs.add(blog);
        }
        return blogs;
    }
}

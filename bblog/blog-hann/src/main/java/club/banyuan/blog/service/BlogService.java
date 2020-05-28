package club.banyuan.blog.service;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.dao.BlogDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogDao blogDao;
    @Autowired
    UserService userService;

    public PageInfo findBlogs(User user,Integer page,Integer size){
        PageHelper.startPage(page,size,"id desc");
        return new PageInfo(blogDao.findBlogsByUserId(user.getId()));
    }
    public PageInfo findBlogsByUsername(String username, Integer page, Integer size) {
        //  根据username获取该user的所有blog
//        User user = userService.findByName(username);
//        PageHelper.startPage(page, size, "id asc");
//        return new PageInfo(blogDao.findBlogsByUserId(user.getId()));
        User user = userService.findByName(username);
        return findBlogs(user,page,size);
    }
    public Blog findBlogById(Integer id) {
        // ?? dao
        Blog blog = blogDao.findBlogById(id);
        return blog;
    }

    public void saveBlog(Integer id, String title, String content){
        blogDao.saveBlog(id, title, content);
    }

    public void deleteBlog(Integer id){
        blogDao.deleteBlog(id);
    }

    @CacheEvict(value = "index",allEntries = true)
    public Integer addBlog(Blog blog) {
        blogDao.insertBlog(blog);
        return blog.getId();
    }
}







//    public List<Blog> findBlogs(User user) {
//        List<Blog> blogs = new ArrayList<>();
//        for (Integer i = 0; i < 100; i++) {
//            Blog blog = new Blog(i, "title " + i, "content " + i);
//            blogs.add(blog);
//        }
//        return blogs;
//    }



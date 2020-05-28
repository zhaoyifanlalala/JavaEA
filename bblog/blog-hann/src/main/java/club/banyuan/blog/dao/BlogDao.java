package club.banyuan.blog.dao;

import club.banyuan.blog.bean.Blog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {
    //@Select("select * from blog where id = #{id}")

    public Blog findBlogById(Integer id);

    public List<Blog> findBlogsByUserId(Integer userId);

    public List<Blog> selectAllBlogs();

    //public List<Blog> sortBlogs(String fieldName, String order);

    public void saveBlog(Integer id,String title,String content);

    public void deleteBlog(Integer id);

    public void insertBlog(Blog blog);
}

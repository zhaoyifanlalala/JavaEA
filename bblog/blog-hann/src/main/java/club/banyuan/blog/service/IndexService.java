package club.banyuan.blog.service;

import club.banyuan.blog.dao.BlogDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class IndexService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlogDao blogDao;

    @Cacheable(value = "index")
    public PageInfo sortBlogsByDate(Integer page, Integer size){
        PageHelper.startPage(page, size,"created_time asc");
        logger.info("return from sort method");
        return new PageInfo(blogDao.selectAllBlogs());

    }
}

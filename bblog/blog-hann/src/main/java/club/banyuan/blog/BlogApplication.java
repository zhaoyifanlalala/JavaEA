package club.banyuan.blog;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.dao.BlogDao;
import club.banyuan.blog.dao.UserDao;
import club.banyuan.blog.service.MailService;
import club.banyuan.blog.service.RedisService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("club.banyuan")
@MapperScan("club.banyuan.blog.dao")
@EnableCaching

public class BlogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
		BlogDao blogDao = context.getBean(club.banyuan.blog.dao.BlogDao.class);
		Blog blog = blogDao.findBlogById(11);
		UserDao userDao = context.getBean(club.banyuan.blog.dao.UserDao.class);
		User user = userDao.getUserById(1);
		System.out.println(blog);
		System.out.println(user);

		MailService mailService = context.getBean(club.banyuan.blog.service.MailService.class);
		//mailService.sendTestMail("1035710787@qq.com","欢迎欢迎");

		RedisService redisService = context.getBean(club.banyuan.blog.service.RedisService.class);
		//redisService.testRedis(user,);
    }
}

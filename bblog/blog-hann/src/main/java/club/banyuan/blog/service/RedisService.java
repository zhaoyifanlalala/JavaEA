package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void testRedis(String token,String name){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(token,name,10,TimeUnit.MINUTES);
        logger.info(String.valueOf(valueOperations.get(token)));
//        ListOperations<String,String> listOperations = redisTemplate.opsForList();
//        listOperations.leftPush("b","1");
//        listOperations.leftPush("b","2");

    }

    public String getRedisValue (String token) {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(token);
    }

}

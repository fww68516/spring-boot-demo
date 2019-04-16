package com.springboot.demo.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheTestService {
    public static final Logger logger = LoggerFactory.getLogger(CacheTestService.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        CacheTestService cacheTestService = new CacheTestService();
        cacheTestService.set();
    }

    public void set(){
        logger.info("测试redis》》》》》》》》》》》》》》》");
        stringRedisTemplate.opsForValue().set("test001","test001Values");
//        redisTemplate.opsForValue().set("test:set","testValues1");
    }
}

package com.springboot.demo;

import com.springboot.demo.redis.CacheTestService;
import javafx.geometry.VPos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class DemoApplicationTests {

   /* @Autowired
    CacheTestService cacheTestService;*/

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set(){
//        redisTemplate.opsForValue().set("test:set1","testValues1");
        for (int i = 0; i < 50; i++) {
            Long idtest = redisTemplate.opsForValue().increment("idtest", 1);
            System.out.println("生成的idtest：" +idtest);
        }
    }

    @Test
    public void contextLoads() {
        //这里相当于redis对String类型的set操作
        redisTemplate.opsForValue().set("test","helloworld");
        //这里相当于redis对String类型的get操作
        String test = (String)redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }

}

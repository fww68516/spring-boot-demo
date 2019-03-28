package com.springboot.demo;

import com.springboot.demo.redis.CacheTestService;
import javafx.geometry.VPos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    CacheTestService cacheTestService;

    @Test
    public void cacheTest(){
        for (int i = 5; i<5; i++){
            System.out.println(cacheTestService.getDate());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void contextLoads() {
    }

}

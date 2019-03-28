package com.springboot.demo.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

public class CacheTestService {
    public static final Logger logger = LoggerFactory.getLogger(CacheTestService.class);

    @Cacheable(value = "getDate")
    public String getDate(){
        System.out.println("======看见这句话");
        return "系统当前时间戳" + System.currentTimeMillis();
        
    }
}

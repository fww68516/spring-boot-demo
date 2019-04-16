package com.springboot.demo.controller;

import com.springboot.demo.config.KeyExpiredListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.security.Key;

public class TestJedis {

        public static void main(String[] args) throws InterruptedException {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(100);
            jedisPoolConfig.setMaxIdle(20);
            jedisPoolConfig.setMaxWaitMillis(100000L);
            jedisPoolConfig.setTestOnBorrow(false);
            jedisPoolConfig.setTestOnReturn(false);
            JedisPool pool = new JedisPool(jedisPoolConfig, "127.0.0.1");

            Jedis jedis = pool.getResource();
            jedis.select(0);
            jedis.set("notify", "123");
            jedis.expire("notify", 3);


        }


}

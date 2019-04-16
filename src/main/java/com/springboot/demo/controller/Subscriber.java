package com.springboot.demo.controller;

import com.springboot.demo.config.KeyExpiredListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class Subscriber {

    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
        Jedis jedis = pool.getResource();
        config(jedis);//最重要的部分
        jedis.psubscribe(new KeyExpiredListener(), "__keyevent@0__:expired");
    }
    private static void config(Jedis jedis){
        String parameter = "notify-keyspace-events";
        List<String> notify = jedis.configGet(parameter);
        if(notify.get(1).equals("")){
            jedis.configSet(parameter, "Ex"); //过期事件
        }
    }


}

package com.springboot.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

import java.sql.SQLOutput;

@Component
public class KeyExpiredListener  extends JedisPubSub {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel:" + channel + "receives message :" + message);
        String str = (String) redisTemplate.getValueSerializer().deserialize(message.getBytes());
        System.out.println(str);
    }

    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribepattern：" + pattern);
        System.out.println("onPSubscribesubscribedChannels：" + subscribedChannels);
        System.out.println("onPSubscribeonPSubscribe："
                + pattern + " " + subscribedChannels);
    }
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage->pattern：" + pattern);
        System.out.println("onPMessage->channel：" + channel);
        System.out.println("onPMessage->message：" + message);
        System.out.println("onPMessage->onPMessage pattern："
                + pattern + " " + channel + " " + message);
    }

}

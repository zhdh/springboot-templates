package com.example.springbootredis.util;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key key
     * @param time time (seconds)
     */
    public boolean expire(String key,  long time){
        try{
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据 key 获取过期时间
     * @param key key
     * @return time (seconds)
     */
    public long getExpire(@NotNull String key){
        try{
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
            return -1L;
        }
    }

    /**
     * 判断 key 是否存在
     */
    public boolean hasKey(@NotNull String key){
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储数据
     */
    public void set(String key, String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 根据 key 取值
     */
    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }



}

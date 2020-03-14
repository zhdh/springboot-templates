package com.example.springbootredis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        // 设置序列化 Key 的实例化对象
        template.setKeySerializer(new StringRedisSerializer());
        // 设置序列化 Value 的实例化对象
        template.setHashValueSerializer( new GenericJackson2JsonRedisSerializer());
        return template;
    }

}

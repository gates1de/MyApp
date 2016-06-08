package com.example.myapp.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class AppConfig {
		@Value("${spring.redis.host}")
		private String redisHostName;

		@Value("${spring.redis.port}")
		private int redisPort;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
				JedisConnectionFactory factory = new JedisConnectionFactory();
				factory.setHostName(redisHostName);
				factory.setPort(redisPort);
        return factory; 
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
				template.setConnectionFactory(jedisConnectionFactory());
				template.setKeySerializer(new StringRedisSerializer());
				template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
        return template;
    }
}

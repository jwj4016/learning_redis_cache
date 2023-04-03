package com.example.learning_redis_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCacheLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheLearningApplication.class, args);
    }

}

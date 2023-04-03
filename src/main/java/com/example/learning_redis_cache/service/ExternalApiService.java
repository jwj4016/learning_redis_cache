package com.example.learning_redis_cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

    public String getUserName(String userId){
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if (userId.equals("userA")) {
            return "USER_A";
        }
        if (userId.equals("userB")) {
            return "USER_B";
        }

        return "";
    }

    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        System.out.println("2. getUserAge 메소드 내부입니다.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (userId.equals("userA")) {
            return 20;
        }
        if (userId.equals("userB")) {
            return 30;
        }

        return 0;



    }
}

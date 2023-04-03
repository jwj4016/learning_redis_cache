package com.example.learning_redis_cache.service;

import com.example.learning_redis_cache.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class UserService {
    final private ExternalApiService externalApiService;

    final private StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {
        System.out.println("*******************start*******************");
        StopWatch redisConnectionStopWatch = new StopWatch();
        StopWatch externalApiStopWatch = new StopWatch();

        redisConnectionStopWatch.start();
        String userName;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);
        redisConnectionStopWatch.stop();
        System.out.println("레디스 connection 시간 : " + redisConnectionStopWatch.getTotalTimeSeconds());
        if (cachedName != null) {
            userName = cachedName;
        } else {
            externalApiStopWatch.start();
            userName = externalApiService.getUserName(userId);
            ops.set("nameKey:" + userId, userName,5 ,TimeUnit.SECONDS);
            externalApiStopWatch.stop();
            System.out.println("External API 시간 : " + externalApiStopWatch.getTotalTimeSeconds());
        }

        System.out.println("1. getUSerAge 메소드가 호출됩니다.");
        int userAge = externalApiService.getUserAge(userId);

        System.out.println("*******************end*******************");
        return new UserProfile(userName, userAge);
    }
}

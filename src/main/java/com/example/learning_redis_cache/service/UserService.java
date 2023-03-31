package com.example.learning_redis_cache.service;

import com.example.learning_redis_cache.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    ExternalApiService externalApiService;
    public UserProfile getUserProfile(String userId) {
        String userName = externalApiService.getUserName(userId);
        int userAge = externalApiService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }
}

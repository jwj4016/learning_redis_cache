package com.example.learning_redis_cache.controller;

import com.example.learning_redis_cache.dto.UserProfile;
import com.example.learning_redis_cache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {
    UserService userService;

    @GetMapping("/users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable String userId){
        return userService.getUserProfile(userId);
    }
}

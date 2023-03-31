package com.example.learning_redis_cache.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

public record UserProfile (
        String name
        , int age){
}

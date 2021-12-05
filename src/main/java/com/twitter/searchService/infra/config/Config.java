package com.twitter.searchService.infra.config;

import com.twitter.searchService.domain.usecase.UserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public UserCase userCase(){
        return new UserCase();
    }
}

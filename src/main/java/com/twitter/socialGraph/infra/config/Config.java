package com.twitter.socialGraph.infra.config;

import com.twitter.socialGraph.domain.usecase.UserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public UserCase userCase(){
        return new UserCase();
    }
}

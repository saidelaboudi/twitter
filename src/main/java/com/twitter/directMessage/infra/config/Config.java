package com.twitter.directMessage.infra.config;

import com.twitter.directMessage.domain.usecase.DirectMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DirectMessage UseCaseBean(){
        return new DirectMessage();
    }
}

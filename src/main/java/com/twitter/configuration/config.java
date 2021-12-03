package com.twitter.configuration;

import com.twitter.directMessage.domain.usecase.DirectMessage;
import com.twitter.socialGraph.domain.usecase.SocialGraph;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public DirectMessage DirectMessageBean(){
        return new DirectMessage();
    }

    @Bean
    public SocialGraph SocialGraphBean(){
        return new SocialGraph();
    }
}

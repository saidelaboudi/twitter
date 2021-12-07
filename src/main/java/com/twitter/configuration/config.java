package com.twitter.configuration;

import com.twitter.directMessage.domain.port.infra.IDirectMessageInfraPort;
import com.twitter.directMessage.domain.port.infra.IGroupInfraPort;
import com.twitter.directMessage.domain.usecase.DirectMessage;
import com.twitter.directMessage.infra.adapter.DirectMessageInfraPortAdapter;
import com.twitter.directMessage.infra.adapter.GroupInfraAdapter;
import com.twitter.directMessage.infra.service.IDirectMessageService;
import com.twitter.directMessage.infra.service.IGroupeService;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.socialGraph.domain.port.service.IUserTweeterPort;
import com.twitter.socialGraph.domain.usecase.SocialGraph;
import com.twitter.socialGraph.infra.adapter.SocialGraphAdapter;
import com.twitter.socialGraph.infra.adapter.service.UserServiceAdapter;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import com.twitter.socialGraph.infra.service.IUserService;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.domain.usecase.TweetUseCase;
import com.twitter.tweet.infra.adapter.TweetInfraAdapter;
import com.twitter.tweet.infra.service.ITweetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public SocialGraphAdapter SocialGraphAdapterBean(IUserService userServices,
                                                     ISocialGraphService graphServices) {
        return new SocialGraphAdapter(userServices, graphServices);
    }

    @Bean
    GroupInfraAdapter GroupInfraAdapterBean(IGroupeService iGroupeService) {
        return new GroupInfraAdapter(iGroupeService);
    }

    @Bean
    public DirectMessage DirectMessageBean(IDirectMessageInfraPort directMessageInfra,
                                           IUserInfraPort userInfrastructure,
                                           IGroupInfraPort groupInfraPort) {
        return new DirectMessage(
                directMessageInfra,
                userInfrastructure,
                groupInfraPort
        );
    }

    @Bean
    public DirectMessageInfraPortAdapter DirectMessageInfraPortAdapterBean(IDirectMessageService directMessageServices) {
        return new DirectMessageInfraPortAdapter(directMessageServices);
    }

    @Bean
    public SocialGraph SocialGraphBean(ISocialGraphInfrastructure iSocialGraphInfrastructure,
                                       IUserInfraPort iUserInfraPort) {
        return new SocialGraph(iSocialGraphInfrastructure, iUserInfraPort);
    }

    @Bean
    public TweetUseCase TweetUseCaseBean(ITweetPortToInfra portToInfra,
                                         IUserTweeterPort userInfraPort) {
        return new TweetUseCase(portToInfra, userInfraPort);
    }

    @Bean
    public UserServiceAdapter UserServiceAdapterBean() {
        return new UserServiceAdapter();
    }

    @Bean
    public TweetInfraAdapter TweetInfraAdapterBean(ITweetService tweetServices) {
        return new TweetInfraAdapter(tweetServices);
    }

}

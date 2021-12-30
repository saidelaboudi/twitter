package com.twitter.configuration;

import com.twitter.directMessage.domain.port.infra.IDirectMessageInfraPort;
import com.twitter.directMessage.domain.port.infra.IGroupInfraPort;
import com.twitter.directMessage.domain.usecase.DirectMessage;
import com.twitter.directMessage.infra.adapter.DirectMessageInfraPortAdapter;
import com.twitter.directMessage.infra.adapter.GroupInfraAdapter;
import com.twitter.directMessage.infra.service.IDirectMessageService;
import com.twitter.directMessage.infra.service.IGroupeService;
import com.twitter.searchService.domain.port.infra.ISearchServiceInfrastructure;
import com.twitter.searchService.domain.usecase.UserCase;
import com.twitter.searchService.infra.adapter.SearchServiceAdapter;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.socialGraph.domain.port.service.IUserTweeterPort;
import com.twitter.socialGraph.domain.usecase.SocialGraph;
import com.twitter.socialGraph.domain.usecase.UserUseCase;
import com.twitter.socialGraph.infra.adapter.SocialGraphAdapter;
import com.twitter.socialGraph.infra.adapter.service.UserServiceAdapter;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import com.twitter.socialGraph.infra.service.IUserService;
import com.twitter.tweet.domain.port.infra.IReactionInfraPort;
import com.twitter.tweet.domain.port.infra.ITweetPortToInfra;
import com.twitter.tweet.domain.usecase.TweetUseCase;
import com.twitter.tweet.infra.adapter.TweetInfraAdapter;
import com.twitter.tweet.infra.service.ITweetService;
import com.twitter.userTimeLineService.domain.usecase.userTimeLine;
import com.twitter.userTimeLineService.infra.adapter.ReactionInfraAdapter;
import com.twitter.userTimeLineService.infra.service.IReactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = {
        "com.twitter.directMessage.infra.repository",
        "com.twitter.socialGraph.infra.repository",
        "com.twitter.tweet.infra.repository",
        "com.twitter.userTimeLineService.infra.repository"
})
public class config {
    @Bean
    public DirectMessage DirectMessageBean(IDirectMessageInfraPort directMessageInfra, IUserInfraPort userInfrastructure, IGroupInfraPort groupInfraPort) {
        return new DirectMessage(directMessageInfra, userInfrastructure, groupInfraPort);
    }

    @Bean
    public DirectMessageInfraPortAdapter DirectMessageInfraPortAdapterBean(IDirectMessageService directMessageServices) {
        return new DirectMessageInfraPortAdapter(directMessageServices);
    }

    @Bean
    public GroupInfraAdapter GroupInfraAdapterBean(IGroupeService iGroupeService) {
        return new GroupInfraAdapter(iGroupeService);
    }

    @Bean
    public UserCase UserCaseBean(ISearchServiceInfrastructure iSearchServiceInfrastructure) {
        return new UserCase(iSearchServiceInfrastructure);
    }

    @Bean
    public SearchServiceAdapter SearchServiceAdapterBean( IUserInfraPort userInfraPort, ITweetPortToInfra tweetPortToInfra) {
        return new SearchServiceAdapter(userInfraPort, tweetPortToInfra);
    }

    @Bean
    public SocialGraph SocialGraphBean(ISocialGraphInfrastructure iSocialGraphInfrastructure, IUserInfraPort iUserInfraPort) {
        return new SocialGraph(iSocialGraphInfrastructure, iUserInfraPort);
    }

    @Bean
    public UserUseCase UserUseCaseBean(IUserInfraPort userInfraPort) {
        return new UserUseCase(userInfraPort);
    }

    @Bean
    public SocialGraphAdapter SocialGraphAdapterBean(IUserService userServices, ISocialGraphService graphServices) {
        return new SocialGraphAdapter(userServices, graphServices);
    }

    @Bean
    public UserServiceAdapter UserServiceAdapterBean(IUserService userServices) {
        return new UserServiceAdapter(userServices);
    }

    @Bean
    public TweetUseCase TweetUseCaseBean(ITweetPortToInfra portToInfra, IUserTweeterPort userInfraPort) {
        return new TweetUseCase(portToInfra, userInfraPort);
    }

    @Bean
    public TweetInfraAdapter TweetInfraAdapterBean(ITweetService tweetServices, IUserInfraPort userInfraPort) {
        return new TweetInfraAdapter(tweetServices, userInfraPort);
    }

    @Bean
    public userTimeLine userTimeLineBean(ITweetPortToInfra portToInfra, IUserTweeterPort userInfraPort, IReactionInfraPort reactionInfraPort) {
        return new userTimeLine(portToInfra, userInfraPort, reactionInfraPort);
    }

    @Bean
    public ReactionInfraAdapter ReactionInfraAdapterBean(IReactionService reactionService) {
        return new ReactionInfraAdapter(reactionService);
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList(
                "Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
                "Authorization", "Origin", "Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"
        ));
        corsConfiguration.setExposedHeaders(Arrays.asList(
                "Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials"
        ));
        corsConfiguration.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return  new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
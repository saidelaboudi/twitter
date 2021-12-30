package com.twitter.socialGraph.domain.usecase;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.IUserApiPort;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.tweet.domain.model.TweetDomain;

import java.util.ArrayList;
import java.util.List;

public class UserUseCase implements IUserApiPort {
    private IUserInfraPort userInfraPort;

    public UserUseCase(IUserInfraPort userInfraPort) {
        this.userInfraPort = userInfraPort;
    }

    @Override
    public UserDomain save(UserDomain user) {
        user.setConversations(new ArrayList<ConversationDomain>());
        user.setRetweets(new ArrayList<TweetDomain>());
        user.setSharedTweets(new ArrayList<TweetDomain>(0));
        user.setTweets(new ArrayList<TweetDomain>());
        return userInfraPort.saveUser(user);
    }

    @Override
    public UserDomain findUserById(Long userId) {
        return userInfraPort.findUserById(userId);
    }

    @Override
    public List<UserDomain> getAll() {
        return userInfraPort.getAllUsers();
    }

    @Override
    public List<UserDomain> getAllFollowed(Long userId) {
        return userInfraPort.getAllFollowed(userId);
    }

}

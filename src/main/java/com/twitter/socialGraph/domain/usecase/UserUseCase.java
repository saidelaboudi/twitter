package com.twitter.socialGraph.domain.usecase;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.IUserApiPort;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.socialGraph.infra.model.SocialGraph;

import java.util.ArrayList;
import java.util.List;

public class UserUseCase implements IUserApiPort {
    private IUserInfraPort userInfraPort;
    @Override
    public UserDomain save(UserDomain user) {
        user.setConversations(new ArrayList<>());
        user.setRetweets(new ArrayList<>());
        user.setSharedTweets(new ArrayList<>());
        user.setTweets(new ArrayList<>());
        user.setSocialGraph(new SocialGraphDomain());
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
}

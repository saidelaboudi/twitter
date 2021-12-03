package com.twitter.socialGraph.infra.adapter;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import com.twitter.socialGraph.infra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class SocialGraphAdapter implements ISocialGraphInfrastructure , IUserInfraPort {
    @Autowired
    private IUserService userServices;
    @Autowired
    private ISocialGraphService graphServices;
    public void reportUser(Long currentUserId, Long userId) {

    }

    public void followUser(Long currentUserId, Long userId) {

    }

    public void blockUser(Long currentUserId, Long userId) {

    }

    @Override
    public UserDomain findUserById(Long userId) {
        return userServices.findUserById(userId).toDomain();
    }

    @Override
    public void updateUser(UserDomain user) {
        userServices.update(user.toInfra());
    }

    @Override
    public SocialGraphDomain findSocialGraph(UserDomain currentUserDomain) {
        return graphServices.findSocialGraphByOwner(currentUserDomain).toDomain();
    }

    @Override
    public SocialGraphDomain update(SocialGraphDomain socialGraphDomain) {
        return graphServices.update(socialGraphDomain.toInfra()).toDomain();
    }
}

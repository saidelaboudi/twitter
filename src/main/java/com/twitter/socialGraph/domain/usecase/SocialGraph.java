package com.twitter.socialGraph.domain.usecase;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.ISocialGraphAPI;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;

public class SocialGraph implements ISocialGraphAPI {
    private ISocialGraphInfrastructure iSocialGraphInfrastructure;
    private IUserInfraPort iUserInfraPort;

    public SocialGraph(ISocialGraphInfrastructure iSocialGraphInfrastructure, IUserInfraPort iUserInfraPort) {
        this.iSocialGraphInfrastructure = iSocialGraphInfrastructure;
        this.iUserInfraPort = iUserInfraPort;
    }

    public SocialGraphDomain reportUser(Long currentUserId, Long userId) {
        UserDomain currentUser = iUserInfraPort.findUserById(userId);
        UserDomain reportedUser = iUserInfraPort.findUserById(userId);
        SocialGraphDomain socialGraph = iSocialGraphInfrastructure.findSocialGraph(currentUser);
        socialGraph.getReported().add(reportedUser);
        return iSocialGraphInfrastructure.update(socialGraph);
    }

    public SocialGraphDomain followUser(Long currentUserId, Long userId) {
        UserDomain currentUser = iUserInfraPort.findUserById(userId);
        UserDomain followedUser = iUserInfraPort.findUserById(userId);
        SocialGraphDomain socialGraph = iSocialGraphInfrastructure.findSocialGraph(currentUser);
        socialGraph.getFollowed().add(followedUser);
        return iSocialGraphInfrastructure.update(socialGraph);
    }

    public SocialGraphDomain blockUser(Long currentUserId, Long userId) {
        UserDomain currentUser = iUserInfraPort.findUserById(userId);
        UserDomain blockedUser = iUserInfraPort.findUserById(userId);
        SocialGraphDomain socialGraph = iSocialGraphInfrastructure.findSocialGraph(currentUser);
        socialGraph.getBlocked().add(blockedUser);
        return iSocialGraphInfrastructure.update(socialGraph);
    }
}

package com.twitter.socialGraph.domain.usecase;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.ISocialGraphAPI;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;

public class UserCase implements ISocialGraphAPI {
    private ISocialGraphInfrastructure iSocialGraphInfrastructure;
    private IUserInfraPort iUserInfraPort;
    public void reportUser(Long currentUserId, Long userId) {
        UserDomain currentUserDomain = iUserInfraPort.findUserById(userId);
        UserDomain reportedUserDomain = iUserInfraPort.findUserById(userId);
        SocialGraphDomain socialGraphDomain = iSocialGraphInfrastructure.findSocialGraph(currentUserDomain);
        socialGraphDomain.report(reportedUserDomain);
        iSocialGraphInfrastructure.update(socialGraphDomain);
    }

    public void followUser(Long currentUserId, Long userId) {
        iSocialGraphInfrastructure.followUser(currentUserId,userId);
    }

    public void blockUser(Long currentUserId, Long userId) {
        iSocialGraphInfrastructure.blockUser(currentUserId,userId);
    }
}

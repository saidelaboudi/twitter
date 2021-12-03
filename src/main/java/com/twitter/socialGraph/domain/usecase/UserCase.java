package com.twitter.socialGraph.domain.usecase;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.ISocialGraphAPI;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.domain.port.infra.IUserInfrastructure;

public class UserCase implements ISocialGraphAPI {
    private ISocialGraphInfrastructure iSocialGraphInfrastructure;
    private IUserInfrastructure iUserInfrastructure;
    public void reportUser(Long currentUserId, Long userId) {
        UserDomain currentUserDomain = iUserInfrastructure.findUserById(userId);
        UserDomain reportedUserDomain = iUserInfrastructure.findUserById(userId);
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

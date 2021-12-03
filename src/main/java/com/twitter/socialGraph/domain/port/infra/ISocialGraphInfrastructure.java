package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;

public interface ISocialGraphInfrastructure  {
    public void reportUser(Long currentUserId,Long userId);
    public void followUser(Long currentUserId,Long userId);
    public void blockUser(Long currentUserId,Long userId);
    public UserDomain findUserById(Long userId);

    public SocialGraphDomain findSocialGraph(UserDomain currentUserDomain);

    public SocialGraphDomain update(SocialGraphDomain socialGraphDomain);
}

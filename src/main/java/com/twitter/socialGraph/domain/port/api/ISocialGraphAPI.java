package com.twitter.socialGraph.domain.port.api;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;

public interface ISocialGraphAPI {
    public SocialGraphDomain reportUser(Long currentUserId, Long userId);
    public SocialGraphDomain followUser(Long currentUserId, Long userId);
    public SocialGraphDomain blockUser(Long currentUserId, Long userId);
}

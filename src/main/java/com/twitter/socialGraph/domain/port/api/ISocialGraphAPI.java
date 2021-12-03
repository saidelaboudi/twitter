package com.twitter.socialGraph.domain.port.api;

public interface ISocialGraphAPI {
    public void reportUser(Long currentUserId,Long userId);
    public void followUser(Long currentUserId,Long userId);
    public void blockUser(Long currentUserId,Long userId);
}

package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.infra.model.User;

public interface IUserService {
    public void reportUser(Long currentUserId,Long userId);
    public void followUser(Long currentUserId,Long userId);
    public void blockUser(Long currentUserId,Long userId);
    public User findUserById(Long userId);
    public void update(User user);
}

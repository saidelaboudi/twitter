package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.infra.model.User;

public interface IUserService {
    public User findUserById(Long userId);
    public User update(User user);
}

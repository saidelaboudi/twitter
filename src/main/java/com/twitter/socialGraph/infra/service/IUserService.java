package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;

import java.util.List;

public interface IUserService {
    public User findUserById(Long userId);
    public User update(User user);
    public List<User> findUsersByUsername(String username);
}

package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.infra.model.User;

import java.util.List;

public interface IUserService {
    public User findUserById(Long userId);

    public User update(User user);

    public List<User> findUsersByUsername(String username);

    public List<User> findUsersByUsernameContains(String username);

    public User saveUser(User toInfra);

    public List<User> getAllUsers();
}

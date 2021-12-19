package com.twitter.socialGraph.domain.port.api;

import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface IUserApiPort {
    UserDomain save(UserDomain user);
    UserDomain findUserById(Long userId);
    List<UserDomain> getAll();
}

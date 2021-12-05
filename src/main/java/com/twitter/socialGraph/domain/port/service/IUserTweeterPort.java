package com.twitter.socialGraph.domain.port.service;

import com.twitter.socialGraph.domain.model.UserDomain;

public interface IUserTweeterPort {
    UserDomain findUserById(Long userId);

    UserDomain updateUser(UserDomain owner);
}
